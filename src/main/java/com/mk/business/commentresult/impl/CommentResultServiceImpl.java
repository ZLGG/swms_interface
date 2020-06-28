package com.mk.business.commentresult.impl;

import com.alibaba.fastjson.JSONObject;
import com.mk.business.Constance.Constance;
import com.mk.business.bidexpert.model.BidExpertVo;
import com.mk.business.commentindex.checkmodel.CommentResultPriceCheck;
import com.mk.business.commentindex.dao.CommentIndexDao;
import com.mk.business.commentindex.model.CommentResultPrice;
import com.mk.business.commentresult.checkmodel.CommentResultCheck;
import com.mk.business.commentresult.checkmodel.CommentResultDetailCheck;
import com.mk.business.commentresult.dao.CommentResultDao;
import com.mk.business.commentresult.model.CommentResult;
import com.mk.business.commentresult.model.CommentResultDetail;
import com.mk.business.commentresult.service.CommentResultService;
import com.mk.business.commentresult.vo.CommenResultVO;
import com.mk.business.commonutils.service.CommonUtilsService;
import com.mk.business.optionlist.model.Optionlist;
import com.mk.business.optionlist.service.OptionlistService;
import com.mk.business.project.model.Project;
import com.mk.business.project.Impl.ProjectServiceImpl;
import com.mk.business.project.service.ProjectService;
import com.mk.business.projpectresponse.dao.ProjectResponseDao;
import com.mk.utils.enums.TablesEnum;
import com.mk.utils.model.ReturnMessage;
import com.mk.utils.request.RequestInfoVo;
import com.mk.utils.util.ListUtil;
import com.mk.utils.util.UUIDGenerator;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Primary
public class CommentResultServiceImpl implements CommentResultService {

    @Autowired
    private CommentResultDao commentResultDao;

    @Autowired
    private CommonUtilsService commonUtilsService;

    @Autowired
    private CommentIndexDao commentIndexDao;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private OptionlistService optionlistService;


