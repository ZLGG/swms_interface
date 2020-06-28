package com.mk.business.commentindex.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mk.business.Constance.Constance;
import com.mk.business.commentindex.checkmodel.CommentIndexCheck;
import com.mk.business.commentindex.dao.CommentIndexDao;
import com.mk.business.commentindex.model.CommentIndex;
import com.mk.business.commentindex.service.CommentIndexService;
import com.mk.business.commentindex.vo.CommentIndexVO;
import com.mk.business.commonutils.service.CommonUtilsService;
import com.mk.business.optionlist.model.Optionlist;
import com.mk.business.optionlist.service.OptionlistService;
import com.mk.business.project.model.Project;
import com.mk.business.project.Impl.ProjectServiceImpl;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 评审指标
 */
@Service
@Primary
public class CommentIndexServiceImpl implements CommentIndexService {

    @Autowired
    private CommentIndexDao commentIndexDao;

    @Autowired
    private CommonUtilsService commonUtilsService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private OptionlistService optionlistService;

    @Override
    @Transactional
    public ReturnMessage saveOrUpdateCommentIndex(RequestInfoVo requestInfoVo) throws Exception {
        CommentIndexVO commentIndexVO = null;

        String messageDecryptStringToBase64 = null;

        //解密数据
        try {
            messageDecryptStringToBase64 = requestInfoVo.MessageDecryptStringToBase64();
        } catch (Exception e) {
            throw new Exception("解密失败" + e.getMessage());
        }
        try {
            commentIndexVO = JSONObject.parseObject(messageDecryptStringToBase64, CommentIndexVO.class);
        } catch (Exception e) {
            throw new Exception("数据解析异常" + e.getMessage());
        }

        //校验项目主键与数据来源
        checkRequestParam(commentIndexVO.getInterfaceCode(), commentIndexVO.getDataResource());
        //查询项目
        Project oldProject = projectService.getProject(commentIndexVO.getInterfaceCode(), commentIndexVO.getDataResource());
        if (oldProject == null) {
            throw new Exception(commentIndexVO.getInterfaceCode() + ":项目不存在");
        }
        //全删一次 防止多次调用
        delCommentIndexByProject(oldProject.getProjectGuid());
        //插入子表 评审指标
        List<CommentIndex> commentIndexList = commentIndexVO.getCommentIndexList();
        if (CollectionUtils.isNotEmpty(commentIndexList)) {
            for (CommentIndex commentIndex : commentIndexList) {
                CommentIndexCheck commentIndexCheck = ListUtil.copy(commentIndex, CommentIndexCheck.class);
                //检验为空的参数
                /*List<String> checkRequestParam = commonUtilsService.checkRequestParam(commentIndexCheck);
                if (CollectionUtils.isNotEmpty(checkRequestParam)) {
                    throw new Exception("评审指标" + commentIndex.getInterfaceCode() + ":" + checkRequestParam.toString() + "字段为空");
                }*/
                //校验评审指标枚举值的正确性
                //checkCommentIndexEnums(commentIndex);

                //查询标项guid
                if (StringUtils.isNotEmpty(commentIndex.getBidGuid())) {
                    String bidItemGuid = commonUtilsService.getGuidByCodeAndResource(TablesEnum.BIDITEM.getKey(), commentIndex.getBidGuid(), oldProject.getDataResource(), "BidItem_Guid");
                    if (StringUtils.isEmpty(bidItemGuid)) {
                        throw new Exception(commentIndex.getBidGuid() + ":标项不存在");
                    }
                    commentIndex.setBidGuid(bidItemGuid);
                }
                //查询父id
                if (StringUtils.isNotEmpty(commentIndex.getCommentIndexPGuid())) {
                    Map condition = new HashMap<String, String>();
                    condition.put("commentIndexPGuid", commentIndex.getCommentIndexPGuid());
                    condition.put("dataResource", commentIndex.getDataResource());
                    String CommentIndexPGuid = commentIndexDao.getCommentIndexPGuid(condition);
                    if (StringUtils.isEmpty(CommentIndexPGuid)) {
                        throw new Exception(commentIndex.getCommentIndexPGuid() + ":父指标不存在");
                    }
                    commentIndex.setCommentIndexPGuid(CommentIndexPGuid);
                } else {
                    commentIndex.setCommentIndexPGuid(null);
                }
                commentIndex.setProjectGuid(oldProject.getProjectGuid());
                commentIndex.setCommentIndexGuid(UUIDGenerator.randomUUID());
                commentIndexDao.insertCommentIndex(commentIndex);
            }

        }
        ReturnMessage returnMessage = new ReturnMessage().ReturnMessageSuccess("评审指标保存成功");

        return returnMessage;
    }

    /**
     * 校验评审指标枚举值的正确性
     *
     * @param commentIndex
     */
    private void checkCommentIndexEnums(CommentIndex commentIndex) throws Exception {
        /*if (commentIndex.getPriceType() != null) {
            Optionlist priceTypeOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Price_Type, commentIndex.getPriceType().toString());
            if (priceTypeOption == null) {
                throw new Exception(commentIndex.getPriceType() + "该商务报价类型不存在");
            }
        }*/
        if (commentIndex.getInclud() != null) {
            Optionlist includOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Includ, commentIndex.getInclud().toString());
            if (includOption == null) {
                throw new Exception(commentIndex.getInclud() + "该商务报价是否计入总价，不存在");
            }
        }
        if (commentIndex.getCommentIndexType() != null) {
            Optionlist commentIndexTypeOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_CommentIndex_Type, commentIndex.getCommentIndexType().toString());
            if (commentIndexTypeOption == null) {
                throw new Exception(commentIndex.getCommentIndexType() + "该评审指标类型不存在");
            }
        }
        if (commentIndex.getConformType() != null) {
            Optionlist conformTypeOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Conform_Type, commentIndex.getConformType().toString());
            if (conformTypeOption == null) {
                throw new Exception(commentIndex.getConformType() + "该符合性指标类型不存在");
            }
        }
        Optionlist dataResourceOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Data_Resource, commentIndex.getDataResource());
        if (dataResourceOption == null) {
            throw new Exception(commentIndex.getDataResource() + "不存在该数据来源");
        }
    }

    @Override
    public void delCommentIndexByProject(String projectGuid) {
        List<String> commentIndexGuidList = commentIndexDao.getCommentIndexGuids(projectGuid);
        recursiveDel(commentIndexGuidList);
    }

    /**
     * 递归遍历删除父指标
     *
     * @param commentIndexGuids
     */
    public void recursiveDel(List<String> commentIndexGuids) {
        if (CollectionUtils.isNotEmpty(commentIndexGuids)) {
            for (String commentIndexGuid : commentIndexGuids) {
                List<String> commentIndexGuidList = commentIndexDao.getCommentIndexByPGuid(commentIndexGuid);
                if (CollectionUtils.isNotEmpty(commentIndexGuidList)) {
                    recursiveDel(commentIndexGuidList);
                }
                commentIndexDao.delCommentIndexByCommentIndexGuid(commentIndexGuid);
            }
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
