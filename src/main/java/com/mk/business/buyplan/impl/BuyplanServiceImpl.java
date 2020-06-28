
package com.mk.business.buyplan.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.mk.business.Constance.Constance;
import com.mk.business.agent.service.AgentService;
import com.mk.business.audithistory.model.Audithistory;
import com.mk.business.audithistory.service.AudithistoryService;
import com.mk.business.bizattachment.model.Bizattachment;
import com.mk.business.bizattachment.service.BizattachmentService;
import com.mk.business.buyplan.constant.BuyPlanConstant;
import com.mk.business.buyplan.dao.BuyplandetailDao;
import com.mk.business.buyplan.dao.BuyplanmoneyDao;
import com.mk.business.buyplan.dao.BuyplansupplierDao;
import com.mk.business.buyplan.model.Buyplan;
import com.mk.business.buyplan.model.Buyplandetail;
import com.mk.business.buyplan.model.Buyplanmoney;
import com.mk.business.buyplan.model.Buyplansupplier;
import com.mk.business.buyplan.param.BuyPlanCheckoutParam;
import com.mk.business.buyplan.param.BuyPlanMoneyCheckoutParam;
import com.mk.business.buyplan.param.BuyPlanRequestParam;
import com.mk.business.commonutils.exception.ParamException;
import com.mk.business.commonutils.service.CommonUtilsService;
import com.mk.business.financedept.service.FinancedeptService;
import com.mk.business.notice.dao.NoticeDao;
import com.mk.business.notice.model.Notice;
import com.mk.business.optionlist.model.Optionlist;
import com.mk.business.optionlist.service.OptionlistService;
import com.mk.business.organization.service.OrganizationService;
import com.mk.business.platform.service.PlatformService;
import com.mk.business.platformtype.service.PlatformtypeService;
import com.mk.business.purcatalog.service.PurcatalogService;
import com.mk.business.region.service.RegionService;
import com.mk.business.resource.service.ResourceService;
import com.mk.business.supplier.service.SupplierService;
import com.mk.utils.enums.BizTypeEnum;
import com.mk.utils.enums.StatusEnum;
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
import com.mk.business.buyplan.dao.BuyplanDao;
import com.mk.business.buyplan.service.BuyplanService;
import org.springframework.transaction.annotation.Transactional;
import sun.tools.java.Imports;
import tk.mybatis.mapper.entity.Example;

import javax.validation.Valid;
import java.util.*;

/**
 * Description:采购计划Impl
 * Created by zhangnengwei on 2020-4-7 17:30
 */


