package com.mk.business.contract.impl;

import com.alibaba.fastjson.JSONObject;
import com.mk.business.Constance.Constance;
import com.mk.business.agent.service.AgentService;
import com.mk.business.audithistory.model.Audithistory;
import com.mk.business.audithistory.service.AudithistoryService;
import com.mk.business.bizattachment.model.Bizattachment;
import com.mk.business.bizattachment.service.BizattachmentService;
import com.mk.business.budget.service.BudgetService;
import com.mk.business.buyitem.service.BuyitemService;
import com.mk.business.buyplan.dao.BuyplanDao;
import com.mk.business.buyplan.dao.BuyplandetailDao;
import com.mk.business.buyplan.dao.BuyplanmoneyDao;
import com.mk.business.buyplan.model.Buyplan;
import com.mk.business.buyplan.model.Buyplandetail;
import com.mk.business.buyplan.model.Buyplanmoney;
import com.mk.business.buyplan.service.BuyplanService;
import com.mk.business.commentresult.vo.CommenResultVO;
import com.mk.business.commonutils.exception.ParamException;
import com.mk.business.commonutils.service.CommonUtilsService;
import com.mk.business.contract.dao.ContractdetailDao;
import com.mk.business.contract.dao.ContractmoneyDao;
import com.mk.business.contract.dao.ContractsupplierDao;
import com.mk.business.contract.model.Contract;
import com.mk.business.contract.model.Contractdetail;
import com.mk.business.contract.model.Contractmoney;
import com.mk.business.contract.model.Contractsupplier;
import com.mk.business.contract.param.ContractCheckoutParam;
import com.mk.business.contract.param.ContractMoneyCheckoutParam;
import com.mk.business.contract.param.ContractRequestParam;
import com.mk.business.optionlist.model.Optionlist;
import com.mk.business.optionlist.service.OptionlistService;
import com.mk.business.organization.service.OrganizationService;
import com.mk.business.pay.service.PayService;
import com.mk.business.project.model.BidItem;
import com.mk.business.project.model.Project;
import com.mk.business.project.service.ProjectService;
import com.mk.business.purcatalog.service.PurcatalogService;
import com.mk.business.region.service.RegionService;
import com.mk.business.resource.service.ResourceService;
import com.mk.business.supplier.service.SupplierService;
import com.mk.utils.enums.BizTypeEnum;
import com.mk.utils.enums.TablesEnum;
import com.mk.utils.model.ReturnMessage;
import com.mk.utils.request.RequestInfoVo;
import com.mk.utils.util.ListUtil;
import com.mk.utils.util.UUIDGenerator;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.mk.business.contract.dao.ContractDao;
import com.mk.business.contract.service.ContractService;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

/**
 * Description:采购合同Impl
 * Created by zhangnengwei on 2020-4-7 18:33
 */