    @Transactional
    @Override
    public ReturnMessage saveOrUpdateCommentResult(RequestInfoVo requestInfoVo) throws Exception {

        CommenResultVO commenResultVO = null;
        String messageDecryptStringToBase64 = null;
        //解密数据
        try {
            messageDecryptStringToBase64 = requestInfoVo.MessageDecryptStringToBase64();
        } catch (Exception e) {
            throw new Exception("解密失败" + e.getMessage());
        }
        try {
            commenResultVO = JSONObject.parseObject(messageDecryptStringToBase64, CommenResultVO.class);
        } catch (Exception e) {
            throw new Exception("数据解析异常" + e.getMessage());
        }


        //校验项目interfacecode与dataresourse
        checkRequestParam(commenResultVO.getInterfaceCode(), commenResultVO.getDataResource());
        //查询项目
        Project oldProject = projectService.getProject(commenResultVO.getInterfaceCode(), commenResultVO.getDataResource());
        if (oldProject == null) {
            throw new Exception(commenResultVO.getInterfaceCode() + "该项目不存在");
        }
        //全删一次防止多次调用
        delCommentResultAndCommentResultDetail(oldProject.getProjectGuid());
        //插入评审结果
        List<CommentResult> commentResultList = commenResultVO.getCommentResultList();
        if (CollectionUtils.isNotEmpty(commentResultList)) {
            for (CommentResult commentResult : commentResultList) {
                CommentResultCheck commentResultCheck = ListUtil.copy(commentResult, CommentResultCheck.class);
                //校验不能为空参数
                /*List<String> checkRequestParam = commonUtilsService.checkRequestParam(commentResultCheck);
                if (CollectionUtils.isNotEmpty(checkRequestParam)) {
                    throw new Exception(checkRequestParam.toString() + "字段为空");
                }*/
                //校验采购评审结果 枚举值正确性
                //checkCommentResultEnums(commentResult);

                //查询标项guid
                if (StringUtils.isNotEmpty(commentResult.getBidItemGuid())) {
                    String bidItemGuid = commonUtilsService.getGuidByCodeAndResource(TablesEnum.BIDITEM.getKey(), commentResult.getBidItemGuid(), oldProject.getDataResource(), "BidItem_Guid");
                    if (StringUtils.isEmpty(bidItemGuid)) {
                        throw new Exception(commentResult.getBidItemGuid() + "标项不存在");
                    }
                    commentResult.setBidItemGuid(bidItemGuid);
                }
                commentResult.setProjectGuid(oldProject.getProjectGuid());
                commentResult.setCommentResultGuid(UUIDGenerator.randomUUID());
                commentResultDao.insertCommentResult(commentResult);

                //插入采购评审结果明细
                List<CommentResultDetail> commentResultDetailList = commentResult.getCommentResultDetailList();
                if (CollectionUtils.isNotEmpty(commentResultDetailList)) {
                    for (CommentResultDetail commentResultDetail : commentResultDetailList) {
                        //校验不能为空参数
                        CommentResultDetailCheck commentResultDetailCheck = ListUtil.copy(commentResultDetail, CommentResultDetailCheck.class);
                        List<String> commentResultDetailCheckParam = commonUtilsService.checkRequestParam(commentResultDetailCheck);
                        if (CollectionUtils.isNotEmpty(commentResultDetailCheckParam)) {
                            throw new Exception(commentResultDetailCheckParam.toString() + "字段为空");
                        }

                        if (commentResultDetail.getIsHit() != null) {
                            Optionlist isHitOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Is_Hit, commentResultDetail.getIsHit().toString());
                            if (isHitOption == null) {
                                throw new Exception(commentResultDetail.getIsHit() + "是否中标/成交,不存在该值");
                            }
                        }
                        if (commentResultDetail.getIsConform() != null) {
                            Optionlist isConformOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Is_Conform, commentResultDetail.getIsConform().toString());
                            if (isConformOption == null) {
                                throw new Exception(commentResultDetail.getIsConform() + "符合性评审结果不存在该值");
                            }
                        }

                        //查询投标登记 responseguid
                        String projectResponseGuid = commonUtilsService.getGuidByCodeAndResource(TablesEnum.PROJECTRESPONSE.getKey(), commentResultDetail.getResponseGuid(), oldProject.getDataResource(), "Response_Guid");
                        if (StringUtils.isEmpty(projectResponseGuid)) {
                            throw new Exception(commentResultDetail.getResponseGuid() + "投标登记不存在");
                        }
                        commentResultDetail.setResponseGuid(projectResponseGuid);
                        commentResultDetail.setCommentResultDetailGuid(UUIDGenerator.randomUUID());
                        commentResultDetail.setCommentResultGuid(commentResult.getCommentResultGuid());
                        commentResultDao.insertCommentResultDetail(commentResultDetail);

                        //插入采购评审结果分项报价
                        List<CommentResultPrice> commentResultPriceList = commentResultDetail.getCommentResultPriceList();
                        if (CollectionUtils.isNotEmpty(commentResultPriceList)) {
                            for (CommentResultPrice commentResultPrice : commentResultPriceList) {
                                //校验不为空参数
                                CommentResultPriceCheck commentResultPriceCheck = ListUtil.copy(commentResultPrice, CommentResultPriceCheck.class);
                                List<String> commentResultPriceCheckParam = commonUtilsService.checkRequestParam(commentResultPriceCheck);
                                if (CollectionUtils.isNotEmpty(commentResultPriceCheckParam)) {
                                    throw new Exception(commentResultPriceCheckParam.toString() + "字段为空");
                                }
                                if (commentResult.getCalculateType() != null) {
                                    Optionlist priceTypeOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Price_Type, commentResultPrice.getPriceType().toString());
                                    if (priceTypeOption == null) {
                                        throw new Exception(commentResult.getCalculateType() + "商务报价类型,不存在该值");
                                    }
                                }
                                if (commentResult.getCalculateType() != null) {
                                    Optionlist includOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Includ, commentResultPrice.getInclud().toString());
                                    if (includOption == null) {
                                        throw new Exception(commentResult.getCalculateType() + "商务报价是否计入总价,不存在该值");
                                    }
                                }
                                //获取评审指标guid
                                if (StringUtils.isNotEmpty(commentResultPrice.getCommentIndexGuid())) {
                                    String commentIndexGuid = commonUtilsService.getGuidByCodeAndResource(TablesEnum.COMMENTINDEX.getKey(), commentResultPrice.getCommentIndexGuid(), oldProject.getDataResource(), "CommentIndex_Guid");
                                    if (StringUtils.isEmpty(commentIndexGuid)) {
                                        throw new Exception(commentResultPrice.getCommentIndexGuid() + "评审指标不存在");
                                    }
                                    commentResultPrice.setCommentIndexGuid(commentIndexGuid);
                                } else {
                                    commentResultPrice.setCommentIndexGuid(null);
                                }
                                commentResultPrice.setCommentResultPriceGuid(UUIDGenerator.randomUUID());
                                commentResultPrice.setCommentResultDetailGuid(commentResultDetail.getCommentResultDetailGuid());
                                commentIndexDao.insertCommentResultPrice(commentResultPrice);
                            }
                        }
                    }
                }
            }
        }
        return new ReturnMessage().ReturnMessageSuccess("保存成功");
    }

    /**
     * 校验采购评审结果 枚举值正确性
     *
     * @param commentResult
     */
    private void checkCommentResultEnums(CommentResult commentResult) throws Exception {
        if (commentResult.getCalculateType() != null) {
            Optionlist calculateTypeOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Calculate_Type, commentResult.getCalculateType().toString());
            if (calculateTypeOption == null) {
                throw new Exception(commentResult.getCalculateType() + "项目评审方式不存在该值");
            }
        }
        if (commentResult.getCutCeilFloor() != null) {
            Optionlist cutCeilFloorOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Cut_Ceil_Floor, commentResult.getCutCeilFloor().toString());
            if (cutCeilFloorOption == null) {
                throw new Exception(commentResult.getCutCeilFloor() + "是否去除最高最低价，不存在该值");
            }
        }
        if (commentResult.getIsSucceed() != null) {
            Optionlist isSucceedOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Is_Succeed, commentResult.getIsSucceed().toString());
            if (isSucceedOption == null) {
                throw new Exception(commentResult.getIsSucceed() + "专家评审结果采购是否成功，不存在该值");
            }
        }
        if (commentResult.getPurIsSucceed() != null) {
            Optionlist purIsSucceedOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_PurIs_Succeed, commentResult.getPurIsSucceed().toString());
            if (purIsSucceedOption == null) {
                throw new Exception(commentResult.getPurIsSucceed() + "采购是否成功，不存在该值");
            }
        }
    }

    /**
     * 全删 采购评审结果 采购评审结果明细 明细报价
     *
     * @param projectGuid
     */
    @Override
    public void delCommentResultAndCommentResultDetail(String projectGuid) {
        //查询该采购项目对应的 采购评审结果
        List<String> commentResultGuidList = commentResultDao.getCommentResultList(projectGuid);
        //根据采购评审结果guid，删除采购评审结果明细
        if (CollectionUtils.isNotEmpty(commentResultGuidList)) {
            for (String commentResuletGuid : commentResultGuidList) {
                //根据采购评审结果明细guid，查询采购评审结果分项报价表guid
                List<String> commentResultDetailGuids = commentResultDao.getCommentResultDetailGuids(commentResuletGuid);
                if (CollectionUtils.isNotEmpty(commentResultDetailGuids)) {
                    for (String commentResultDetailGuid : commentResultDetailGuids) {
                        //删除采购评审结果分项报价
                        commentResultDao.delCommentResultPrice(commentResultDetailGuid);
                    }
                }
                commentResultDao.delCommentResultDetail(commentResuletGuid);
            }
            //删除该采购项目对应的子表 T_A_CommentResult 采购评审结果
            commentResultDao.delCommentResult(projectGuid);
        }

    }

    private void checkRequestParam(String interfaceCode, String dataResource) throws Exception {
        if (StringUtils.isBlank(interfaceCode)
                || StringUtils.isBlank(dataResource)) {
            throw new Exception("保存失败：项目interfaceCode或dataResource为空");
        }
        Optionlist dataResourceOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Data_Resource, dataResource);
        if (dataResourceOption == null) {
            throw new Exception(dataResource + "不存在该项目数据来源");
        }
    }
}
