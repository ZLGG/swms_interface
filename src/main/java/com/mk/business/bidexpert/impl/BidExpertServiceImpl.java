package com.mk.business.bidexpert.impl;

import com.alibaba.fastjson.JSONObject;
import com.mk.business.Constance.Constance;
import com.mk.business.bidexpert.checkmodel.BidExpertCheck;
import com.mk.business.bidexpert.dao.BidExpertDao;
import com.mk.business.bidexpert.model.BidExpert;
import com.mk.business.bidexpert.model.BidExpertVo;
import com.mk.business.bidexpert.service.BidExpertService;
import com.mk.business.commentindex.checkmodel.CommentIndexPointCheck;
import com.mk.business.commentindex.dao.CommentIndexDao;
import com.mk.business.commentindex.model.CommentIndexPoint;
import com.mk.business.commonutils.service.CommonUtilsService;
import com.mk.business.expert.service.ExpertService;
import com.mk.business.optionlist.model.Optionlist;
import com.mk.business.optionlist.service.OptionlistService;
import com.mk.business.project.model.Project;
import com.mk.business.project.service.ProjectService;
import com.mk.business.project.vo.ProjectVO;
import com.mk.utils.enums.TablesEnum;
import com.mk.utils.model.ReturnMessage;
import com.mk.utils.request.RequestInfoVo;
import com.mk.utils.request.ResponseInfoVo;
import com.mk.utils.util.ListUtil;
import com.mk.utils.util.UUIDGenerator;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 标项评标专家
 */
@Service
@Primary
public class BidExpertServiceImpl implements BidExpertService {

    @Autowired
    private BidExpertDao bidExpertDao;

    @Autowired
    private CommonUtilsService commonUtilsService;

    @Autowired
    private CommentIndexDao commentIndexDao;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private OptionlistService optionlistService;

    @Autowired
    private ExpertService expertService;


    @Override
    @Transactional
    public ReturnMessage saveOrUpdateBidExpert(RequestInfoVo requestInfoVo) throws Exception {

        BidExpertVo bidExpertVo = null;
        String messageDecryptStringToBase64 = null;
        //解密数据
        try {
            messageDecryptStringToBase64 = requestInfoVo.MessageDecryptStringToBase64();
        } catch (Exception e) {
            throw new Exception("解密失败" + e.getMessage());
        }
        try {
            bidExpertVo = JSONObject.parseObject(messageDecryptStringToBase64, BidExpertVo.class);
        } catch (Exception e) {
            throw new Exception("数据解析异常" + e.getMessage());
        }


        //校验项目主键与来源
        checkRequestParam(bidExpertVo.getInterfaceCode(), bidExpertVo.getDataResource());
        //查询项目
        Project oldProject = projectService.getProject(bidExpertVo.getInterfaceCode(), bidExpertVo.getDataResource());
        if (oldProject == null) {
            throw new Exception(bidExpertVo.getInterfaceCode() + ":项目不存在");
        }
        //全删一次,防止多次调用
        delChildBidExpertAndCommentIndexPoint(oldProject.getProjectGuid());

        // 全插标项评审专家  与 评审专家评分
        List<BidExpert> bidExpertList = bidExpertVo.getBidExpertList();
        if (CollectionUtils.isNotEmpty(bidExpertList)) {
            for (BidExpert bidExpert : bidExpertList) {
                //校验不为空参数
                BidExpertCheck bidExpertCheck = ListUtil.copy(bidExpert, BidExpertCheck.class);
                List<String> checkRequestParam = commonUtilsService.checkRequestParam(bidExpertCheck);
                if (CollectionUtils.isNotEmpty(checkRequestParam)) {
                    throw new Exception("评审专家" + bidExpert.getInterfaceCode() + ":" + checkRequestParam.toString() + "字段为空");
                }
                //校验标项评审专家 枚举值的正确性
                //checkBidExpertEnums(bidExpert);

                //获取标项id
                if (StringUtils.isNotEmpty(bidExpert.getBidItemGuid())) {
                    String bidItemGuid = commonUtilsService.getGuidByCodeAndResource(TablesEnum.BIDITEM.getKey(), bidExpert.getBidItemGuid(), bidExpertVo.getDataResource(), "BidItem_Guid");
                    if (StringUtils.isEmpty(bidItemGuid)) {
                        throw new Exception(bidExpert.getBidItemGuid() + ":标项不存在");
                    }
                    bidExpert.setBidItemGuid(bidItemGuid);
                }
                bidExpert.setBidExpertGuid(UUIDGenerator.randomUUID());
                bidExpert.setProjectGuid(oldProject.getProjectGuid());
                bidExpertDao.insert(bidExpert);
                List<CommentIndexPoint> commentIndexPointList = bidExpert.getCommentIndexPointList();
                if (CollectionUtils.isNotEmpty(commentIndexPointList)) {
                    for (CommentIndexPoint commentIndexPoint : commentIndexPointList) {
                        //校验不为空参数
                        CommentIndexPointCheck commentIndexPointCheck = ListUtil.copy(commentIndexPoint, CommentIndexPointCheck.class);
                        /*List<String> commentIndexPointCheckParam = commonUtilsService.checkRequestParam(commentIndexPointCheck);
                        if (CollectionUtils.isNotEmpty(commentIndexPointCheckParam)) {
                            throw new Exception("评审专家记录分" + commentIndexPointCheckParam.toString() + "字段为空");
                        }*/
                        //获取投标登记guid
                        /*String responseguid = commonUtilsService.getGuidByCodeAndResource(TablesEnum.PROJECTRESPONSE.getKey(), commentIndexPoint.getResponseGuid(), bidExpertVo.getDataResource(), "Response_Guid");
                        if (StringUtils.isEmpty(responseguid)) {
                            throw new Exception(commentIndexPoint.getResponseGuid() + ":投标登记不存在");
                        }
                        commentIndexPoint.setResponseGuid(responseguid);
*/
                        if (StringUtils.isNotEmpty(commentIndexPoint.getResponseGuid())) {
                            String responseguid = commonUtilsService.getGuidByCodeAndResource(TablesEnum.PROJECTRESPONSE.getKey(), commentIndexPoint.getResponseGuid(), bidExpertVo.getDataResource(), "Response_Guid");
                            commentIndexPoint.setResponseGuid(responseguid);
                        }

                        /*//获取评分指标guid
                        String commentIndexGuid = commonUtilsService.getGuidByCodeAndResource(TablesEnum.COMMENTINDEX.getKey(), commentIndexPoint.getCommentIndexGuid(), bidExpertVo.getDataResource(), "CommentIndex_Guid");
                        if (StringUtils.isEmpty(commentIndexGuid)) {
                            throw new Exception(commentIndexPoint.getCommentIndexGuid() + ":评审指标不存在");
                        }*/
                        if (StringUtils.isNotEmpty(commentIndexPoint.getCommentIndexGuid())) {
                            String commentIndexGuid = commonUtilsService.getGuidByCodeAndResource(TablesEnum.COMMENTINDEX.getKey(), commentIndexPoint.getCommentIndexGuid(), bidExpertVo.getDataResource(), "CommentIndex_Guid");
                            commentIndexPoint.setCommentIndexGuid(commentIndexGuid);
                        }

                        commentIndexPoint.setBidExpertGuid(bidExpert.getBidExpertGuid());
                        commentIndexPoint.setCommentIndexPointGuid(UUIDGenerator.randomUUID());
                        //commentIndexPoint.setCommentIndexGuid(commentIndexGuid);
                        commentIndexDao.insertCommentIndexPoint(commentIndexPoint);
                    }
                }
            }

        }

        return new ReturnMessage().ReturnMessageSuccess("项评审专家信息保存成功");
    }