@Service
@Primary
public class BuyplanServiceImpl implements BuyplanService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private BuyplanDao buyplanDao;

    @Autowired
    private BuyplandetailDao buyplandetailDao;

    @Autowired
    private BuyplanmoneyDao buyplanmoneyDao;

    @Autowired
    private BuyplansupplierDao buyplansupplierDao;

    @Autowired
    private BizattachmentService bizattachmentService;

    @Autowired
    private CommonUtilsService commonUtilsService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private AudithistoryService audithistoryService;

    @Autowired
    private AgentService agentService;

    @Autowired
    private OptionlistService optionlistService;

    @Autowired
    private RegionService regionService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private FinancedeptService financedeptService;

    @Autowired
    private PurcatalogService purcatalogService;

    @Autowired
    private PlatformtypeService platformtypeService;

    @Autowired
    private PlatformService platformService;

    @Autowired
    private ResourceService resourceService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseInfoVo saveOrUpdateBuyplan(RequestInfoVo requestInfoVo) throws Exception {
        BuyPlanRequestParam buyPlanRequestParam;
        ResponseInfoVo responseInfoVo = new ResponseInfoVo();
        String messageDecryptStringToBase64;
        // 解密数据
        try {
            messageDecryptStringToBase64 = requestInfoVo.MessageDecryptStringToBase64();
        } catch (Exception e) {
            responseInfoVo.returnErrorResult("-2", e.getMessage());
            return responseInfoVo;
        }
        try {
            buyPlanRequestParam = JSONObject.parseObject(messageDecryptStringToBase64, BuyPlanRequestParam.class);
        } catch (Exception e) {
            responseInfoVo.returnErrorResult("-2", "数据解析异常" + e.getMessage());
            return responseInfoVo;
        }
        // 校验请求参数
        checkBuyPlanRequestParam(buyPlanRequestParam);

        // 设置时间戳,并获取主表信息
        Date currentSqlDate = commonUtilsService.getCurrentSqlDate();
        Date dateWithoutTime = commonUtilsService.getCurrentSqlDateWithoutTime(currentSqlDate);
        buyPlanRequestParam.setBizTimeStamp(currentSqlDate);
        buyPlanRequestParam.setBizDate(dateWithoutTime);
        Buyplan buyplan = ListUtil.copy(buyPlanRequestParam, Buyplan.class);

        //通用Mapper查询条件
        Example example = new Example(Buyplan.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("interfaceCode", buyplan.getInterfaceCode());
        criteria.andEqualTo("dataResource", buyplan.getDataResource());
        Buyplan buyplanFromSql = buyplanDao.selectOneByExample(example);

        logger.info("判断数据是否存在(存在则更新，不存在插入)");
        if (null != buyplanFromSql) {
            logger.info("开始: 更新t_a_buyplan主表信息");
            buyplan.setBuyplanGuid(buyplanFromSql.getBuyplanGuid());
            //todo 最新版本要求删除所有基础数据校验
            /*checkAgentGuid(buyplan);*/
            buyplanDao.updateByPrimaryKey(buyplan);
            updateChildTableByRequestParam(buyPlanRequestParam, buyplan);
        } else {
            logger.info("开始: 新增t_a_buyplan主表信息");
            buyplan.setBuyplanGuid(UUIDGenerator.getUUID());
            //todo 最新版本要求删除所有基础数据校验
            /*checkAgentGuid(buyplan);*/
            buyplanDao.insert(buyplan);
            insertChildTableByRequestParam(buyPlanRequestParam, buyplan);
        }

        logger.info("新增/更新计划成功,设置返回信息!");
        Gson gson = new Gson();
        ReturnMessage returnMessage = new ReturnMessage();
        returnMessage.setCode("200");
        returnMessage.setMsg("保存成功");
        gson.toJson(returnMessage);
        responseInfoVo.returnSuccessResult(gson.toJson(returnMessage), null);
        return responseInfoVo;
    }

    @Override
    public int getBuyplan(String interfaceCode, String dataResource) {
        Map<String, Object> map = new HashMap<>();
        map.put("interfaceCode", interfaceCode);
        map.put("dataResource", dataResource);
        return buyplanDao.getBuyplan(map);
    }

    /**
     * 校验并转换AgentGuid
     *
     * @Param: [buyplan 计划实体]
     * @return: void
     * @Author: Znw · Smile
     * @CreateDate: 2020-5-14 11:01
     */
    private void checkAgentGuid(Buyplan buyplan) throws ParamException {
        String agentGuid = buyplan.getAgentGuid();
        String dataResource = buyplan.getDataResource();
        if (StringUtils.isNotBlank(agentGuid)) {
            int agent = agentService.getAgent(agentGuid);
            if (StatusEnum.FALSE.getValue() == agent) {
                throw new ParamException("计划推送异常: 找不到来自" + dataResource + "的agentGuid:" + agentGuid);
            }
        }
    }

    /**
     * @Description:新增buyplan的子表信息
     * @Author: zhangnengwei
     * @Date: 2020-4-14 19:20
     */


    private void insertChildTableByRequestParam(BuyPlanRequestParam buyPlanRequestParam, Buyplan buyplan) throws Exception {
        List<Bizattachment> bizattachmentList = buyPlanRequestParam.getBizattachmentList();
        if (CollectionUtils.isNotEmpty(bizattachmentList)) {
            logger.info("开始：新增附件信息");
            for (Bizattachment bizattachment : bizattachmentList) {
                // 校验
                bizattachmentService.checkAttachmentParam(bizattachment);
                bizattachment.setBizGuid(buyplan.getBuyplanGuid());
                bizattachment.setBizType(BizTypeEnum.BUYPLAN.getKey());
                bizattachmentService.insertBizAttachment(bizattachment);
            }
        }

        List<Audithistory> audithistoryList = buyPlanRequestParam.getAudithistoryList();
        if (CollectionUtils.isNotEmpty(audithistoryList)) {
            logger.info("开始：新增T_A_AuditHistory信息");
            for (Audithistory audithistory : audithistoryList) {
                // 校验
                audithistoryService.checkAuditHistoryParam(audithistory);
                audithistory.setBizGuid(buyplan.getBuyplanGuid());
                audithistoryService.insertAuditHistory(audithistory);
            }
        }

        logger.info("开始：新增t_a_buyplandetail子表");
        List<Buyplandetail> buyplandetailList = buyPlanRequestParam.getBuyplandetailList();
        for (Buyplandetail buyplandetail : buyplandetailList) {
            // 校验请求参数
            checkBuyPlanDetailRequestParam(buyplandetail);

            // 设置业务主键ID
            buyplandetail.setBuyplanDetailGuid(UUIDGenerator.getUUID());
            buyplandetail.setBuyplanGuid(buyplan.getBuyplanGuid());
            buyplandetail.setAgentGuid(buyplan.getAgentGuid());
            buyplandetailDao.insert(buyplandetail);
        }

        logger.info("开始：新增t_a_buyplanmoney子表");
        List<Buyplanmoney> buyplanmoneyList = buyPlanRequestParam.getBuyplanmoneyList();
        for (Buyplanmoney buyplanmoney : buyplanmoneyList) {
            // 校验请求参数
            checkBuyplanMoneyRequestParam(buyplanmoney);

            // 设置时间戳、业务ID
            Date currentSqlDate = commonUtilsService.getCurrentSqlDate();
            Date dateWithoutTime = commonUtilsService.getCurrentSqlDateWithoutTime(currentSqlDate);
            buyplanmoney.setBizTimeStamp(currentSqlDate);
            buyplanmoney.setBizDate(dateWithoutTime);
            buyplanmoney.setBuyplanMoneyGuid(UUIDGenerator.getUUID());
            buyplanmoney.setBuyplanGuid(buyplan.getBuyplanGuid());
            checkAndSetBuyPlanMoneyIds(buyplanmoney);

            buyplanmoneyDao.insert(buyplanmoney);
        }

        logger.info("开始：新增t_a_buyplansupplier子表");
        List<Buyplansupplier> buyplansupplierList = buyPlanRequestParam.getBuyplansupplierList();
        for (Buyplansupplier buyplansupplier : buyplansupplierList) {
            if (null == buyplansupplier.getSupplierName()) {
                throw new ParamException("新增t_a_buyplansupplier子表失败： 供应商SupplierName名称为空");
            }
            // 业务主键ID
            buyplansupplier.setBuyplanSupplierGuid(UUIDGenerator.getUUID());
            buyplansupplier.setBuyplanGuid(buyplan.getBuyplanGuid());
            //todo  (最新版本要求删掉基础数据校验)校验supplierGuid
           /* int supplier = supplierService.getSupplier(buyplansupplier.getSupplierGuid());
            if (StatusEnum.FALSE.getValue() == supplier) {
                throw new ParamException("找不到来自:" + buyplan.getDataResource() +
                        "SupplierGuid:" + buyplansupplier.getSupplierGuid());
            }*/
            buyplansupplierDao.insert(buyplansupplier);
        }
    }

    private void checkBuyplanMoneyRequestParam(Buyplanmoney buyplanmoney) throws Exception {
        BuyPlanMoneyCheckoutParam checkoutParam = ListUtil.copy(buyplanmoney, BuyPlanMoneyCheckoutParam.class);
        List<String> nullParamList = commonUtilsService.checkRequestParam(checkoutParam);
        if (CollectionUtils.isNotEmpty(nullParamList)) {
            String errorParams = nullParamList.toString();
            throw new ParamException("无法新增t_a_buyplanmoney子表,以下字段为空:" + errorParams);
        }

        // 基础数据校验
      /*  int resourceGuid = resourceService.getResource(buyplanmoney.getResourceGuid());
        if (StatusEnum.FALSE.getValue() == resourceGuid) {
            throw new ParamException("推送计划资金明细失败:数据中心找不到对应resourceGuid:" + buyplanmoney.getResourceGuid());
        }*/

        // 枚举值校验
        if (StringUtils.isNotBlank(buyplanmoney.getCarryForwardType())) {
            Optionlist carryForwardType = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Carry_Forward_Type, buyplanmoney.getCarryForwardType());
            if (null == carryForwardType) {
                throw new ParamException("推送计划资金明细失败:数据中心找不到对应枚举值carryForwardType:" + buyplanmoney.getCarryForwardType());
            }
        }

        String bizValidFromSql = String.valueOf(buyplanmoney.getBizValid());
        if (null != buyplanmoney.getBizValid()) {
            Optionlist bizValid = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Biz_Valid, bizValidFromSql);
            if (null == bizValid) {
                throw new ParamException("推送计划资金明细失败:数据中心找不到对应枚举值bizValid:" + bizValidFromSql);
            }
        }

    }

    /**
     * 校验参数
     *
     * @Param: [buyplandetail]
     * @return: void
     * @Author: Znw · Smile
     * @CreateDate: 2020-5-14 11:34
     */
    private void checkBuyPlanDetailRequestParam(Buyplandetail buyplandetail) throws ParamException {
        // 校验请求参数
        if (null == buyplandetail.getBuyplanGuid()) {
            throw new ParamException("无法新增t_a_buyplandetail子表： BuyplanGuid为空！");
        } else if (null == buyplandetail.getPurcatalogGuid()) {
            throw new ParamException("无法新增t_a_buyplandetail子表： PurcatalogGuid为空！");
        } else if (null == buyplandetail.getValid()) {
            throw new ParamException("无法新增t_a_buyplandetail子表： Valid为空！");
        } else if (StringUtils.isBlank(buyplandetail.getInterfaceCode())) {
            throw new ParamException("无法新增t_a_buyplandetail子表： InterfaceCode为空！");
        } else if (StringUtils.isBlank(buyplandetail.getDataResource())) {
            throw new ParamException("无法新增t_a_buyplandetail子表： DataResource为空！");
        }

        // 校验枚举值
        if (StringUtils.isNotBlank(buyplandetail.getFinalPurmethod())) {
            Optionlist finalPurMethod = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Final_PurMethod, buyplandetail.getFinalPurmethod());
            if (null == finalPurMethod) {
                throw new ParamException("计划推送失败:枚举值超出范围finalPurMethod:" + buyplandetail.getFinalPurmethod());
            }
        }

        if (StringUtils.isNotBlank(buyplandetail.getPurcatalogType())) {
            Optionlist purcatalogType = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_PurCatalogType, buyplandetail.getPurcatalogType());
            if (null == purcatalogType) {
                throw new ParamException("计划推送失败:枚举值超出范围purcatalogType:" + buyplandetail.getPurcatalogType());
            }
        }

        if (StringUtils.isNotBlank(buyplandetail.getAgentType())) {
            Optionlist agentType = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Agent_Type, buyplandetail.getAgentType());
            if (null == agentType) {
                throw new ParamException("计划推送失败:枚举值超出范围agentType:" + buyplandetail.getAgentType());
            }
        }

        String importsFromSql = String.valueOf(buyplandetail.getImports());
        if (null != buyplandetail.getImports()) {
            Optionlist imports = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Imports, importsFromSql);
            if (null == imports) {
                throw new ParamException("计划推送失败:枚举值超出范围Imports:" + importsFromSql);
            }

        }

        String validFromSql = String.valueOf(buyplandetail.getValid());
        if (null != buyplandetail.getValid()) {
            Optionlist valid = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Valid, validFromSql);
            if (null == valid) {
                throw new ParamException("计划推送失败:枚举值超出范围Valid:" + validFromSql);
            }
        }

        // todo(新版要求删除基础数据校验)校验基础数据
       /* int purCatalog = purcatalogService.getPurCatalog(buyplandetail.getPurcatalogGuid());
        if (StatusEnum.FALSE.getValue() == purCatalog) {
            throw new ParamException("计划推送失败:数据中心找不到对应PurcatalogGuid:" + buyplandetail.getPurcatalogGuid());
        }

        int platform = platformService.getPlatform(buyplandetail.getPlatformGuid());
        if (StatusEnum.FALSE.getValue() == platform) {
            throw new ParamException("计划推送失败:数据中心找不到对应platform:" + buyplandetail.getPlatformGuid());
        }

        int platformType = platformtypeService.getPlatformType(buyplandetail.getPlatformTypeGuid());
        if (StatusEnum.FALSE.getValue() == platformType) {
            throw new ParamException("计划推送失败:数据中心找不到对应platformType:" + buyplandetail.getPlatformTypeGuid());
        }

        int agent = agentService.getAgent(buyplandetail.getAgentGuid());
        if (StatusEnum.FALSE.getValue() == agent) {
            throw new ParamException("计划推送失败:数据中心找不到对应agentGuid:" + buyplandetail.getAgentGuid());
        }*/
    }

    /**
     * 校验并转换BuyItem_Money_Guid, BuyItem_Guid, Budget_Guid字段
     *
     * @Param: [buyplanmoney]
     * @return: void
     * @Author: Znw · Smile
     * @CreateDate: 2020-5-14 14:03
     */
    private void checkAndSetBuyPlanMoneyIds(Buyplanmoney buyplanmoney) throws ParamException {
        String gpmsBuyitemMoneyGuid = buyplanmoney.getBuyitemMoneyGuid();
        String dataResource = buyplanmoney.getDataResource();
        if (StringUtils.isNotBlank(gpmsBuyitemMoneyGuid)) {
            String swmsBuyItemMoneyGuid = commonUtilsService.getGuidByCodeAndResource(TablesEnum.BUYITEMMONEY.getKey(),
                    gpmsBuyitemMoneyGuid, dataResource, BuyPlanConstant.BUYITEM_MONEYGUID_COLUMN);
            if (StringUtils.isBlank(swmsBuyItemMoneyGuid)) {
                throw new ParamException("推送计划失败,来源：dataResource:" + dataResource + " 找不到对应buyitemMoneyGuid:" + gpmsBuyitemMoneyGuid);
            }
            buyplanmoney.setBuyitemMoneyGuid(swmsBuyItemMoneyGuid);
        }
        String gpmsBuyitemGuid = buyplanmoney.getBuyitemGuid();
        if (StringUtils.isNotBlank(gpmsBuyitemGuid)) {
            String swmsBuyItemGuid = commonUtilsService.getGuidByCodeAndResource(TablesEnum.BUYITEMMONEY.getKey(),
                    gpmsBuyitemMoneyGuid, dataResource, BuyPlanConstant.BUYITEMGUID_COLUMN);
            if (StringUtils.isBlank(swmsBuyItemGuid)) {
                throw new ParamException("推送计划失败,来源：dataResource:" + dataResource + " 找不到对应BuyitemGuid:" + gpmsBuyitemGuid);
            }
            buyplanmoney.setBuyitemGuid(swmsBuyItemGuid);
        }

        String gpmsBudgetGuid = buyplanmoney.getBudgetGuid();
        if (StringUtils.isNotBlank(gpmsBudgetGuid)) {
            String swmsBudgetGuid = commonUtilsService.getGuidByCodeAndResource(TablesEnum.BUYITEMMONEY.getKey(),
                    gpmsBuyitemMoneyGuid, dataResource, BuyPlanConstant.BUDGETGUID_COLUMN);
            if (StringUtils.isBlank(swmsBudgetGuid)) {
                throw new ParamException("推送计划失败,来源：dataResource:" + dataResource + " 找不到对应BudgetGuid:" + gpmsBudgetGuid);
            }
            buyplanmoney.setBudgetGuid(swmsBudgetGuid);
        }

    }

    private void checkBuyPlanRequestParam(BuyPlanRequestParam buyPlanRequestParam) throws Exception {
        // 校验请求参数
        BuyPlanCheckoutParam buyPlanCheckoutParam = ListUtil.copy(buyPlanRequestParam, BuyPlanCheckoutParam.class);
        List<String> nullParamList = commonUtilsService.checkRequestParam(buyPlanCheckoutParam);
        if (CollectionUtils.isNotEmpty(nullParamList)) {
            String errorParams = nullParamList.toString();
            throw new ParamException(errorParams + "为空");
        }
        // 校验枚举值
        if (StringUtils.isNotBlank(buyPlanRequestParam.getKind())) {
            Optionlist kind = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Kind, buyPlanRequestParam.getKind());
            if (null == kind) {
                throw new ParamException("推送计划失败: 枚举值Kind超出规定范围" + buyPlanRequestParam.getKind());
            }
        }

        if (StringUtils.isNotBlank(buyPlanRequestParam.getPlatformTypeGuid())) {
            Optionlist platformTypeGuid = optionlistService.checkOptionListByTypeAndCode(
                    Constance.OptionLIst_Platform_Type_Guid, buyPlanRequestParam.getPlatformTypeGuid());
            if (null == platformTypeGuid) {
                throw new ParamException("推送计划失败: 枚举值PlatformTypeGuid超出规定范围" + buyPlanRequestParam.getPlatformTypeGuid());
            }
        }

        if (StringUtils.isNotBlank(buyPlanRequestParam.getPlatformGuid())) {
            Optionlist platformGuid = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Platform_Guid, buyPlanRequestParam.getPlatformGuid());
            if (null == platformGuid) {
                throw new ParamException("推送计划失败: 枚举值platformGuid超出规定范围" + buyPlanRequestParam.getPlatformGuid());
            }
        }

        Short isDirectBuy = buyPlanRequestParam.getIsDirectBuy();
        if (null != isDirectBuy) {
            String isDirectBuyCheckParam = String.valueOf(isDirectBuy);
            Optionlist isDirectBuyFromSql = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Is_Direct_Buy, isDirectBuyCheckParam);
            if (null == isDirectBuyFromSql) {
                throw new ParamException("推送计划失败: 枚举值isDirectBuy超出规定范围" + isDirectBuyCheckParam);
            }
        }

        if (StringUtils.isNotBlank(buyPlanRequestParam.getPurmethod())) {
            Optionlist purmethod = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_PurMethod, buyPlanRequestParam.getPurmethod());
            if (null == purmethod) {
                throw new ParamException("推送计划失败: 枚举值purmethod超出规定范围" + buyPlanRequestParam.getPurmethod());
            }

        }

        if (StringUtils.isNotBlank(buyPlanRequestParam.getAgentType())) {
            Optionlist agentType = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Agent_Type, buyPlanRequestParam.getAgentType());
            if (null == agentType) {
                throw new ParamException("推送计划失败: 枚举值agentType超出规定范围" + buyPlanRequestParam.getAgentType());
            }
        }

        String imports = String.valueOf(buyPlanRequestParam.getImports());
        if (null != buyPlanRequestParam.getImports()) {
            Optionlist importsFromSql = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Imports, imports);
            if (null == importsFromSql) {
                throw new ParamException("推送计划失败: 枚举值imports超出规定范围" + imports);
            }
        }

        if (null != buyPlanRequestParam.getPpp()) {
            Optionlist pPPFromSql = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_PPP, String.valueOf(buyPlanRequestParam.getPpp()));
            if (null == pPPFromSql) {
                throw new ParamException("推送计划失败: 枚举值PPP超出规定范围" + buyPlanRequestParam.getPpp());
            }
        }

        String secret = String.valueOf(buyPlanRequestParam.getSecret());
        if (null != buyPlanRequestParam.getSecret()) {
            Optionlist secretFromSql = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Secret, secret);
            if (null == secretFromSql) {
                throw new ParamException("推送计划失败: 枚举值secret超出规定范围" + secret);
            }
        }

        if (StringUtils.isNotBlank(buyPlanRequestParam.getPlanCreateType())) {
            Optionlist planCreateType = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_PlanCreateType, buyPlanRequestParam.getPlanCreateType());
            if (null == planCreateType) {
                throw new ParamException("推送计划失败: 枚举值planCreateType超出规定范围" + buyPlanRequestParam.getPlanCreateType());
            }
        }

        if (StringUtils.isNotBlank(buyPlanRequestParam.getBuyPlanStyle())) {
            Optionlist buyPlanStyle = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Buy_Plan_Style, buyPlanRequestParam.getBuyPlanStyle());
            if (null == buyPlanStyle) {
                throw new ParamException("推送计划失败: 枚举值buyPlanStyle超出规定范围" + buyPlanRequestParam.getBuyPlanStyle());
            }
        }

        String bizValid = String.valueOf(buyPlanRequestParam.getBizValid());
        if (null != buyPlanRequestParam.getBizValid()) {
            Optionlist bizValidFromSql = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Biz_Valid, bizValid);
            if (null == bizValidFromSql) {
                throw new ParamException("推送计划失败: 枚举值bizValid超出规定范围" + bizValid);
            }
        }

        // 校验基础数据
        /*int region = regionService.getRegion(buyPlanRequestParam.getRegionGuid());
        if (StatusEnum.FALSE.getValue() == region) {
            throw new ParamException("推送计划失败:数据中心找不到对应regionGuid:" + buyPlanRequestParam.getRegionGuid());
        }

        int organization = organizationService.getOrganization(buyPlanRequestParam.getOrgGuid());
        if (StatusEnum.FALSE.getValue() == organization) {
            throw new ParamException("推送计划失败:数据中心找不到对应OrgGuid:" + buyPlanRequestParam.getOrgGuid());
        }

        int financedept = financedeptService.getFinanceDept(buyPlanRequestParam.getFinanceDeptGuid());
        if (StatusEnum.FALSE.getValue() == financedept) {
            throw new ParamException("推送计划失败:数据中心找不到对应FinanceDeptGuid:" + buyPlanRequestParam.getFinanceDeptGuid());
        }

        int platform = platformService.getPlatform(buyPlanRequestParam.getPlatformGuid());
        if (StatusEnum.FALSE.getValue() == platform) {
            throw new ParamException("推送计划失败:数据中心找不到对应platform:" + buyPlanRequestParam.getPlatformGuid());
        }

        int platformType = platformtypeService.getPlatformType(buyPlanRequestParam.getPlatformTypeGuid());
        if (StatusEnum.FALSE.getValue() == platformType) {
            throw new ParamException("推送计划失败:数据中心找不到对应platformType:" + buyPlanRequestParam.getPlatformTypeGuid());
        }*/
    }

    /**
     * @Description:更新buyPlan子表信息
     * @Author: zhangnengwei
     * @Date: 2020-4-14 19:21
     */

    private void updateChildTableByRequestParam(BuyPlanRequestParam buyPlanRequestParam, Buyplan buyplan) throws Exception {
        List<Bizattachment> bizattachmentList = buyPlanRequestParam.getBizattachmentList();
        if (CollectionUtils.isNotEmpty(bizattachmentList)) {
            for (Bizattachment bizattachment : bizattachmentList) {
                // 校验
                bizattachmentService.checkAttachmentParam(bizattachment);
            }
            logger.info("开始：更新附件信息(全删全增)");
            bizattachmentService.deleteAttachmentByBizIdAndType(buyplan.getBuyplanGuid(), BizTypeEnum.BUYPLAN.getKey());
            for (Bizattachment bizattachment : bizattachmentList) {
                bizattachment.setBizGuid(buyplan.getBuyplanGuid());
                bizattachment.setBizType(BizTypeEnum.BUYPLAN.getKey());
                bizattachmentService.insertBizAttachment(bizattachment);
            }
        }

        logger.info("开始：更新T_A_AuditHistory信息(全删全增)");
        List<Audithistory> audithistoryList = buyPlanRequestParam.getAudithistoryList();
        for (Audithistory audithistory : audithistoryList) {
            // 校验
            audithistoryService.checkAuditHistoryParam(audithistory);
        }
        String buyplanGuid = buyplan.getBuyplanGuid();
        audithistoryService.deleteAuditHistryByBizId(buyplanGuid);
        for (Audithistory audithistory : audithistoryList) {
            audithistory.setBizGuid(buyplanGuid);
            audithistoryService.insertAuditHistory(audithistory);
        }

        logger.info("开始：更新t_a_buyplandetail子表信息");
        List<Buyplandetail> buyplandetailList = buyPlanRequestParam.getBuyplandetailList();
        List<String> buyplandetailCodes = new ArrayList<>();
        for (Buyplandetail buyplandetail : buyplandetailList) {
            // 校验参数
            checkBuyPlanDetailRequestParam(buyplandetail);

            // 通用Mapper过滤条件
            Example updateExample = new Example(Buyplandetail.class);
            Example.Criteria criteria = updateExample.createCriteria();
            criteria.andEqualTo("interfaceCode", buyplandetail.getInterfaceCode());
            criteria.andEqualTo("dataResource", buyplandetail.getDataResource());

            //查询存在信息
            Buyplandetail sqlBuyplandetail = buyplandetailDao.selectOneByExample(updateExample);
            if (null != sqlBuyplandetail) {
                // 更新有效数据
                buyplandetail.setBuyplanDetailGuid(sqlBuyplandetail.getBuyplanDetailGuid());
                buyplandetail.setBuyplanGuid(buyplan.getBuyplanGuid());
                buyplandetail.setAgentGuid(buyplan.getAgentGuid());
                buyplandetailDao.updateByPrimaryKey(buyplandetail);
            } else {
                // 新增有效数据
                buyplandetail.setBuyplanDetailGuid(UUIDGenerator.getUUID());
                buyplandetail.setBuyplanGuid(buyplan.getBuyplanGuid());
                buyplandetail.setAgentGuid(buyplan.getAgentGuid());
                buyplandetailDao.insert(buyplandetail);
            }
            buyplandetailCodes.add(buyplandetail.getInterfaceCode());
        }
        // 删除失效数据
        Example detailExample = new Example(Buyplandetail.class);
        Example.Criteria detailCriteria = detailExample.createCriteria();
        detailCriteria.andEqualTo("dataResource", buyPlanRequestParam.getDataResource());
        detailCriteria.andEqualTo("buyplanGuid", buyplan.getBuyplanGuid());
        if (CollectionUtils.isNotEmpty(buyplandetailCodes)) {
            detailCriteria.andNotIn("interfaceCode", buyplandetailCodes);
        }
        buyplandetailDao.deleteByExample(detailExample);


        logger.info("开始：更新t_a_buyplanmoney子表信息");
        List<Buyplanmoney> buyplanmoneyList = buyPlanRequestParam.getBuyplanmoneyList();
        List<String> buyplanmoneyCodes = new ArrayList<>();
        for (Buyplanmoney buyplanmoney : buyplanmoneyList) {
            // 校验参数
            checkBuyplanMoneyRequestParam(buyplanmoney);

            // 通用mapper过滤条件
            Example buyplanmoneyUpdateExample = new Example(Buyplandetail.class);
            Example.Criteria buyplanmoneyUpdateCriteria = buyplanmoneyUpdateExample.createCriteria();
            buyplanmoneyUpdateCriteria.andEqualTo("interfaceCode", buyplanmoney.getInterfaceCode());
            buyplanmoneyUpdateCriteria.andEqualTo("dataResource", buyplanmoney.getDataResource());

            // 查询数据量
            Buyplanmoney sqlBuyplanmoney = buyplanmoneyDao.selectOneByExample(buyplanmoneyUpdateExample);
            if (null != sqlBuyplanmoney) {
                // 更新有效数据
                Date currentSqlDate = commonUtilsService.getCurrentSqlDate();
                Date dateWithoutTime = commonUtilsService.getCurrentSqlDateWithoutTime(currentSqlDate);
                buyplanmoney.setBizTimeStamp(currentSqlDate);
                buyplanmoney.setBizDate(dateWithoutTime);
                buyplanmoney.setBuyplanMoneyGuid(sqlBuyplanmoney.getBuyplanMoneyGuid());
                buyplanmoney.setBuyplanGuid(buyplan.getBuyplanGuid());
                checkAndSetBuyPlanMoneyIds(buyplanmoney);
                buyplanmoneyDao.updateByPrimaryKey(buyplanmoney);
            } else {
                // 新增有效数据
                Date currentSqlDate = commonUtilsService.getCurrentSqlDate();
                Date dateWithoutTime = commonUtilsService.getCurrentSqlDateWithoutTime(currentSqlDate);
                buyplanmoney.setBizTimeStamp(currentSqlDate);
                buyplanmoney.setBizDate(dateWithoutTime);
                buyplanmoney.setBuyplanMoneyGuid(UUIDGenerator.getUUID());
                buyplanmoney.setBuyplanGuid(buyplan.getBuyplanGuid());
                checkAndSetBuyPlanMoneyIds(buyplanmoney);
                buyplanmoneyDao.insert(buyplanmoney);
            }
            buyplanmoneyCodes.add(buyplanmoney.getInterfaceCode());
        }

        Example moneyExample = new Example(Buyplanmoney.class);
        Example.Criteria moneyCriteria = moneyExample.createCriteria();
        moneyCriteria.andEqualTo("dataResource", buyPlanRequestParam.getDataResource());
        moneyCriteria.andEqualTo("buyplanGuid", buyplan.getBuyplanGuid());
        if (CollectionUtils.isNotEmpty(buyplanmoneyCodes)) {
            moneyCriteria.andNotIn("interfaceCode", buyplanmoneyCodes);
        }
        buyplanmoneyDao.deleteByExample(moneyExample);

        logger.info("更新t_a_buyplansupplier子表信息(全删/全增)");
        // 删除逻辑
        Example supplierExample = new Example(Buyplansupplier.class);
        Example.Criteria supplierCriteria = supplierExample.createCriteria();
        supplierCriteria.andEqualTo("buyplanGuid", buyplan.getBuyplanGuid());
        buyplansupplierDao.deleteByExample(supplierExample);

        // 新增逻辑
        List<Buyplansupplier> buyplansupplierList = buyPlanRequestParam.getBuyplansupplierList();
        for (Buyplansupplier buyplansupplier : buyplansupplierList) {
            if (null == buyplansupplier.getSupplierName()) {
                throw new ParamException("新增t_a_buyplansupplier子表失败： 供应商SupplierName名称为空");
            }
            buyplansupplier.setBuyplanSupplierGuid(UUIDGenerator.getUUID());
            buyplansupplier.setBuyplanGuid(buyplan.getBuyplanGuid());
            //todo (最新版本要求删掉基础数据校验)校验supplierGuid
           /* int supplier = supplierService.getSupplier(buyplansupplier.getSupplierGuid());
            if (StatusEnum.FALSE.getValue() == supplier) {
                throw new ParamException("找不到来自:" + buyplan.getDataResource() +
                        "SupplierGuid:" + buyplansupplier.getSupplierGuid());
            }*/
            buyplansupplierDao.insert(buyplansupplier);
        }
    }
}

