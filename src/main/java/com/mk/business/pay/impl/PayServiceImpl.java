package com.mk.business.pay.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.mk.business.Constance.Constance;
import com.mk.business.acceptance.param.AcceptanceRequestParam;
import com.mk.business.audithistory.model.Audithistory;
import com.mk.business.audithistory.service.AudithistoryService;
import com.mk.business.bizattachment.model.Bizattachment;
import com.mk.business.bizattachment.service.BizattachmentService;
import com.mk.business.budget.service.BudgetService;
import com.mk.business.buyitem.service.BuyitemService;
import com.mk.business.buyplan.service.BuyplanService;
import com.mk.business.commonutils.exception.ParamException;
import com.mk.business.commonutils.service.CommonUtilsService;
import com.mk.business.contract.dao.ContractmoneyDao;
import com.mk.business.contract.model.Contractmoney;
import com.mk.business.contract.service.ContractService;
import com.mk.business.financedept.service.FinancedeptService;
import com.mk.business.optionlist.model.Optionlist;
import com.mk.business.optionlist.service.OptionlistService;
import com.mk.business.organization.service.OrganizationService;
import com.mk.business.pay.dao.PaymoneyDao;
import com.mk.business.pay.model.Pay;
import com.mk.business.pay.model.Paymoney;
import com.mk.business.pay.param.PayCheckoutParam;
import com.mk.business.pay.param.PayMoneyCheckoutParam;
import com.mk.business.pay.param.PayRequestParam;
import com.mk.business.region.service.RegionService;
import com.mk.business.resource.service.ResourceService;
import com.mk.business.supplier.service.SupplierService;
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
import com.mk.business.pay.dao.PayDao;
import com.mk.business.pay.service.PayService;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

/**
 * Description:
 * Created by zhangnengwei on 2020-4-7 19:00
 */