    /**
     * 校验标项评审专家 枚举值的正确性
     *
     * @param bidExpert
     */
    private void checkBidExpertEnums(BidExpert bidExpert) throws Exception {
        if (bidExpert.getIsTeamLeader() != null) {
            Optionlist isTeamLeaderOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Is_Team_Leader, bidExpert.getIsTeamLeader().toString());
            if (isTeamLeaderOption == null) {
                throw new Exception(bidExpert.getIsTeamLeader() + "是否评标组长，不存在该值");
            }
        }
        if (bidExpert.getIsOwnerRepresentative() != null) {
            Optionlist isOwnerRepresentativeOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Is_Owner_Representative, bidExpert.getIsOwnerRepresentative().toString());
            if (isOwnerRepresentativeOption == null) {
                throw new Exception(bidExpert.getIsOwnerRepresentative() + "是否业主代表，不存在该值");
            }
        }
        if (StringUtils.isNotEmpty(bidExpert.getDataResource())) {
            Optionlist dataResourceOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Data_Resource, bidExpert.getDataResource());
            if (dataResourceOption == null) {
                throw new Exception(bidExpert.getDataResource() + "不存在该数据来源");
            }
        }
        if (StringUtils.isNotEmpty(bidExpert.getExpertGuid())) {
            Integer count = expertService.getExpert(bidExpert.getExpertGuid());
            if (count == 0) {
                throw new Exception(bidExpert.getExpertGuid() + "不存在该专家");
            }
        }

    }

    /**
     * 全删项目子表 标项评审专家 和 评审专家评分
     *
     * @param projectGuid
     */
    @Override
    public void delChildBidExpertAndCommentIndexPoint(String projectGuid) {
        //根据项目guid查询所有标项评审专家
        List<String> bidExpertGuidListByProjectGuid = bidExpertDao.getBidExpertByProjectGuid(projectGuid);
        if (CollectionUtils.isNotEmpty(bidExpertGuidListByProjectGuid)) {
            for (String bidExpertGuid : bidExpertGuidListByProjectGuid) {
                //根据标项评审专家guid删除评分记录
                commentIndexDao.delCommentIndexPointByBidExpertGuid(bidExpertGuid);
            }
        }
        //删除该项目的所有标项评审专家
        bidExpertDao.delAllbidExpertByProject(projectGuid);
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
