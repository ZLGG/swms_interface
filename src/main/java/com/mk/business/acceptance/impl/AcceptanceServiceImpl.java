package com.mk.business.acceptance.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.mk.business.Constance.Constance;
import com.mk.business.acceptance.model.Acceptance;
import com.mk.business.acceptance.param.AcceptanceCheckoutParam;
import com.mk.business.acceptance.param.AcceptanceRequestParam;
import com.mk.business.agent.service.AgentService;
import com.mk.business.audithistory.model.Audithistory;
import com.mk.business.audithistory.service.AudithistoryService;
import com.mk.business.bizattachment.model.Bizattachment;
import com.mk.business.bizattachment.service.BizattachmentService;
import com.mk.business.commonutils.exception.ParamException;
import com.mk.business.commonutils.service.CommonUtilsService;
import com.mk.business.contract.dao.ContractDao;
import com.mk.business.contract.model.Contract;
import com.mk.business.contract.service.ContractService;
import com.mk.business.financedept.service.FinancedeptService;
import com.mk.business.optionlist.model.Optionlist;
import com.mk.business.optionlist.service.OptionlistService;
import com.mk.business.organization.service.OrganizationService;
import com.mk.business.project.vo.ProjectVO;
import com.mk.business.region.service.RegionService;
import com.mk.utils.enums.BizTypeEnum;
import com.mk.utils.enums.TablesEnum;
import com.mk.utils.model.ReturnMessage;
import com.mk.utils.request.RequestInfoVo;
import com.mk.utils.request.ResponseInfoVo;
import com.mk.utils.util.ListUtil;
import com.mk.utils.util.UUIDGenerator;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.mk.business.acceptance.dao.AcceptanceDao;
import com.mk.business.acceptance.service.AcceptanceService;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
*Description:合同履约验收Service
*Created by zhangnengwei on 2020-4-7 19:16
*/
@Service
@Primary
public class AcceptanceServiceImpl implements AcceptanceService{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AcceptanceDao acceptanceDao;
    @Autowired
    private ContractDao contractDao;
    @Autowired
    private CommonUtilsService commonUtilsService;
    @Autowired
    private RegionService regionService;
    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private FinancedeptService financedeptService;
    @Autowired
    private ContractService contractService;
    @Autowired
    private AgentService agentService;
    @Autowired
    private OptionlistService optionlistService;

    @Autowired
    private BizattachmentService bizattachmentService;

    @Autowired
    private AudithistoryService audithistoryService;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseInfoVo saveOrUpdateAcceptance(RequestInfoVo requestInfoVo)throws Exception {
        AcceptanceRequestParam acceptanceRequestParam = new AcceptanceRequestParam();
        ResponseInfoVo responseInfoVo = new ResponseInfoVo();
        String messageDecryptStringToBase64 = null;
        //解密数据
        try {
            messageDecryptStringToBase64 = requestInfoVo.MessageDecryptStringToBase64();
        } catch (Exception e) {
            responseInfoVo.returnErrorResult("-2", e.getMessage());
            return responseInfoVo;
        }
        try {
            acceptanceRequestParam = JSONObject.parseObject(messageDecryptStringToBase64, AcceptanceRequestParam.class);
        } catch (Exception e) {
            responseInfoVo.returnErrorResult("-2", "数据解析异常" + e.getMessage());
            return responseInfoVo;
        }
        // 校验参数
        checkAcceptanceRequestParam(acceptanceRequestParam);
        // 校验枚举和基础数据
        checkAcceptanceBusinessParam(acceptanceRequestParam);
        Acceptance acceptance = ListUtil.copy(acceptanceRequestParam, Acceptance.class);
        //查询合同，获取合同id
        Example contractExample = new Example(Contract.class);
        Example.Criteria ContractExampleCriteria = contractExample.createCriteria();
        String contractGuid = acceptance.getContractGuid();
        String dataResource = acceptance.getDataResource();
        ContractExampleCriteria.andEqualTo("interfaceCode", contractGuid);
        ContractExampleCriteria.andEqualTo("dataResource",dataResource);
        Contract contract = contractDao.selectOneByExample(contractExample);
        if (null == contract) {
            throw new ParamException("履约验收无法通过来源为:" + dataResource + "contractGuid为：" + contractGuid
            + "找到相对应的合同数据");
        }
        acceptance.setContractGuid(contract.getContractGuid());

        //查询合同履约验收是否存在
        Example acceptanceExample = new Example(Acceptance.class);
        Example.Criteria acceptanceExampleCriteria = acceptanceExample.createCriteria();
        acceptanceExampleCriteria.andEqualTo("interfaceCode", acceptance.getInterfaceCode());
        acceptanceExampleCriteria.andEqualTo("dataResource", dataResource);
        Acceptance acceptanceByExample = acceptanceDao.selectOneByExample(acceptanceExample);

        //设置时间戳
        Date currentSqlDate = commonUtilsService.getCurrentSqlDate();
        Date dateWithoutTime = commonUtilsService.getCurrentSqlDateWithoutTime(currentSqlDate);
        acceptance.setBizTimeStamp(currentSqlDate);
        acceptance.setBizDate(dateWithoutTime);

        if (null == acceptanceByExample) {
            //插入合同履约验收
            acceptance.setAcceptanceGuid(UUIDGenerator.randomUUID());
            acceptanceDao.insert(acceptance);
            insertChildTable(acceptanceRequestParam,acceptance);
        } else {
            //更新合同履约验收
            acceptance.setAcceptanceGuid(acceptanceByExample.getAcceptanceGuid());
            acceptanceDao.updateByPrimaryKey(acceptance);
            updateChildTable(acceptanceRequestParam,acceptance);
        }
        Gson gson =new Gson();
        ReturnMessage returnMessage =new ReturnMessage();
        returnMessage.setCode("200");
        returnMessage.setMsg("保存成功");
        gson.toJson(returnMessage);
        responseInfoVo.returnSuccessResult(gson.toJson(returnMessage),null);
        return responseInfoVo;
    }

