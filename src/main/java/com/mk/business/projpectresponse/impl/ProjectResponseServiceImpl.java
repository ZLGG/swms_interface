package com.mk.business.projpectresponse.impl;

import com.alibaba.fastjson.JSONObject;
import com.mk.business.Constance.Constance;
import com.mk.business.commonutils.service.CommonUtilsService;
import com.mk.business.location.service.LocationService;
import com.mk.business.optionlist.model.Optionlist;
import com.mk.business.optionlist.service.OptionlistService;
import com.mk.business.project.model.Project;
import com.mk.business.project.service.ProjectService;
import com.mk.business.projpectresponse.checkmodel.ProjectResponseCheck;
import com.mk.business.projpectresponse.dao.ProjectResponseDao;
import com.mk.business.projpectresponse.model.BidSupplierInfo;
import com.mk.business.projpectresponse.model.ProjectResponse;
import com.mk.business.projpectresponse.service.ProjectResponseService;
import com.mk.business.projpectresponse.vo.ProjectResponseVO;
import com.mk.business.supplier.service.SupplierService;
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

@Service
@Primary
public class ProjectResponseServiceImpl implements ProjectResponseService {
    @Autowired
    private ProjectResponseDao projectResponseDao;
    @Autowired
    private CommonUtilsService commonUtilsService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private OptionlistService optionlistService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private SupplierService supplierService;

    @Override
    @Transactional
    public ReturnMessage saveOrUpdateProjectResponse(RequestInfoVo requestInfoVo) throws Exception {

        ProjectResponseVO projectResponseVO = null;
        String messageDecryptStringToBase64 = null;

        try {
            messageDecryptStringToBase64 = requestInfoVo.MessageDecryptStringToBase64();
        } catch (Exception e) {
            throw new Exception("解密失败" + e.getMessage());
        }
        try {
            projectResponseVO = JSONObject.parseObject(messageDecryptStringToBase64,ProjectResponseVO.class);
        } catch (Exception e) {
            throw new Exception("数据解析异常" + e.getMessage());
        }
        //校验项目参数
        checkRequestParam(projectResponseVO.getInterfaceCode(), projectResponseVO.getDataResource());
        //查询项目是否存在
        Project oldProject = projectService.getProject(projectResponseVO.getInterfaceCode(), projectResponseVO.getDataResource());
        if (oldProject == null) {
            throw  new Exception(projectResponseVO.getInterfaceCode() + ":项目不存在");
        }
        //全删一次 防止多次调用
        delChildProjectResponseAndBidSupplierInfo(oldProject.getProjectGuid());
        //插入项目子表 投标登记
        List<ProjectResponse> projectResponseList = projectResponseVO.getProjectResponseList();
        if (CollectionUtils.isNotEmpty(projectResponseList)) {
            for (ProjectResponse projectResponse : projectResponseList) {
                ProjectResponseCheck projectResponseCheck = ListUtil.copy(projectResponse, ProjectResponseCheck.class);
                List<String> checkRequestNullList = commonUtilsService.checkRequestParam(projectResponseCheck);
                if (CollectionUtils.isNotEmpty(checkRequestNullList)) {
                    throw new Exception("投标登记" + projectResponse.getInterfaceCode() + ":" + checkRequestNullList.toString() + "字段为空");
                }
                //校验投标登记 枚举值的正确性
                //checkProjectResponseEnums(projectResponse);

                //查询标项id
                if (StringUtils.isNotEmpty(projectResponse.getBidItemGuid())) {
                    String bidItemGuid = commonUtilsService.getGuidByCodeAndResource(TablesEnum.BIDITEM.getKey(), projectResponse.getBidItemGuid(), oldProject.getDataResource(), "BidItem_Guid");
                    if (StringUtils.isEmpty(bidItemGuid)) {
                        throw new Exception(projectResponse.getBidItemGuid() + ":项目标项不存在");
                    }
                    projectResponse.setBidItemGuid(bidItemGuid);
                }

                projectResponse.setProjectGuid(oldProject.getProjectGuid());
                projectResponse.setResponseGuid(UUIDGenerator.randomUUID());
                projectResponseDao.insertProjectResponse(projectResponse);
                //插入投标供应商信息
                List<BidSupplierInfo> bidSupplierInfoList = projectResponse.getBidSupplierInfoList();
                if (CollectionUtils.isNotEmpty(bidSupplierInfoList)) {
                    for (BidSupplierInfo bidSupplierInfo : bidSupplierInfoList) {
                        if (StringUtils.isEmpty(bidSupplierInfo.getSupplierName())) {
                            throw new Exception("投标主题名称为空");
                        }
                        //校验投标供应商枚举值正确性
                        //checkBidSupplierInfoEnums(bidSupplierInfo);
                        bidSupplierInfo.setResponseGuid(projectResponse.getResponseGuid());
                        bidSupplierInfo.setBidSupplierInfoGuid(UUIDGenerator.randomUUID());
                        projectResponseDao.insertSupplierInfo(bidSupplierInfo);
                    }
                }
            }
        }
        ReturnMessage returnMessage = new ReturnMessage().ReturnMessageSuccess("投标登记保存成功");
        return returnMessage;
    }

