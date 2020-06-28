package com.mk.business.project.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mk.business.Constance.Constance;
import com.mk.business.agent.service.AgentService;
import com.mk.business.bidexpert.service.BidExpertService;
import com.mk.business.commentindex.service.CommentIndexService;
import com.mk.business.commentresult.service.CommentResultService;
import com.mk.business.commonutils.service.CommonUtilsService;
import com.mk.business.optionlist.model.Optionlist;
import com.mk.business.optionlist.service.OptionlistService;
import com.mk.business.organization.service.OrganizationService;
import com.mk.business.project.checkmodel.BidItemCheck;
import com.mk.business.project.dao.ProjectDao;
import com.mk.business.project.model.BidItem;
import com.mk.business.project.model.Project;
import com.mk.business.project.checkmodel.ProjectCheck;
import com.mk.business.project.model.ProjectToBuyPlan;
import com.mk.business.project.service.ProjectService;
import com.mk.business.project.vo.ProjectVO;
import com.mk.business.projpectresponse.service.ProjectResponseService;
import com.mk.business.region.service.RegionService;
import com.mk.utils.enums.TablesEnum;
import com.mk.utils.model.ReturnMessage;
import com.mk.utils.request.RequestInfoVo;
import com.mk.utils.request.ResponseInfoVo;
import com.mk.utils.util.ListUtil;
import com.mk.utils.util.UUIDGenerator;
import com.sun.org.apache.xerces.internal.xs.StringList;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Primary
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private CommonUtilsService commonUtilsService;

    @Autowired
    private CommentIndexService commentIndexService;

    @Autowired
    private BidExpertService bidExpertService;

    @Autowired
    private CommentResultService commentResultService;

    @Autowired
    private ProjectResponseService projectResponseService;

    @Autowired
    private OptionlistService optionlistService;

    @Autowired
    private AgentService agentService;

    @Autowired
    private RegionService regionService;

    @Autowired
    private OrganizationService organizationService;

    @Override
    @Transactional
    public ReturnMessage saveOrUpdateProject(RequestInfoVo requestInfoVo) throws Exception {
        ProjectVO projectVO = null;

        String messageDecryptStringToBase64 = null;

        //解密数据
        try {
            messageDecryptStringToBase64 = requestInfoVo.MessageDecryptStringToBase64();
        } catch (Exception e) {
            throw new Exception("解密失败" + e.getMessage());
        }
        try {
            projectVO = JSONObject.parseObject(messageDecryptStringToBase64, ProjectVO.class);
        } catch (Exception e) {
            throw new Exception("数据解析异常" + e.getMessage());
        }


        Project project = ListUtil.copy(projectVO, Project.class);
        //校验项目主键与项目来源
        checkRequestParam(projectVO.getInterfaceCode(), projectVO.getDataResource());

        ProjectCheck projectCheck = ListUtil.copy(project, ProjectCheck.class);
        /*List checkParam = commonUtilsService.checkRequestParam(projectCheck);
        if (CollectionUtils.isNotEmpty(checkParam)) {
            throw new Exception("项目：" + project.getInterfaceCode() + checkParam.toString() + "字段为空");
        }*/
        //checkProjectEnums(project);
        //查询项目是否存在
        Project oldProject = getProject(projectVO.getInterfaceCode(), projectVO.getDataResource());
        Date currentSqlDate = commonUtilsService.getCurrentSqlDate();
        project.setBizTimeStamp(currentSqlDate);
        Date dateWithoutTime = commonUtilsService.getCurrentSqlDateWithoutTime(currentSqlDate);
        project.setBizDate(dateWithoutTime);

        if (oldProject != null) {
            //更新项目
            project.setProjectGuid(oldProject.getProjectGuid());
            //删除项目对应的所有子表
            delAllProjectChildTable(project.getProjectGuid());

            projectDao.updateProject(project);
            updateChild(projectVO, project.getProjectGuid());
            return new ReturnMessage().ReturnMessageSuccess("采购项目更新成功");
        } else {
            //插入项目
            project.setProjectGuid(UUIDGenerator.randomUUID());
            projectDao.insertProject(project);
            //插入项目子表 T_A_BidItem 与 T_A_ProjectToBuyPlan
            insertChildTable(projectVO, project.getProjectGuid());
            return new ReturnMessage().ReturnMessageSuccess("采购项目新增成功");
        }
    }

    /**
     * 校验项目的枚举值
     *
     * @param project
     */
    private void checkProjectEnums(Project project) throws Exception {

        /*if (StringUtils.isNotEmpty(project.getPlatformTypeGuid())) {
            Optionlist platformTypeOptionlist = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Platform_Type_Guid, project.getPlatformTypeGuid());
            if (platformTypeOptionlist != null) {
                throw new Exception(project.getPlatformTypeGuid() + "不存在该实施形式分类");
            }
        }
        if (StringUtils.isNotBlank(project.getPlatformGuid())) {
            Optionlist platformOptionlist = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Platform_Guid, project.getPlatformGuid());
            if (platformOptionlist == null) {
                throw new Exception(project.getPlatformGuid() + "不存在该实施形式");
            }
        }*/
        String isDeposit = String.valueOf(project.getIsDeposit());
        if (StringUtils.isNotBlank(isDeposit)) {
            Optionlist isDepositOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Is_Deposit, isDeposit);
            if (isDepositOption == null) {
                throw new Exception("isDeposit: " + isDeposit + "是否缴纳保证金，超出规定枚举范围");
            }
        }

        String isAcceptUnion = String.valueOf(project.getIsAcceptUnion());
        if (StringUtils.isNotBlank(isAcceptUnion)) {
            Optionlist isAcceptUnionOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Is_Accept_Union, isAcceptUnion);
            if (isAcceptUnionOption == null) {
                throw new Exception("isAcceptUnion: " + isAcceptUnion + "是否接受联合体投标，超出规定枚举范围");
            }
        }

        String isPriceDiscount = String.valueOf(project.getIsPriceDiscount());
        if (StringUtils.isNotBlank(isPriceDiscount)) {
            Optionlist isPriceDiscountOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Is_Price_Discount, isPriceDiscount);
            if (isPriceDiscountOption == null) {
                throw new Exception("isPriceDiscount: " + isPriceDiscount + "是否落实采购政策实行价格折扣，超出规定枚举范围");
            }
        }

        String projectState = String.valueOf(project.getProjectState());
        if (StringUtils.isNotBlank(projectState)) {
            Optionlist projectStateOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Project_State, projectState);
            if (projectStateOption == null) {
                throw new Exception("projectState: " + projectState + "该采购项目执行状态超出规定枚举范围");
            }
        }

        String purMethod = String.valueOf(project.getPurMethod());
        if (StringUtils.isNotBlank(purMethod)) {
            Optionlist purmethodOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_PurMethod, purMethod);
            if (purmethodOption == null) {
                throw new Exception("purMethod: " + purMethod + "该采购方式超出规定枚举范围");
            }
        }

        String agentType = String.valueOf(project.getAgentType());
        if (StringUtils.isNotBlank(agentType)) {
            Optionlist agentTypeOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Agent_Type, agentType);
            if (agentTypeOption == null) {
                throw new Exception("agentType: " + agentType + "该采购机构类型超出规定枚举范围");
            }
        }

        String procurementPublished = String.valueOf(project.getProcurementPublished());
        if (StringUtils.isNotBlank(procurementPublished)) {
            Optionlist procurementPublishedOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Procurement_Published, procurementPublished);
            if (procurementPublishedOption == null) {
                throw new Exception("procurementPublished: " + procurementPublished + "采购公告是否发布,超出规定枚举范围");
            }
        }

        String correctionPublished = String.valueOf(project.getCorrectionPublished());
        if (StringUtils.isNotBlank(correctionPublished)) {
            Optionlist correctionPublishedOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Correction_Published, correctionPublished);
            if (correctionPublishedOption == null) {
                throw new Exception("correctionPublished: " + correctionPublished + "更正公告是否发布,超出规定枚举范围");
            }
        }

        String resultPublished = String.valueOf(project.getResultPublished());
        if (project.getResultPublished() != null) {
            Optionlist resultPublishedOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Result_Published, resultPublished);
            if (resultPublishedOption == null) {
                throw new Exception("resultPublished: " + resultPublished + "结果公告是否发布,超出规定枚举范围");
            }
        }

        String bizValid = String.valueOf(project.getBizValid());
        if (StringUtils.isNotBlank(bizValid)) {
            Optionlist bizValidOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Biz_Valid, bizValid);
            if (bizValidOption == null) {
                throw new Exception("bizValid: " + bizValid + "业务有效标志,超出规定枚举范围");
            }
        }

        String dataResource = String.valueOf(project.getDataResource());
        if (StringUtils.isNotBlank(dataResource)) {
            Optionlist dataResourceOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Data_Resource, dataResource);
            if (dataResourceOption == null) {
                throw new Exception("dataResource: " + dataResource + "数据来源,超出规定枚举范围");
            }
        }

        // todo(新版要求删除基础数据校验)校验采购机构guid 是否存在
       /* if (StringUtils.isNotEmpty(project.getAgentGuid())) {
            Integer count = agentService.getAgent(project.getAgentGuid());
            if (count == 0) {
                throw new Exception("找不到采购机构AgentGuid: " + project.getAgentGuid() + "在数据中心对应的ID");
            }
        }
        /* //校验区域reionguid 是否存在
        Integer regionCount = regionService.getRegion(project.getRegionGuid());
        if (regionCount == 0) {
            throw new Exception("找不到采购机构RegionGuid: " + project.getRegionGuid() + "在数据中心对应的ID");
        }*/
    }

    /**
     * 删除项目所有子表
     *
     * @param projectGuid
     */
    private void delAllProjectChildTable(String projectGuid) {
        //删除项目对应的采购计划明细
        projectDao.delProjectToBuyPlan(projectGuid);

        //删除采购评审过程 结果，结果明细，明细报价表
        commentResultService.delCommentResultAndCommentResultDetail(projectGuid);

        //删除标项评审专家 以及 标项评审专家评分记录
        bidExpertService.delChildBidExpertAndCommentIndexPoint(projectGuid);

        //删除评分指标
        commentIndexService.delCommentIndexByProject(projectGuid);

        //删除投标登记 投标供应商明细
        projectResponseService.delChildProjectResponseAndBidSupplierInfo(projectGuid);
    }

    /**
     * 更新项目标项 插入T_A_ProjectToBuyPlan
     *
     * @param projectVO
     * @param projectGuid
     */
    private void updateChild(ProjectVO projectVO, String projectGuid) throws Exception {
        List<BidItem> bidItemList = projectVO.getBidItemList();
        List bidItemGuids = new ArrayList<StringList>();
        if (CollectionUtils.isNotEmpty(bidItemList)) {
            for (BidItem bidItem : bidItemList) {
                BidItemCheck bidItemCheck = ListUtil.copy(bidItem, BidItemCheck.class);
                List<String> checkRequestParam = commonUtilsService.checkRequestParam(bidItemCheck);
                if (CollectionUtils.isNotEmpty(checkRequestParam)) {
                    throw new Exception(bidItem.getInterfaceCode() + ":" + checkRequestParam.toString() + "字段为空");
                }
                //校验项目标项 枚举值的正确性
                //checkBidItemEnums(bidItem);
                bidItem.setProjectGuid(projectGuid);
                //查询项目标项是否存在
                HashMap<String, Object> condition = new HashMap<>();
                condition.put("interfaceCode", bidItem.getInterfaceCode());
                condition.put("dataResource", bidItem.getDataResource());
                BidItem oldBidItem = projectDao.getBidItemByGuid(condition);
                if (oldBidItem == null) {
                    bidItem.setBidItemGuid(UUIDGenerator.randomUUID());
                    projectDao.insertBidItem(bidItem);
                } else {
                    bidItem.setBidItemGuid(oldBidItem.getBidItemGuid());
                    projectDao.updateBidItem(bidItem);
                }
                bidItemGuids.add(bidItem.getInterfaceCode());
            }
        }
        //删除失效数据
        if (CollectionUtils.isNotEmpty(bidItemGuids)) {
            projectDao.delNonexistentBidItem(projectGuid, projectVO.getDataResource(), bidItemGuids);
        } else {
            projectDao.delAllBidItemByProject(projectGuid, projectVO.getDataResource());
        }
        //插入T_A_ProjectToBuyPlan
        insertProjectToBuyPlan(projectVO, projectGuid);
    }


    /**
     * 插入项目子表 T_A_BidItem 与 T_A_ProjectToBuyPlan
     *
     * @param projectVO
     * @param projectGuid
     */
    private void insertChildTable(ProjectVO projectVO, String projectGuid) throws Exception {
        List<BidItem> bidItemList = projectVO.getBidItemList();
        if (CollectionUtils.isNotEmpty(bidItemList)) {
            for (BidItem bidItem : bidItemList) {
                BidItemCheck bidItemCheck = ListUtil.copy(bidItem, BidItemCheck.class);
                List<String> checkRequestParam = commonUtilsService.checkRequestParam(bidItemCheck);
                if (CollectionUtils.isNotEmpty(checkRequestParam)) {
                    throw new Exception(bidItem.getInterfaceCode() + ":" + checkRequestParam.toString() + "字段为空");
                }
                //校验项目标项 枚举值的正确性
                //checkBidItemEnums(bidItem);
                bidItem.setProjectGuid(projectGuid);
                //查询项目标项是否存在
                HashMap<String, Object> condition = new HashMap<>();
                condition.put("interfaceCode", bidItem.getInterfaceCode());
                condition.put("dataResource", bidItem.getDataResource());
                BidItem oldBidItem = projectDao.getBidItemByGuid(condition);
                if (oldBidItem == null) {
                    bidItem.setBidItemGuid(UUIDGenerator.randomUUID());
                    projectDao.insertBidItem(bidItem);
                }
            }
        }
        //插入 项目对应的采购计划明细
        insertProjectToBuyPlan(projectVO, projectGuid);
    }

    /**
     * 校验项目标项 枚举值的正确性
     *
     * @param bidItem
     */
    private void checkBidItemEnums(BidItem bidItem) throws Exception {
        Optionlist dataResourceOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Data_Resource, bidItem.getDataResource());
        if (dataResourceOption == null) {
            throw new Exception(bidItem.getDataResource() + "数据来源,不存在该值");
        }
        if (bidItem.getPurMethod() != null) {
            Optionlist purmethodOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_PurMethod, bidItem.getPurMethod().toString());
            if (purmethodOption == null) {
                throw new Exception(bidItem.getPurMethod() + "该采购方式不存在");
            }
        }
        /*Integer count = organizationService.getOrganization(bidItem.getOrgGuid());
        if (count == 0) {
            throw new Exception(bidItem.getOrgGuid() + "不存在该采购单位");
        }*/
    }

    /**
     * 插入T_A_ProjectToBuyPlan
     *
     * @param projectVO
     * @param projectGuid
     */
    private void insertProjectToBuyPlan(ProjectVO projectVO, String projectGuid) throws Exception {
        List<ProjectToBuyPlan> projectToBuyPlanList = projectVO.getProjectToBuyPlanList();
        if (CollectionUtils.isNotEmpty(projectToBuyPlanList)) {
            for (ProjectToBuyPlan projectToBuyPlan : projectToBuyPlanList) {
                if (StringUtils.isEmpty(projectToBuyPlan.getBuyPlanDetailGuid())) {
                    throw new Exception("采购计划明细id字段为空");
                }
                /*//获取采购计划明细guid
                String buyPlanDetailGuid = commonUtilsService.getGuidByCodeAndResource(TablesEnum.BUYPLANDETAIL.getKey(), projectToBuyPlan.getBuyPlanDetailGuid(), projectVO.getDataResource(), "BuyPlan_Detail_Guid");
                if (StringUtils.isEmpty(buyPlanDetailGuid)) {
                    throw new Exception(projectToBuyPlan.getBuyPlanDetailGuid() + "：采购计划明细不存在");
                }
                projectToBuyPlan.setBuyPlanDetailGuid(buyPlanDetailGuid);*/

                //获取标项guid
                if (StringUtils.isNotEmpty(projectToBuyPlan.getBidItemGuid())) {
                    String bidItemGuid = commonUtilsService.getGuidByCodeAndResource(TablesEnum.BIDITEM.getKey(), projectToBuyPlan.getBidItemGuid(), projectVO.getDataResource(), "BidItem_Guid");
                    if (StringUtils.isEmpty(bidItemGuid)) {
                        throw new Exception(projectToBuyPlan.getBidItemGuid() + "标项不存在");
                    }
                    projectToBuyPlan.setBidItemGuid(bidItemGuid);
                }
                projectToBuyPlan.setProjectGuid(projectGuid);
                projectToBuyPlan.setProjectToBuyPlanGuid(UUIDGenerator.randomUUID());
                projectDao.insertProjectToBuyPlan(projectToBuyPlan);
            }
        }
    }

    /**
     * 根据interfaceCode和dataResource查询项目
     *
     * @param interfaceCode
     * @param dataResource
     * @return
     */
    @Override
    public Project getProject(String interfaceCode, String dataResource) {
        HashMap<String, Object> condition = new HashMap<>();
        condition.put("interfaceCode", interfaceCode);
        condition.put("dataResource", dataResource);
        Project oldProject = projectDao.getProject(condition);
        return oldProject;
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

    @Override
    public Project getProject(String projectGuid) {
        Project projectByGuid = projectDao.getProjectByGuid(projectGuid);
        return projectByGuid;
    }

    @Override
    public BidItem getBidItem(String interfaceCode,String dataResource) {
        HashMap<String, Object> condition = new HashMap<>();
        condition.put("interfaceCode", interfaceCode);
        condition.put("dataResource", dataResource);
        BidItem bidItemById = projectDao.getBidItemByGuid(condition);
        return bidItemById;
    }
}