    private void updateChildTable(AcceptanceRequestParam acceptanceRequestParam, Acceptance acceptance) throws Exception {
        List<Bizattachment> bizattachmentList = acceptanceRequestParam.getBizattachmentList();
        if (CollectionUtils.isNotEmpty(bizattachmentList)) {
            for (Bizattachment bizattachment : bizattachmentList) {
                // 校验
                bizattachmentService.checkAttachmentParam(bizattachment);
            }
            logger.info("开始：更新附件信息(全删全增)");
            bizattachmentService.deleteAttachmentByBizIdAndType(acceptance.getAcceptanceGuid(), BizTypeEnum.ACCEPTANCE.getKey());
            for (Bizattachment bizattachment : bizattachmentList) {
                bizattachment.setBizGuid(acceptance.getAcceptanceGuid());
                bizattachment.setBizType(BizTypeEnum.ACCEPTANCE.getKey());
                bizattachmentService.insertBizAttachment(bizattachment);
            }
        }

        logger.info("开始：更新T_A_AuditHistory信息(全删全增)");
        List<Audithistory> audithistoryList = acceptanceRequestParam.getAudithistoryList();
        for (Audithistory audithistory : audithistoryList) {
            // 校验
            audithistoryService.checkAuditHistoryParam(audithistory);
        }
        String acceptanceGuid = acceptance.getAcceptanceGuid();
        audithistoryService.deleteAuditHistryByBizId(acceptanceGuid);
        for (Audithistory audithistory : audithistoryList) {
            audithistory.setBizGuid(acceptanceGuid);
            audithistoryService.insertAuditHistory(audithistory);
        }
    }

    private void insertChildTable(AcceptanceRequestParam acceptanceRequestParam,Acceptance acceptance) throws Exception {
        List<Bizattachment> bizattachmentList = acceptanceRequestParam.getBizattachmentList();
        if (CollectionUtils.isNotEmpty(bizattachmentList)) {
            logger.info("开始：新增附件信息");
            for (Bizattachment bizattachment : bizattachmentList) {
                // 校验
                bizattachmentService.checkAttachmentParam(bizattachment);
                bizattachment.setBizGuid(acceptance.getAcceptanceGuid());
                bizattachment.setBizType(BizTypeEnum.ACCEPTANCE.getKey());
                bizattachmentService.insertBizAttachment(bizattachment);
            }
        }

        List<Audithistory> audithistoryList = acceptanceRequestParam.getAudithistoryList();
        if (CollectionUtils.isNotEmpty(audithistoryList)) {
            logger.info("开始：新增T_A_AuditHistory信息");
            for (Audithistory audithistory : audithistoryList) {
                // 校验
                audithistoryService.checkAuditHistoryParam(audithistory);
                audithistory.setBizGuid(acceptance.getAcceptanceGuid());
                audithistoryService.insertAuditHistory(audithistory);
            }
        }

    }