    /**
     * 校验投标登记 枚举值的正确性
     *
     * @param projectResponse
     */
    private void checkProjectResponseEnums(ProjectResponse projectResponse) throws Exception {

        if (projectResponse.getSupplierSize() != null) {
            Optionlist supplierSizeOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Supplier_Size, projectResponse.getSupplierSize().toString());
            if (supplierSizeOption == null) {
                throw new Exception(projectResponse.getSupplierSize() + "供应商规模，不存在该值");
            }
        }
        if (projectResponse.getSupplierFeatures() != null) {
            Optionlist supplierFeaturesOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Supplier_Features, projectResponse.getSupplierFeatures().toString());
            if (supplierFeaturesOption == null) {
                throw new Exception(projectResponse.getSupplierFeatures() + "供应商特性，不存在该值");
            }
        }
        Optionlist dataResourceOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Data_Resource, projectResponse.getDataResource());
        if (dataResourceOption == null) {
            throw new Exception(projectResponse.getDataResource() + "不存在该数据来源");
        }
        /*if (StringUtils.isNotEmpty(projectResponse.getLocationGuid())) {
            Integer count = locationService.getLocation(projectResponse.getLocationGuid());
            if (count == 0) {
                throw new Exception(projectResponse.getLocationGuid() + "该行政区划不存在");
            }
        }*/
    }

    /**
     * 校验投标供应商明细 枚举值正确性
     *
     * @param bidSupplierInfo
     * @return
     */
    private void checkBidSupplierInfoEnums(BidSupplierInfo bidSupplierInfo) throws Exception {

        if (bidSupplierInfo.getSupplierSize() != null) {
            Optionlist supplierSizeOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Supplier_Size, bidSupplierInfo.getSupplierSize().toString());
            if (supplierSizeOption == null) {
                throw new Exception(bidSupplierInfo.getSupplierSize() + "供应商规模，不存在该值");
            }
        }
        if (bidSupplierInfo.getSupplierFeatures() != null) {
            Optionlist supplierFeatures = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Supplier_Features, bidSupplierInfo.getSupplierFeatures().toString());
            if (supplierFeatures == null) {
                throw new Exception(bidSupplierInfo.getSupplierFeatures() + "供应商特性，不存在该值");
            }
        }
       /* if (StringUtils.isNotEmpty(bidSupplierInfo.getLocationGuid())) {
            Integer count = locationService.getLocation(bidSupplierInfo.getLocationGuid());
            if (count == 0) {
                throw new Exception(bidSupplierInfo.getLocationGuid() + "该行政区划不存在");
            }
        }*/
        if (StringUtils.isNotEmpty(bidSupplierInfo.getSupplierGuid())) {
            Integer supplierCount = supplierService.getSupplier(bidSupplierInfo.getSupplierGuid());
            if (supplierCount == 0) {
                throw new Exception(bidSupplierInfo.getSupplierGuid() + "该供应商不存在");
            }
        }
    }

    /**
     * 全删项目子表
     *
     * @param projectGuid
     */
    @Override
    public void delChildProjectResponseAndBidSupplierInfo(String projectGuid) {
        //根据项目projectguid 查询投标登记guid
        List<String> projectResponseGuidList = projectResponseDao.getProjectResponseGuidByProjectguid(projectGuid);
        //根据投标登记guid 删除投标供应商明细 T_A_BidSupplierInfo表
        if (CollectionUtils.isNotEmpty(projectResponseGuidList)) {
            for (String projectResponseGuid : projectResponseGuidList) {
                //删除投标供应商明细
                projectResponseDao.delBidSupplierInfo(projectResponseGuid);
            }
        }
        //删除该项目的投标登记
        projectResponseDao.delProjectResponse(projectGuid);
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