@Service
@Primary
public class PayServiceImpl implements PayService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PayDao payDao;
    @Autowired
    private PaymoneyDao paymoneyDao;
    @Autowired
    private CommonUtilsService commonUtilsService;
    @Autowired
    private ContractmoneyDao contractmoneyDao;
    @Autowired
    private OptionlistService optionlistService;
    @Autowired
    private RegionService regionService;
    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private FinancedeptService financedeptService;
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private ContractService contractService;
    @Autowired
    private BuyplanService buyplanService;
    @Autowired
    private BuyitemService buyitemService;
    @Autowired
    private ResourceService resourceService;
    @Autowired
    private BudgetService budgetService;
    @Autowired
    private BizattachmentService bizattachmentService;
    @Autowired
    private AudithistoryService audithistoryService;

    @Override
    public ResponseInfoVo saveOrUpdatePayment(RequestInfoVo requestInfoVo) throws Exception {

        PayRequestParam payRequestParam = new PayRequestParam();
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
            payRequestParam = JSONObject.parseObject(messageDecryptStringToBase64, PayRequestParam.class);
        } catch (Exception e) {
            responseInfoVo.returnErrorResult("-2", "数据解析异常" + e.getMessage());
            return responseInfoVo;
        }

        // 校验数据
        checkPayRequestParam(payRequestParam);

        // 校验枚举和业务
        checkPayBusinessParam(payRequestParam);

        Pay pay = ListUtil.copy(payRequestParam, Pay.class);
        logger.info("判断数据是否存在(存在则更新，不存在插入)");
        Example example = new Example(Pay.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("interfaceCode", pay.getInterfaceCode());
        criteria.andEqualTo("dataResource", pay.getDataResource());
        Pay payByExample = payDao.selectOneByExample(example);
        //设置时间戳
        Date currentSqlDate = commonUtilsService.getCurrentSqlDate();
        Date dateWithoutTime = commonUtilsService.getCurrentSqlDateWithoutTime(currentSqlDate);
        pay.setBizTimeStamp(currentSqlDate);
        pay.setBizDate(dateWithoutTime);

        // Contract_Guid字段名
        String contractGuidColumn = "Contract_Guid";
        // 查询合同-合同id
        String contractGuid = commonUtilsService.getGuidByCodeAndResource(TablesEnum.CONTRACT.getKey(),
                pay.getContractGuid(), pay.getDataResource(), contractGuidColumn);
        if (StringUtils.isBlank(contractGuid)) {
            throw new ParamException("资金支付：" + pay.getDataResource()
                    + "下InterfaceCode为：" + pay.getInterfaceCode() + "转换contractGuid失败");
        }
        pay.setContractGuid(contractGuid);

        if (null == payByExample) {
            // 插入主表 T_A_Pay 资金支付
            pay.setPayGuid(UUIDGenerator.randomUUID());
            payDao.insert(pay);
            // 插入子表 T_A_PayMoney 资金支付明细
            insertChildPayMoney(payRequestParam, pay.getPayGuid());
            // 新增审核历史,公告表
            insertChildTable(payRequestParam, pay.getPayGuid());
        } else {
            // 更新主表 T_A_Pay 资金支付
            pay.setPayGuid(payByExample.getPayGuid());
            payDao.updateByPrimaryKey(pay);
            // 更新子表 T_A_PayMoney 资金支付明细
            updateChildPayMoney(payRequestParam, pay.getPayGuid());
            // 更新审核历史,公告表
            updateChildTable(payRequestParam, pay.getPayGuid());
        }
        Gson gson = new Gson();
        ReturnMessage returnMessage = new ReturnMessage();
        returnMessage.setCode("200");
        returnMessage.setMsg("保存成功");
        gson.toJson(returnMessage);
        responseInfoVo.returnSuccessResult(gson.toJson(returnMessage), null);
        return responseInfoVo;
    }

    private void updateChildTable(PayRequestParam payRequestParam, String payGuid) throws Exception {
        List<Bizattachment> bizattachmentList = payRequestParam.getBizattachmentList();
        if (CollectionUtils.isNotEmpty(bizattachmentList)) {
            for (Bizattachment bizattachment : bizattachmentList) {
                // 校验
                bizattachmentService.checkAttachmentParam(bizattachment);
            }
            logger.info("开始：更新附件信息(全删全增)");
            bizattachmentService.deleteAttachmentByBizIdAndType(payGuid, BizTypeEnum.PAY.getKey());
            for (Bizattachment bizattachment : bizattachmentList) {
                bizattachment.setBizGuid(payGuid);
                bizattachment.setBizType(BizTypeEnum.PAY.getKey());
                bizattachmentService.insertBizAttachment(bizattachment);
            }
        }

        logger.info("开始：更新T_A_AuditHistory信息(全删全增)");
        List<Audithistory> audithistoryList = payRequestParam.getAudithistoryList();
        for (Audithistory audithistory : audithistoryList) {
            // 校验
            audithistoryService.checkAuditHistoryParam(audithistory);
        }
        audithistoryService.deleteAuditHistryByBizId(payGuid);
        for (Audithistory audithistory : audithistoryList) {
            audithistory.setBizGuid(payGuid);
            audithistoryService.insertAuditHistory(audithistory);
        }
    }

    private void insertChildTable(PayRequestParam payRequestParam, String payGuid) throws Exception {
        List<Bizattachment> bizattachmentList = payRequestParam.getBizattachmentList();
        if (CollectionUtils.isNotEmpty(bizattachmentList)) {
            logger.info("开始：新增附件信息");
            for (Bizattachment bizattachment : bizattachmentList) {
                // 校验
                bizattachmentService.checkAttachmentParam(bizattachment);
                bizattachment.setBizGuid(payGuid);
                bizattachment.setBizType(BizTypeEnum.PAY.getKey());
                bizattachmentService.insertBizAttachment(bizattachment);
            }
        }

        List<Audithistory> audithistoryList = payRequestParam.getAudithistoryList();
        if (CollectionUtils.isNotEmpty(audithistoryList)) {
            logger.info("开始：新增T_A_AuditHistory信息");
            for (Audithistory audithistory : audithistoryList) {
                // 校验
                audithistoryService.checkAuditHistoryParam(audithistory);
                audithistory.setBizGuid(payGuid);
                audithistoryService.insertAuditHistory(audithistory);
            }
        }
    }

    @Override
    public int getPay(String interfacecode, String datasource) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("interfacecode", interfacecode);
        map.put("datasource", datasource);
        return payDao.getPay(map);
    }


    /**
     * 更新子表 T_A_PayMoney 资金支付资金
     *
     * @param payRequestParam
     * @param payGuid
     */
    private void updateChildPayMoney(PayRequestParam payRequestParam, String payGuid) throws Exception {
        List<Paymoney> paymoneyList = payRequestParam.getPaymoneyList();
        // 保存子表interfaceCode—List集合
        List interfaceCodeList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(paymoneyList)) {
            for (Paymoney paymoney : paymoneyList) {
                // 校验参数
                checkPaymoneyParam(paymoney);
                // 校验枚举和业务
                checkPaymoneyParamBusiness(paymoney);

                // 查询采购合同资金明细
                if (StringUtils.isNotBlank(paymoney.getContractMoneyGuid())) {
                    // 非内蒙监管需要考虑此步骤
                    Example contractmoneyExample = new Example(Contractmoney.class);
                    String contractMoneyGuid = paymoney.getContractMoneyGuid();
                    String dataResource = paymoney.getDataResource();
                    Example.Criteria contractmoneyExampleExampleCriteria = contractmoneyExample.createCriteria();
                    contractmoneyExampleExampleCriteria.andEqualTo("interfaceCode", contractMoneyGuid);
                    contractmoneyExampleExampleCriteria.andEqualTo("dataResource", dataResource);
                    Contractmoney contractmoney = contractmoneyDao.selectOneByExample(contractmoneyExample);
                    if (null == contractmoney) {
                        throw new ParamException("PayGuid:" + paymoney.getPayGuid() + "下无法通过来源为:"
                                + dataResource + "的ContractMoneyGuid:" + contractMoneyGuid + "找到对应实体数据");
                    }

                    paymoney.setBudgetGuid(contractmoney.getBudgetGuid());
                    paymoney.setBuyitemGuid(contractmoney.getBuyitemGuid());
                    paymoney.setBuyplanGuid(contractmoney.getBuyplanGuid());
                    paymoney.setContractMoneyGuid(contractmoney.getContractMoneyGuid());
                    paymoney.setResourceGuid(contractmoney.getResourceGuid());
                    paymoney.setPayGuid(payGuid);
                    paymoney.setContractGuid(contractmoney.getContractGuid());
                }

                // 查询子表 资金支付资金是否存在
                Example example = new Example(Paymoney.class);
                Example.Criteria criteria = example.createCriteria();
                criteria.andEqualTo("interfaceCode", paymoney.getInterfaceCode());
                criteria.andEqualTo("dataResource", paymoney.getDataResource());
                Paymoney paymoneyByExample = paymoneyDao.selectOneByExample(example);

                // 转换外键 ———— payID
                Example payExample = new Example(Pay.class);
                Example.Criteria payExampleCriteria = payExample.createCriteria();
                payExampleCriteria.andEqualTo("interfaceCode", paymoney.getPayGuid());
                payExampleCriteria.andEqualTo("dataResource", paymoney.getDataResource());
                Pay payFromSql = payDao.selectOneByExample(payExample);
                paymoney.setPayGuid(payFromSql.getPayGuid());


                if (paymoneyByExample == null) {
                    // 插入
                    paymoney.setPayDetailGuid(UUIDGenerator.randomUUID());
                    paymoneyDao.insert(paymoney);
                } else {
                    // 更新
                    paymoney.setPayDetailGuid(paymoneyByExample.getPayDetailGuid());
                    paymoneyDao.updateByPrimaryKey(paymoney);
                }
                interfaceCodeList.add(paymoney.getInterfaceCode());
            }
        }
        // 删除失效数据
        Example example = new Example(Paymoney.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("dataResource", payRequestParam.getDataResource());
        criteria.andEqualTo("payGuid", payGuid);
        if (CollectionUtils.isNotEmpty(interfaceCodeList)) {
            criteria.andNotIn("interfaceCode", interfaceCodeList);
        }
        paymoneyDao.deleteByExample(example);

    }

    /**
     * 插入子表 T_A_PayMoney 资金支付资金
     *
     * @param payRequestParam
     * @param payGuid
     */
    private void insertChildPayMoney(PayRequestParam payRequestParam, String payGuid) throws Exception {
        List<Paymoney> paymoneyList = payRequestParam.getPaymoneyList();
        if (CollectionUtils.isNotEmpty(paymoneyList)) {
            for (Paymoney paymoney : paymoneyList) {
                // 校验参数
                checkPaymoneyParam(paymoney);
                // 校验枚举和业务
                checkPaymoneyParamBusiness(paymoney);

                // 转换外键 ———— payID
                Example payExample = new Example(Pay.class);
                Example.Criteria payExampleCriteria = payExample.createCriteria();
                payExampleCriteria.andEqualTo("interfaceCode", paymoney.getPayGuid());
                payExampleCriteria.andEqualTo("dataResource", paymoney.getDataResource());
                Pay payFromSql = payDao.selectOneByExample(payExample);
                paymoney.setPayGuid(payFromSql.getPayGuid());

                // 查询采购合同资金明细
                if (StringUtils.isNotBlank(paymoney.getContractMoneyGuid())) {
                    // 非内蒙监管则需要以下步骤
                    Example contractmoneyExample = new Example(Contractmoney.class);
                    String contractMoneyGuid = paymoney.getContractMoneyGuid();
                    String dataResource = paymoney.getDataResource();
                    Example.Criteria contractmoneyExampleExampleCriteria = contractmoneyExample.createCriteria();
                    contractmoneyExampleExampleCriteria.andEqualTo("interfaceCode", contractMoneyGuid);
                    contractmoneyExampleExampleCriteria.andEqualTo("dataResource", dataResource);
                    Contractmoney contractmoney = contractmoneyDao.selectOneByExample(contractmoneyExample);
                    if (null == contractmoney) {
                        throw new ParamException("PayGuid:" + paymoney.getPayGuid() + "下无法通过来源为:"
                                + dataResource + "的ContractMoneyGuid:" + contractMoneyGuid + "找到对应实体数据");
                    }
                    paymoney.setContractMoneyGuid(contractmoney.getContractMoneyGuid());

                    paymoney.setBudgetGuid(contractmoney.getBudgetGuid());
                    paymoney.setBuyitemGuid(contractmoney.getBuyitemGuid());
                    paymoney.setBuyplanGuid(contractmoney.getBuyplanGuid());
                    paymoney.setResourceGuid(contractmoney.getResourceGuid());
                    paymoney.setContractGuid(contractmoney.getContractGuid());
                }

                paymoney.setPayDetailGuid(UUIDGenerator.randomUUID());
                paymoneyDao.insert(paymoney);
            }
        }
    }

    /**
     * 校验资金支付明细参数
     *
     * @Param: [Paymoney]
     * @return: void
     * @Author: Znw · Smile
     * @CreateDate: 2020-5-14 17:04
     */
    private void checkPaymoneyParam(Paymoney paymoney) throws Exception {
        PayMoneyCheckoutParam checkoutParam = ListUtil.copy(paymoney, PayMoneyCheckoutParam.class);
        List<String> nullParamList = commonUtilsService.checkRequestParam(checkoutParam);
        if (CollectionUtils.isNotEmpty(nullParamList)) {
            String errorParams = nullParamList.toString();
            throw new ParamException(errorParams + "为空！");
        }
    }

    /**
     * 校验支付参数
     *
     * @Param: [payRequestParam]
     * @return: void
     * @Author: Znw · Smile
     * @CreateDate: 2020-5-14 16:45
     */
    private void checkPayRequestParam(PayRequestParam payRequestParam) throws Exception {
        logger.info("开始：请求参数校验");
        PayCheckoutParam checkoutParam = ListUtil.copy(payRequestParam, PayCheckoutParam.class);
        List<String> nullParamList = commonUtilsService.checkRequestParam(checkoutParam);
        if (CollectionUtils.isNotEmpty(nullParamList)) {
            String errorParams = nullParamList.toString();
            throw new ParamException(errorParams + "为空!");
        }
    }

    private void checkPayBusinessParam(PayRequestParam payRequestParam) throws Exception {
        logger.info("开始：业务数据校验");
        if (StringUtils.isNotBlank(payRequestParam.getDataResource())) {
            Optionlist option = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Data_Resource, payRequestParam.getDataResource().toString());
            if (option == null) {
                throw new Exception(payRequestParam.getDataResource() + "数据来源,不存在该值");
            }
        }

        if (null != payRequestParam.getBizValid()) {
            Optionlist option = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Biz_Valid, payRequestParam.getBizValid().toString());
            if (option == null) {
                throw new Exception(payRequestParam.getBizValid() + "业务有效标志,不存在该值");
            }
        }
        if (null != payRequestParam.getPayType()) {
            Optionlist option = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Pay_Type, payRequestParam.getPayType().toString());
            if (option == null) {
                throw new Exception(payRequestParam.getPayType() + "支付方式,不存在该值");
            }
        }

        if (StringUtils.isNotBlank(payRequestParam.getContractGuid())) {
            Integer count = contractService.getContract(payRequestParam.getContractGuid(), payRequestParam.getDataResource());
            if (new Integer(0).compareTo(count) == 0) {
                throw new Exception(payRequestParam.getContractGuid() + "该合同不存在");
            }
        }

        //todo (新版本要求删除基础数据校验) 基础数据校验
     /*   if (StringUtils.isNotEmpty(payRequestParam.getRegionGuid())) {
            Integer count = regionService.getRegion(payRequestParam.getRegionGuid());
            if (new Integer(0).compareTo(count) == 0) {
                throw new Exception(payRequestParam.getRegionGuid() + "该区域不存在");
            }
        }
        if (StringUtils.isNotEmpty(payRequestParam.getOrgGuid())) {
            Integer count = organizationService.getOrganization(payRequestParam.getOrgGuid());
            if (new Integer(0).compareTo(count) == 0) {
                throw new Exception(payRequestParam.getOrgGuid() + "该采购单位不存在");
            }
        }
        if (StringUtils.isNotEmpty(payRequestParam.getFinanceDeptGuid())) {
            Integer count = financedeptService.getFinanceDept(payRequestParam.getFinanceDeptGuid());
            if (new Integer(0).compareTo(count) == 0) {
                throw new Exception(payRequestParam.getFinanceDeptGuid() + "该财政处室不存在");
            }
        }
        if (StringUtils.isNotEmpty(payRequestParam.getSupplierGuid())) {
            Integer count = supplierService.getSupplier(payRequestParam.getSupplierGuid());
            if (new Integer(0).compareTo(count) == 0) {
                throw new Exception(payRequestParam.getSupplierGuid() + "该供应商不存在");
            }
        }*/

    }

    private void checkPaymoneyParamBusiness(Paymoney paymoney) throws Exception {
        logger.info("开始：业务数据校验");
        if (StringUtils.isNotBlank(paymoney.getDataResource())) {
            Optionlist option = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Data_Resource, paymoney.getDataResource().toString());
            if (option == null) {
                throw new Exception(paymoney.getDataResource() + "数据来源,不存在该值");
            }
        }
        if (StringUtils.isNotEmpty(paymoney.getContractMoneyGuid())) {
            int count = contractService.getContractMoney(paymoney.getContractMoneyGuid(), paymoney.getDataResource());
            if (new Integer(0).compareTo(count) == 0) {
                throw new Exception(paymoney.getContractMoneyGuid() + "该合同明细不存在");
            }
        }
        if (StringUtils.isNotEmpty(paymoney.getContractGuid())) {
            int count = contractService.getContract(paymoney.getContractGuid(), paymoney.getDataResource());
            if (new Integer(0).compareTo(count) == 0) {
                throw new Exception(paymoney.getContractGuid() + "该合同不存在");
            }
        }
        if (StringUtils.isNotEmpty(paymoney.getBuyplanGuid())) {
            int count = buyplanService.getBuyplan(paymoney.getBuyplanGuid(), paymoney.getDataResource());
            if (new Integer(0).compareTo(count) == 0) {
                throw new Exception(paymoney.getBuyplanGuid() + "该计划不存在");
            }
        }
        if (StringUtils.isNotEmpty(paymoney.getBuyitemGuid())) {
            int count = buyitemService.getBuyitem(paymoney.getBuyitemGuid(), paymoney.getDataResource());
            if (new Integer(0).compareTo(count) == 0) {
                throw new Exception(paymoney.getBuyitemGuid() + "该预算不存在");
            }
        }

        // 非内蒙监管, 需校验支出预算
        Boolean needCheckBudgetInfo = StringUtils.isNotEmpty(paymoney.getBudgetGuid())
                && !Constance.GPMS_DATA_RESOURCE.equals(paymoney.getDataResource());
        if (needCheckBudgetInfo) {
            int count = budgetService.getBudget(paymoney.getBudgetGuid(), paymoney.getDataResource());
            if (new Integer(0).compareTo(count) == 0) {
                throw new Exception(paymoney.getBudgetGuid() + "该支出预算不存在");
            }
        }

        //todo (新版本要求删除基础数据校验) 基础数据校验
        /*if (StringUtils.isNotEmpty(paymoney.getResourceGuid())) {
            int count = resourceService.getResource(paymoney.getResourceGuid());
            if (new Integer(0).compareTo(count) == 0) {
                throw new Exception(paymoney.getResourceGuid() + "该资金来源不存在");
            }
        }*/
    }
}