@Service
@Primary
public class ContractServiceImpl implements ContractService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ContractDao contractDao;

    @Autowired
    private ContractdetailDao contractdetailDao;

    @Autowired
    private ContractmoneyDao contractmoneyDao;

    @Autowired
    private ContractsupplierDao contractsupplierDao;

    @Autowired
    private BuyplanDao buyplanDao;

    @Autowired
    private BuyplanmoneyDao buyplanmoneyDao;

    @Autowired
    private BuyplandetailDao buyplandetailDao;

    @Autowired
    private CommonUtilsService commonUtilsService;

    @Autowired
    private AudithistoryService audithistoryService;

    @Autowired
    private BizattachmentService bizattachmentService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private RegionService regionService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private OptionlistService optionlistService;

    @Autowired
    private AgentService agentService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private PurcatalogService purcatalogService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ReturnMessage saveOrUpdateContract(RequestInfoVo requestInfoVo) throws Exception {
        ContractRequestParam contractRequestParam = null;
        String messageDecryptStringToBase64 = null;
        //解密数据
        try {
            messageDecryptStringToBase64 = requestInfoVo.MessageDecryptStringToBase64();
        } catch (Exception e) {
            throw new Exception("解密失败" + e.getMessage());
        }
        try {
            contractRequestParam = JSONObject.parseObject(messageDecryptStringToBase64, ContractRequestParam.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("数据解析异常" + e.getMessage());
        }

        // 校验参数
        checkContractRequestParam(contractRequestParam);

        Contract contract = ListUtil.copy(contractRequestParam, Contract.class);
        // 校验合同参数枚举值的正确性
        checkEnumsContract(contract);
        logger.info("判断数据是否存在(存在则更新，不存在插入)");
        Example example = new Example(Contract.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("interfaceCode", contract.getInterfaceCode());
        criteria.andEqualTo("dataResource", contract.getDataResource());
        //判断合同是否存在
        Contract contractbyExample = contractDao.selectOneByExample(example);

        //查询采购计划id
        Example buyplanExample = new Example(Buyplan.class);
        Example.Criteria buyplanExampleCriteria = buyplanExample.createCriteria();
        buyplanExampleCriteria.andEqualTo("interfaceCode", contract.getBuyplanGuid());
        buyplanExampleCriteria.andEqualTo("dataResource", contract.getDataResource());
        Buyplan buyplan = buyplanDao.selectOneByExample(buyplanExample);
        /*String buyplanGuid = buyplan.getBuyplanGuid();
        if (StringUtils.isBlank(buyplanGuid)) {
            throw new ParamException("转换合同表的buyplanGuid失败:采购计划不存在,来源：" + contract.getDataResource()
                    + "合同ID：" + contract.getInterfaceCode());
        }
        contract.setBuyplanGuid(buyplanGuid);*/
        //查询合同原pguid
        if (StringUtils.isNotEmpty(contract.getContractPguid())) {
            Example contractExample = new Example(Contract.class);
            Example.Criteria contractExampleCriteria = contractExample.createCriteria();
            contractExampleCriteria.andEqualTo("interfaceCode", contract.getContractPguid());
            contractExampleCriteria.andEqualTo("dataResource", contract.getDataResource());
            Contract pContract = contractDao.selectOneByExample(contractExample);
            if (pContract == null) {
                throw new ParamException("转换合同表的contractPGuid失败:父合同不存在,来源：" + contract.getDataResource()
                        + "合同ID：" + contract.getContractPguid());
            }
            contract.setContractPguid(pContract.getContractGuid());
        }
        //设置时间戳
        Date currentSqlDate = commonUtilsService.getCurrentSqlDate();
        Date dateWithoutTime = commonUtilsService.getCurrentSqlDateWithoutTime(currentSqlDate);
        contract.setBizTimeStamp(currentSqlDate);
        contract.setBizDate(dateWithoutTime);

        if (null != contractbyExample) {
            //更新合同主表
            contract.setContractGuid(contractbyExample.getContractGuid());
            contractDao.updateByPrimaryKey(contract);
            //更新合同子表
            updateContractChildTable(contractRequestParam, contract);
        } else {
            //插入合同主表
            contract.setContractGuid(UUIDGenerator.randomUUID());
            contractDao.insert(contract);
            //插入合同子表
            insertContractChildTable(contractRequestParam, contract);
        }

        logger.info("新增/更新合同成功,设置返回信息!");
        return new ReturnMessage().ReturnMessageSuccess("新增/更新合同成功");
    }

    /**
     * 校验合同参数枚举值的正确性
     *
     * @param contract
     */
    private void checkEnumsContract(Contract contract) throws ParamException {

        if (contract.getContractCreateType() != null) {
            Optionlist createTypeOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Contract_Create_Type, contract.getContractCreateType().toString());
            if (createTypeOption == null) {
                throw new ParamException("合同拟定方式:" + contract.getContractCreateType() + "不存在");
            }
        }
        if (StringUtils.isNotBlank(contract.getKind())) {
            Optionlist kindOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Kind, contract.getKind());
            if (kindOption == null) {
                throw new ParamException("采购组织形式:" + contract.getKind() + "不存在");
            }
        }
        if (StringUtils.isNotBlank(contract.getPurcatalogType())) {
            Optionlist purCatalogTypeOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_PurCatalogType, contract.getPurcatalogType());
            if (purCatalogTypeOption == null) {
                throw new ParamException("采购目录分类:" + contract.getPurcatalogType() + "不存在");
            }
        }
        if (StringUtils.isNotBlank(contract.getPlatformTypeGuid())) {
            Optionlist platformTypeOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Platform_Type_Guid, contract.getPlatformTypeGuid());
            if (platformTypeOption == null) {
                throw new ParamException("采购实施形式分类:" + contract.getPlatformTypeGuid() + "不存在");
            }
        }
        if (StringUtils.isNotBlank(contract.getPlatformGuid())) {
            Optionlist platformOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Platform_Guid, contract.getPlatformGuid());
            if (platformOption == null) {
                throw new ParamException("采购实施形式:" + contract.getPlatformGuid() + "不存在");
            }
        }
        if (contract.getIsDirectBuy() != null) {
            Optionlist isDirectBuyOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Is_Direct_Buy, contract.getIsDirectBuy().toString());
            if (isDirectBuyOption == null) {
                throw new ParamException("是否单位自行采购:" + contract.getIsDirectBuy() + "不存在");
            }
        }
        if (StringUtils.isNotBlank(contract.getPurmethod())) {
            Optionlist purmenthodOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_PurMethod, contract.getPurmethod());
            if (purmenthodOption == null) {
                throw new ParamException("计划采购方式:" + contract.getPurmethod() + "不存在");
            }
        }
        if (StringUtils.isNotBlank(contract.getFinalPurmethod())) {
            Optionlist finalPurmethodOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Final_PurMethod, contract.getFinalPurmethod());
            if (finalPurmethodOption == null) {
                throw new ParamException("实际采购方式:" + contract.getFinalPurmethod() + "不存在");
            }
        }
        if (contract.getImports() != null) {
            Optionlist importsOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Imports, contract.getImports().toString());
            if (importsOption == null) {
                throw new ParamException("是否采购进口产品:" + contract.getImports() + "不存在");
            }
        }
        if (contract.getPpp() != null) {
            Optionlist pppOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_PPP, contract.getPpp().toString());
            if (pppOption == null) {
                throw new ParamException("是否PPP项目采购:" + contract.getPpp() + "不存在");
            }
        }
        if (contract.getSecret() != null) {
            Optionlist secretOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Secret, contract.getSecret().toString());
            if (secretOption == null) {
                throw new ParamException("秘密/机密项目采购:" + contract.getSecret() + "不存在");
            }
        }
        if (StringUtils.isNotBlank(contract.getSupplierSize())) {
            Optionlist supplierSizeOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Supplier_Size, contract.getSupplierSize());
            if (supplierSizeOption == null) {
                throw new ParamException("供应商规模:" + contract.getSupplierSize() + "不存在");
            }
        }
        if (StringUtils.isNotBlank(contract.getSupplierFeatures())) {
            Optionlist supplierFeaturesOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Supplier_Features, contract.getSupplierFeatures());
            if (supplierFeaturesOption == null) {
                throw new ParamException("供应商特性:" + contract.getSupplierFeatures() + "不存在");
            }
        }
        if (contract.getBizValid() != null) {
            Optionlist bizValidOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Biz_Valid, contract.getBizValid().toString());
            if (bizValidOption == null) {
                throw new ParamException("业务有效标志(<0,在途,0:完结,>0:失效):" + contract.getBizValid() + "不存在");
            }
        }
        if (contract.getMortgage() != null) {
            Optionlist mortgageOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Mortgage, contract.getMortgage().toString());
            if (mortgageOption == null) {
                throw new ParamException("是否政府采购融资" + contract.getMortgage() + "不存在");
            }
        }

        /**
         * 新版要求删除基础数据校验
         */
        //查询采购项目值 是否存在
        /*if (StringUtils.isNotEmpty(contract.getProjectGuid())) {
            Project project = projectService.getProject(contract.getProjectGuid(), contract.getDataResource());
            if (project == null) {
                throw new ParamException("id:" + contract.getProjectGuid() + "该采购项目不存在");
            }
            contract.setProjectGuid(contract.getProjectGuid());
        }*/
        //查询标项是否存在
      /*  if (StringUtils.isNotEmpty(contract.getBidGuid())) {
            BidItem bidItem = projectService.getBidItem(contract.getBidGuid(), contract.getDataResource());
            if (bidItem == null) {
                throw new ParamException("id:" + contract.getBidGuid() + "该采购标项不存在");
            }
            contract.setBidGuid(bidItem.getBidItemGuid());
        }*/
    }

    @Override
    public Integer getContract(String interfaceCode, String dataResource) {
        Map<String, Object> map = new HashMap<>();
        map.put("interfaceCode", interfaceCode);
        map.put("dataResource", dataResource);
        return contractDao.getContract(map);
    }

    @Override
    public Integer getContractMoney(String interfaceCode, String dataResource) {
        Map<String, Object> map = new HashMap<>();
        map.put("interfaceCode", interfaceCode);
        map.put("dataResource", dataResource);
        return contractDao.getContractMoney(map);
    }

    /**
     * 插入合同子表
     *
     * @param contractRequestParam
     */
    private void insertContractChildTable(ContractRequestParam contractRequestParam, Contract contract) throws Exception {
        String contractGuid = contract.getContractGuid();
        // 新增审核历史信息
        List<Audithistory> audithistoryList = contractRequestParam.getAudithistoryList();
        if (CollectionUtils.isNotEmpty(audithistoryList)) {
            logger.info("开始：新增T_A_AuditHistory信息");
            for (Audithistory audithistory : audithistoryList) {
                // 校验
                audithistoryService.checkAuditHistoryParam(audithistory);
                audithistory.setBizGuid(contractGuid);
                audithistoryService.insertAuditHistory(audithistory);
            }
        }
        // 新增附件信息
        List<Bizattachment> bizattachmentList = contractRequestParam.getBizattachmentList();
        if (CollectionUtils.isNotEmpty(bizattachmentList)) {
            logger.info("开始：新增附件信息");
            for (Bizattachment bizattachment : bizattachmentList) {
                // 校验
                bizattachmentService.checkAttachmentParam(bizattachment);
                bizattachment.setBizGuid(contractGuid);
                bizattachment.setBizType(BizTypeEnum.CONTRACT.getKey());
                bizattachmentService.insertBizAttachment(bizattachment);
            }
        }
        // 插入采购合同明细与合同供应商
        insertContractdetailAndContractsupplier(contractRequestParam, contractGuid);
        // 合同资金明细
        List<Contractmoney> contractmoneyList = contractRequestParam.getContractmoneyList();
        // 插入合同资金明细
        if (CollectionUtils.isNotEmpty(contractmoneyList)) {
            for (Contractmoney contractmoney : contractmoneyList) {
                // 校验参数
                checkContractMoneyParam(contractmoney);
                //查询采购计划资金明细
                Example buyplanmoneyExample = new Example(Buyplanmoney.class);
                Example.Criteria buyplanmoneyExampleCriteria = buyplanmoneyExample.createCriteria();
                buyplanmoneyExampleCriteria.andEqualTo("interfaceCode", contractmoney.getBuyplanMoneyGuid());
                buyplanmoneyExampleCriteria.andEqualTo("dataResource", contractmoney.getDataResource());
                Buyplanmoney buyplanmoney = buyplanmoneyDao.selectOneByExample(buyplanmoneyExample);
                if (null == buyplanmoney) {
                    throw new ParamException(contractmoney.getDataResource() + "下BuyplanMoneyGuid:"
                            + contractmoney.getBuyplanMoneyGuid() + "找不到对应的资金明细数据");
                }

                contractmoney.setBudgetGuid(buyplanmoney.getBudgetGuid());
                contractmoney.setBuyitemGuid(buyplanmoney.getBuyitemGuid());
                contractmoney.setBuyplanGuid(buyplanmoney.getBuyplanGuid());
                contractmoney.setBuyplanMoneyGuid(buyplanmoney.getBuyplanMoneyGuid());
                contractmoney.setResourceGuid(buyplanmoney.getResourceGuid());
                contractmoney.setContractGuid(contractGuid);
                Date currentSqlDate = commonUtilsService.getCurrentSqlDate();
                Date dateWithoutTime = commonUtilsService.getCurrentSqlDateWithoutTime(currentSqlDate);
                contractmoney.setBizTimeStamp(currentSqlDate);
                contractmoney.setBizDate(dateWithoutTime);
                contractmoney.setContractMoneyGuid(UUIDGenerator.randomUUID());
                //插入合同资金明细
                contractmoneyDao.insert(contractmoney);

            }
        }
    }

    /**
     * 校验ContractMoney参数
     *
     * @Param: [contractmoney]
     * @return: void
     * @Author: Znw · Smile
     * @CreateDate: 2020-5-14 15:59
     */
    private void checkContractMoneyParam(Contractmoney contractmoney) throws Exception {
        ContractMoneyCheckoutParam checkoutParam = ListUtil.copy(contractmoney, ContractMoneyCheckoutParam.class);
        String dataResource = checkoutParam.getDataResource();
        if (Constance.GPMS_DATA_RESOURCE.equals(dataResource)) {
            // 内蒙监管无支出预算,为过校验所以把校验对象设为来源值
            checkoutParam.setBudgetGuid(Constance.GPMS_DATA_RESOURCE);
        }
        List<String> nullParamList = commonUtilsService.checkRequestParam(checkoutParam);
        if (CollectionUtils.isNotEmpty(nullParamList)) {
            String errorParams = nullParamList.toString();
            throw new ParamException(errorParams + "为空");
        }
        if (StringUtils.isNotBlank(contractmoney.getCarryForwardType())) {
            Optionlist carryForwardTypeOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Carry_Forward_Type, contractmoney.getCarryForwardType());
            if (carryForwardTypeOption == null) {
                throw new ParamException("合同拟定方式:" + contractmoney.getCarryForwardType() + "不存在");
            }
        }
        if (contractmoney.getBizValid() != null) {
            Optionlist bizValidOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Biz_Valid, contractmoney.getBizValid().toString());
            if (bizValidOption == null) {
                throw new ParamException("业务有效标志(<0,在途,0:完结,>0:失效)不存在:" + contractmoney.getCarryForwardType());
            }
        }
    }


    /**
     * 更新合同子表
     *
     * @param contractRequestParam
     */
    private void updateContractChildTable(ContractRequestParam contractRequestParam, Contract contract) throws Exception {
        String contractGuid = contract.getContractGuid();

        //插入采购合同明细与合同供应商
        insertContractdetailAndContractsupplier(contractRequestParam, contractGuid);

        //合同资金明细
        List<Contractmoney> contractmoneyList = contractRequestParam.getContractmoneyList();
        //接收的资金明细id集合
        List interfaceCodeList = new ArrayList<String>();

        if (CollectionUtils.isNotEmpty(contractmoneyList)) {
            for (Contractmoney contractmoney : contractmoneyList) {
                //校验参数
                /* checkContractMoneyParam(contractmoney);*/

                //查询采购计划资金明细
                Example buyplanmoneyExample = new Example(Buyplanmoney.class);
                Example.Criteria buyplanmoneyExampleCriteria = buyplanmoneyExample.createCriteria();
                buyplanmoneyExampleCriteria.andEqualTo("interfaceCode", contractmoney.getBuyplanMoneyGuid());
                buyplanmoneyExampleCriteria.andEqualTo("dataResource", contractmoney.getDataResource());
                Buyplanmoney buyplanmoney = buyplanmoneyDao.selectOneByExample(buyplanmoneyExample);
                if (null == buyplanmoney) {
                    throw new ParamException(contractmoney.getDataResource()
                            + "下BuyplanMoneyGuid为：" + contractmoney.getBuyplanMoneyGuid() + "找不到对应计划资金明细");
                }
                contractmoney.setBudgetGuid(buyplanmoney.getBudgetGuid());
                contractmoney.setBuyitemGuid(buyplanmoney.getBuyitemGuid());
                contractmoney.setBuyplanGuid(buyplanmoney.getBuyplanGuid());
                contractmoney.setBuyplanMoneyGuid(buyplanmoney.getBuyplanMoneyGuid());
                contractmoney.setResourceGuid(buyplanmoney.getResourceGuid());

                //查询合同资金明细是否存在
                Example example = new Example(Contractmoney.class);
                Example.Criteria criteria = example.createCriteria();
                criteria.andEqualTo("interfaceCode", contractmoney.getInterfaceCode());
                criteria.andEqualTo("dataResource", contractmoney.getDataResource());
                Contractmoney contractmoneybyExample = contractmoneyDao.selectOneByExample(example);
                //设置时间戳
                Date currentSqlDate = commonUtilsService.getCurrentSqlDate();
                Date dateWithoutTime = commonUtilsService.getCurrentSqlDateWithoutTime(currentSqlDate);
                contractmoney.setBizTimeStamp(currentSqlDate);
                contractmoney.setBizDate(dateWithoutTime);
                if (null == contractmoneybyExample) {
                    //插入合同资金明细
                    contractmoney.setContractGuid(contractGuid);
                    contractmoney.setContractMoneyGuid(UUIDGenerator.randomUUID());
                    contractmoneyDao.insert(contractmoney);
                } else {
                    //更新合同资金明细
                    contractmoney.setContractGuid(contractGuid);
                    contractmoney.setContractMoneyGuid(contractmoneybyExample.getContractMoneyGuid());
                    contractmoneyDao.updateByPrimaryKey(contractmoney);
                }
                interfaceCodeList.add(contractmoney.getInterfaceCode());
            }
        }
        //删除失效数据
        Example contractmoneyExample = new Example(Contractmoney.class);
        Example.Criteria contractmoneyExampleCriteria = contractmoneyExample.createCriteria();
        contractmoneyExampleCriteria.andEqualTo("dataResource", contractRequestParam.getDataResource());
        contractmoneyExampleCriteria.andEqualTo("contractGuid", contractGuid);
        if (CollectionUtils.isNotEmpty(interfaceCodeList)) {
            contractmoneyExampleCriteria.andNotIn("interfaceCode", interfaceCodeList);
        }
        contractmoneyDao.deleteByExample(contractmoneyExample);

        List<Audithistory> audithistoryList = contractRequestParam.getAudithistoryList();
        if (CollectionUtils.isNotEmpty(audithistoryList)) {
            for (Audithistory audithistory : audithistoryList) {
                // 校验
                audithistoryService.checkAuditHistoryParam(audithistory);
            }
            logger.info("开始：更新T_A_AuditHistory信息(全删全增)");
            audithistoryService.deleteAuditHistryByBizId(contractGuid);
            for (Audithistory audithistory : audithistoryList) {
                audithistory.setBizGuid(contractGuid);
                audithistoryService.insertAuditHistory(audithistory);
            }
        }

        List<Bizattachment> bizattachmentList = contractRequestParam.getBizattachmentList();
        if (CollectionUtils.isNotEmpty(bizattachmentList)) {
            for (Bizattachment bizattachment : bizattachmentList) {
                // 校验
                bizattachmentService.checkAttachmentParam(bizattachment);
            }
            logger.info("开始：更新附件信息(全删全增)");
            bizattachmentService.deleteAttachmentByBizIdAndType(contractGuid, BizTypeEnum.CONTRACT.getKey());
            for (Bizattachment bizattachment : bizattachmentList) {
                bizattachment.setBizGuid(contractGuid);
                bizattachment.setBizType(BizTypeEnum.CONTRACT.getKey());
                bizattachmentService.insertBizAttachment(bizattachment);
            }
        }

    }


    /**
     * 插入采购合同明细与合同供应商
     *
     * @param contractRequestParam
     * @param contractGuid
     */
    private void insertContractdetailAndContractsupplier(ContractRequestParam contractRequestParam, String contractGuid) throws ParamException {
        //采购合同明细
        List<Contractdetail> contractdetailList = contractRequestParam.getContractdetailList();
        if (CollectionUtils.isNotEmpty(contractdetailList)) {
            for (Contractdetail contractdetail : contractdetailList) {
                //checkContractDetailParams(contractdetail);
            }

        }
        //全删采购合同明细
        contractdetailDao.deleteByContractGuid(contractGuid);
        //插入采购合同明细
        if (CollectionUtils.isNotEmpty(contractdetailList)) {
            for (Contractdetail contractdetail : contractdetailList) {
                // 校验合同明细 枚举值正确性
                  checkContractDetailEnums(contractdetail);

                if (StringUtils.isNotEmpty(contractdetail.getBuyplanDetailGuid())) {
                    //查询采购计划明细
                    Example example = new Example(Buyplandetail.class);
                    Example.Criteria criteria = example.createCriteria();
                    criteria.andEqualTo("interfaceCode", contractdetail.getBuyplanDetailGuid());
                    criteria.andEqualTo("dataResource", contractRequestParam.getDataResource());
                    Buyplandetail buyplandetail = buyplandetailDao.selectOneByExample(example);
                    if (buyplandetail == null) {
                        throw new ParamException("采购计划明细id：" + contractdetail.getBuyplanDetailGuid() + "不存在");
                    }
                    contractdetail.setBuyplanDetailGuid(buyplandetail.getBuyplanDetailGuid());
                }
                contractdetail.setContractGuid(contractGuid);
                contractdetail.setContractDetailGuid(UUIDGenerator.randomUUID());
                contractdetailDao.insert(contractdetail);
            }
        }
        //合同供应商
        List<Contractsupplier> contractsupplierList = contractRequestParam.getContractsupplierList();
        if (CollectionUtils.isNotEmpty(contractsupplierList)) {
            for (Contractsupplier contractsupplier : contractsupplierList) {
                // todo 新版要求删除基础数据校验
                /* checkContractsupplierParam(contractsupplier);*/
            }
        }

        //全删合同供应商
        contractsupplierDao.deleteByContractGuid(contractGuid);
        //插入合同供应商
        if (CollectionUtils.isNotEmpty(contractsupplierList)) {
            for (Contractsupplier contractsupplier : contractsupplierList) {
                // todo 新版本要求删除基础数据校验逻辑
                /*if (StringUtils.isNotEmpty(contractsupplier.getSupplierGuid())) {
                    Integer count = supplierService.getSupplier(contractsupplier.getSupplierGuid());
                    if (count == 0) {
                        throw new ParamException("供应商id：" + contractsupplier.getSupplierGuid() + "不存在");
                    }
                }*/
                contractsupplier.setContractGuid(contractGuid);
                contractsupplier.setContractSupplierGuid(UUIDGenerator.randomUUID());
                contractsupplierDao.insert(contractsupplier);
            }
        }
    }

    /**
     * 校验合同明细 枚举值正确性
     *
     * @param contractdetail
     */
    private void checkContractDetailEnums(Contractdetail contractdetail) throws ParamException {
        if (StringUtils.isNotBlank(contractdetail.getPurcatalogType())) {
            Optionlist purCatalogTypeOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_PurCatalogType, contractdetail.getPurcatalogType());
            if (purCatalogTypeOption == null) {
                throw new ParamException("采购目录分类:" + contractdetail.getPurcatalogType() + "不存在");
            }
        }
        if (contractdetail.getEfficient() != null) {
            Optionlist efficientOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Efficient, contractdetail.getEfficient().toString());
            if (efficientOption == null) {
                throw new ParamException("是否节能产品:" + contractdetail.getEfficient() + "不存在");
            }
        }
        if (contractdetail.getWaterSaving() != null) {
            Optionlist waterSavingOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Water_Saving, contractdetail.getWaterSaving().toString());
            if (waterSavingOption == null) {
                throw new ParamException("是否节水产品:" + contractdetail.getWaterSaving() + "不存在");
            }
        }
        if (contractdetail.getEnvironment() != null) {
            Optionlist environmentOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Environment, contractdetail.getEnvironment().toString());
            if (environmentOption == null) {
                throw new ParamException("是否环保产品:" + contractdetail.getEnvironment() + "不存在");
            }
        }
        if (contractdetail.getImports() != null) {
            Optionlist importsOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Imports, contractdetail.getImports().toString());
            if (importsOption == null) {
                throw new ParamException("是否采购进口产品:" + contractdetail.getImports() + "不存在");
            }
        }

        if (StringUtils.isNotBlank(contractdetail.getMakerSize())) {
            Optionlist makerSizeOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Maker_Size, contractdetail.getMakerSize());
            if (makerSizeOption == null) {
                throw new ParamException("供应商规模:" + contractdetail.getMakerSize() + "不存在");
            }
        }
        if (StringUtils.isNotBlank(contractdetail.getMakerFeatures())) {
            Optionlist makerFeaturesOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Maker_Features, contractdetail.getMakerFeatures());
            if (makerFeaturesOption == null) {
                throw new ParamException("供应商特性:" + contractdetail.getMakerFeatures() + "不存在");
            }
        }


        if (StringUtils.isNotBlank(contractdetail.getMakerOriginType())) {
            Optionlist markerOriginTypeOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Maker_Origin_Type, contractdetail.getMakerOriginType());
            if (markerOriginTypeOption == null) {
                throw new ParamException("制造商产地类型:" + contractdetail.getMakerOriginType() + "不存在");
            }
        }
        if (StringUtils.isNotBlank(contractdetail.getPorjectType())) {
            Optionlist projectTypeOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Porject_Type, contractdetail.getPorjectType());
            if (projectTypeOption == null) {
                throw new ParamException("项目类别" + contractdetail.getPorjectType() + "不存在");
            }
        }

        if (StringUtils.isNotBlank(contractdetail.getCarType())) {
            Optionlist carTypeOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Car_Type, contractdetail.getCarType());
            if (carTypeOption == null) {
                throw new ParamException("车辆品目类别" + contractdetail.getCarType() + "不存在");
            }
        }
        if (StringUtils.isNotBlank(contractdetail.getInnovateType())) {
            Optionlist innovateTypeOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Innovate_Type, contractdetail.getInnovateType());
            if (innovateTypeOption == null) {
                throw new ParamException("创新类别" + contractdetail.getInnovateType() + "不存在");
            }
        }


        //todo (新版要求删除基础数据校验)查询采购目录是否存在
        /*if (StringUtils.isNotEmpty(contractdetail.getPurcatalogGuid())) {
            Integer purCatalogCount = purcatalogService.getPurCatalog(contractdetail.getPurcatalogGuid());
            if (purCatalogCount == 0) {
                throw new ParamException("id:" + contractdetail.getPurcatalogGuid() + "该采购目录不存在");
            }
        }*/
    }

    /**
     * 校验Contractsupplier参数
     *
     * @Param: [contractsupplier]
     * @return: void
     * @Author: Znw · Smile
     * @CreateDate: 2020-5-14 16:21
     */
    private void checkContractsupplierParam(Contractsupplier contractsupplier) throws ParamException {
        if (StringUtils.isBlank(contractsupplier.getContractSupplierGuid())) {
            throw new ParamException("插入t_a_contractsupplier表失败,ContractSupplierGuid为空");
        } else if (StringUtils.isBlank(contractsupplier.getContractGuid())) {
            throw new ParamException("插入t_a_contractsupplier表失败,ContractSupplierGuid为空");
        } else if (null == contractsupplier.getSupplierName()) {
            throw new ParamException("插入t_a_contractsupplier表失败,SupplierName为空");
        }
    }

    /**
     * 校验contractdetail参数
     *
     * @Param: [contractdetail]
     * @return: void
     * @Author: Znw · Smile
     * @CreateDate: 2020-5-14 16:22
     */
    private void checkContractDetailParams(Contractdetail contractdetail) throws ParamException {
        if (StringUtils.isBlank(contractdetail.getContractDetailGuid())) {
            throw new ParamException("插入t_a_contractdetail表失败,ContractDetailGuid为空");
        } else if (StringUtils.isBlank(contractdetail.getContractGuid())) {
            throw new ParamException("插入t_a_contractdetail表失败,ContractGuid为空");
        } else if (null == contractdetail.getPurcatalogType()) {
            throw new ParamException("插入t_a_contractdetail表失败,PurcatalogType为空");
        } else if (StringUtils.isBlank(contractdetail.getPurcatalogGuid())) {
            throw new ParamException("插入t_a_contractdetail表失败,PurcatalogGuid为空");
        }

    }

    /**
     * 校验合同参数
     *
     * @Param: [contractRequestParam]
     * @return: void
     * @Author: Znw · Smile
     * @CreateDate: 2020-5-14 16:22
     */
    private void checkContractRequestParam(ContractRequestParam contractRequestParam) throws Exception {
        logger.info("开始：请求参数校验");
        ContractCheckoutParam checkoutParam = ListUtil.copy(contractRequestParam, ContractCheckoutParam.class);
        List<String> nullParamList = commonUtilsService.checkRequestParam(checkoutParam);
        /*if (CollectionUtils.isNotEmpty(nullParamList)) {
            String errorParams = nullParamList.toString();
            throw new ParamException(errorParams + "为空！");
        }*/
        /**
         *  (最新版本要求删掉基础数据校验)
         */
        //校验区域是否存在
        /*Integer count = regionService.getRegion(contractRequestParam.getRegionGuid());
        if (count == 0) {
            throw new ParamException("id：" + contractRequestParam.getRegionGuid() + "该区域不存在");
        }*/
        //校验采购单位orgguid是否存在
       /* Integer organizationCount = organizationService.getOrganization(contractRequestParam.getOrgGuid());
        if (organizationCount == 0) {
            throw new ParamException("id:" + contractRequestParam.getOrgGuid() + "该采购单位不存在");
        }*/
        //查询采购机构是否存在
        /*if (StringUtils.isNotEmpty(contractRequestParam.getAgentGuid())) {
            Integer agentCount = agentService.getAgent(contractRequestParam.getAgentGuid());
            if (agentCount == 0) {
                throw new ParamException("id:" + contractRequestParam.getAgentGuid() + "该采购机构不存在");
            }
        }*/

    }

}