    private void checkAcceptanceBusinessParam(AcceptanceRequestParam acceptanceRequestParam) throws Exception{
        logger.info("开始：业务数据校验");
        if(StringUtils.isNotBlank(acceptanceRequestParam.getDataResource())){
            Optionlist option = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Data_Resource, acceptanceRequestParam.getDataResource().toString());
            if (option == null) {
                throw new Exception(acceptanceRequestParam.getDataResource() + "数据来源,不存在该值");
            }
        }

        // todo (新版本要求删除基础数据校验)基础数据校验
       /* if(StringUtils.isNotEmpty(acceptanceRequestParam.getRegionGuid())){
           Integer count = regionService.getRegion(acceptanceRequestParam.getRegionGuid());
           if(new Integer(0).compareTo(count) == 0){
               throw new Exception(acceptanceRequestParam.getRegionGuid() + "该区域不存在");
           }
        }
        if(StringUtils.isNotEmpty(acceptanceRequestParam.getOrgGuid())){
            Integer count = organizationService.getOrganization(acceptanceRequestParam.getOrgGuid());
            if(new Integer(0).compareTo(count) == 0){
                throw new Exception(acceptanceRequestParam.getOrgGuid() + "该采购单位不存在");
            }
        }
        if(StringUtils.isNotEmpty(acceptanceRequestParam.getFinanceDeptGuid())){
            Integer count = financedeptService.getFinanceDept(acceptanceRequestParam.getFinanceDeptGuid());
            if(new Integer(0).compareTo(count) == 0){
                throw new Exception(acceptanceRequestParam.getFinanceDeptGuid() + "该财政处室不存在");
            }
        }

        if(StringUtils.isNotEmpty(acceptanceRequestParam.getAgentGuid())){
            Integer count = agentService.getAgent(acceptanceRequestParam.getAgentGuid());
            if(new Integer(0).compareTo(count) == 0){
                throw new Exception(acceptanceRequestParam.getAgentGuid() + "该代理机构不存在");
            }
        }

        */

        if(StringUtils.isNotBlank(acceptanceRequestParam.getContractGuid())){
            Integer count = contractService.getContract(acceptanceRequestParam.getContractGuid(),acceptanceRequestParam.getDataResource());
            if(new Integer(0).compareTo(count) == 0){
                throw new Exception(acceptanceRequestParam.getContractGuid() + "该合同不存在");
            }
        }

        if(StringUtils.isNotBlank(acceptanceRequestParam.getIsSimple())){
            Optionlist option = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Is_Simple,acceptanceRequestParam.getIsSimple().toString());
            if (option == null) {
                throw new Exception("验收流程IsSimple" + acceptanceRequestParam.getIsSimple() + "超出枚举值范围");
            }
        }

        if(StringUtils.isNotBlank(acceptanceRequestParam.getVerdictState())){
            Optionlist option = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Verdict_State,acceptanceRequestParam.getVerdictState().toString());
            if (option == null) {
                throw new Exception("验收小组结论VerdictState: " + acceptanceRequestParam.getVerdictState() + "超出枚举值范围");
            }
        }

        if(StringUtils.isNotBlank(acceptanceRequestParam.getOrgOpinion())){
            Optionlist option = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Org_Opinion, acceptanceRequestParam.getOrgOpinion().toString());
            if (option == null) {
                throw new Exception("采购单位结论OrgOpinion: " + acceptanceRequestParam.getOrgOpinion() + "超出枚举值范围");
            }
        }
        if(null != acceptanceRequestParam.getBizValid()){
            Optionlist option = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Biz_Valid, acceptanceRequestParam.getBizValid().toString());
            if (option == null) {
                throw new Exception("业务有效标志BizValid: " + acceptanceRequestParam.getBizValid() + "超出枚举值范围");
            }
        }
    }

    private void checkAcceptanceRequestParam(AcceptanceRequestParam acceptanceRequestParam) throws Exception {
        logger.info("开始：请求参数校验");
        AcceptanceCheckoutParam checkoutParam = ListUtil.copy(acceptanceRequestParam, AcceptanceCheckoutParam.class);
        List<String> nullParamList = commonUtilsService.checkRequestParam(checkoutParam);
        if (CollectionUtils.isNotEmpty(nullParamList)) {
            String errorParams = nullParamList.toString();
            throw new ParamException(errorParams + "为空！");
        }
    }
}
