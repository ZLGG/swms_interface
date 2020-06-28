package com.mk.business.buyitem.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.mk.business.Constance.Constance;
import com.mk.business.audithistory.model.Audithistory;
import com.mk.business.audithistory.service.AudithistoryService;
import com.mk.business.bizattachment.model.Bizattachment;
import com.mk.business.bizattachment.service.BizattachmentService;
import com.mk.business.buyitem.dao.BuyitemconfirmmoneyDao;
import com.mk.business.buyitem.model.Buyitem;
import com.mk.business.buyitem.model.Buyitemconfirmmoney;
import com.mk.business.buyitem.param.*;
import com.mk.business.buyitem.model.Buyitemconfirm;
import com.mk.business.buyitem.service.BuyitemconfirmService;
import com.mk.business.buyitem.model.Buyitemmoney;
import com.mk.business.buyitem.service.BuyitemmoneyService;
import com.mk.business.commonutils.exception.ParamException;
import com.mk.business.commonutils.service.CommonUtilsService;
import com.mk.business.financedept.service.FinancedeptService;
import com.mk.business.optionlist.model.Optionlist;
import com.mk.business.optionlist.service.OptionlistService;
import com.mk.business.organization.service.OrganizationService;
import com.mk.business.purcatalog.service.PurcatalogService;
import com.mk.business.region.service.RegionService;
import com.mk.business.resource.service.ResourceService;
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
import com.mk.business.buyitem.dao.BuyitemDao;
import com.mk.business.buyitem.service.BuyitemService;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.*;


/**
 * Description:
 * Created by zhangnengwei on 2020-4-7 10:56
 */
@Service
@Primary
public class BuyitemServiceImpl implements BuyitemService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BuyitemDao buyitemDao;

    @Autowired
    private AudithistoryService audithistoryService;

    @Autowired
    private BuyitemconfirmmoneyDao buyitemconfirmmoneyDao;

    @Autowired
    private BuyitemconfirmService buyitemconfirmService;

    @Autowired
    private BizattachmentService bizattachmentService;

    @Autowired
    private BuyitemmoneyService buyitemmoneyService;

    @Autowired
    private CommonUtilsService commonUtilsService;

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
    private ResourceService resourceService;

    @Override
    public int deleteByPrimaryKey(String buyitemGuid) {
        return buyitemDao.deleteByPrimaryKey(buyitemGuid);
    }

    @Override
    public int insert(Buyitem record) {
        return buyitemDao.insert(record);
    }

    @Override
    public int insertSelective(Buyitem record) {
        return buyitemDao.insertSelective(record);
    }

    @Override
    public Buyitem selectByPrimaryKey(String buyitemGuid) {
        return buyitemDao.selectByPrimaryKey(buyitemGuid);
    }

    @Override
    public int updateByPrimaryKeySelective(Buyitem record) {
        return buyitemDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Buyitem record) {
        return buyitemDao.updateByPrimaryKey(record);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseInfoVo saveOrUpdateBuyitem(RequestInfoVo requestInfoVo) throws Exception {
        BuyitemRequestParam buyitemRequestParam;
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
            buyitemRequestParam = JSONObject.parseObject(messageDecryptStringToBase64, BuyitemRequestParam.class);
        } catch (Exception e) {
            responseInfoVo.returnErrorResult("-2", "数据解析异常" + e.getMessage());
            return responseInfoVo;
        }
        // 校验请求参数
        checkBuyitemRequestParam(buyitemRequestParam);

        // 设置时间戳,并获取主表信息
        Date currentSqlDate = commonUtilsService.getCurrentSqlDate();
        Date dateWithoutTime = commonUtilsService.getCurrentSqlDateWithoutTime(currentSqlDate);
        buyitemRequestParam.setBizTimeStamp(currentSqlDate);
        buyitemRequestParam.setBizDate(dateWithoutTime);
        Buyitem buyitem = ListUtil.copy(buyitemRequestParam, Buyitem.class);

        // 通用Mapper查询条件
        Example example = new Example(Buyitem.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("interfaceCode", buyitem.getInterfaceCode());
        criteria.andEqualTo("dataResource", buyitem.getDataResource());

        // 查询已存在的数据
        Buyitem sqlBuyitem = buyitemDao.selectOneByExample(example);

        logger.info("判断数据是否存在(存在则更新，不存在插入)");
        if (null != sqlBuyitem) {
            logger.info("开始: 更新T_A_BuyItem主表信息");
            buyitem.setBuyitemGuid(sqlBuyitem.getBuyitemGuid());
            // 转换支出预算ID(兼容杭州监管)
            checkAndSetBudgetGuid(buyitem);
            buyitemDao.updateByPrimaryKey(buyitem);
            updateChildTableByRequestParam(buyitemRequestParam, sqlBuyitem);
        } else {
            logger.info("开始: 新增T_A_BuyItem主表信息");
            buyitem.setBuyitemGuid(UUIDGenerator.getUUID());
            // 转换支出预算ID(兼容杭州监管)
            checkAndSetBudgetGuid(buyitem);
            buyitemDao.insert(buyitem);
            insertChildTableByRequestParam(buyitemRequestParam, buyitem);
        }
        logger.info("新增/更新采购预算成功,设置返回信息!");
        Gson gson = new Gson();
        ReturnMessage returnMessage = new ReturnMessage();
        returnMessage.setCode("200");
        returnMessage.setMsg("保存成功");
        gson.toJson(returnMessage);
        responseInfoVo.returnSuccessResult(gson.toJson(returnMessage), null);
        return responseInfoVo;

    }

    private void checkBuyitemRequestParam(BuyitemRequestParam buyitemRequestParam) throws Exception {
        BuyitemCheckoutParam buyitemCheckoutParam = ListUtil.copy(buyitemRequestParam, BuyitemCheckoutParam.class);
        List<String> nullParamList = commonUtilsService.checkRequestParam(buyitemCheckoutParam);
        if (CollectionUtils.isNotEmpty(nullParamList)) {
            String errorParams = nullParamList.toString();
            throw new Exception(errorParams + "为空!");
        }

        // 校验基础数据
       /* int region = regionService.getRegion(buyitemRequestParam.getRegionGuid());
        if (StatusEnum.FALSE.getValue() == region) {
            throw new ParamException("推送采购预算失败:数据中心找不到对应regionGuid:" + buyitemRequestParam.getRegionGuid());
        }

        int organization = organizationService.getOrganization(buyitemRequestParam.getOrgGuid());
        if (StatusEnum.FALSE.getValue() == organization) {
            throw new ParamException("推送采购预算失败:数据中心找不到对应OrgGuid:" + buyitemRequestParam.getOrgGuid());
        }

        int financedept = financedeptService.getFinanceDept(buyitemRequestParam.getFinanceDeptGuid());
        if (StatusEnum.FALSE.getValue() == financedept) {
            throw new ParamException("推送采购预算失败:数据中心找不到对应FinanceDeptGuid:" + buyitemRequestParam.getFinanceDeptGuid());
        }

        int purCatalog = purcatalogService.getPurCatalog(buyitemRequestParam.getPurcatalogGuid());
        if (StatusEnum.FALSE.getValue() == purCatalog) {
            throw new ParamException("推送采购预算失败:数据中心找不到对应PurcatalogGuid:" + buyitemRequestParam.getPurcatalogGuid());
        }*/

        // 校验枚举值
        if (StringUtils.isNotBlank(buyitemRequestParam.getKind())) {
            Optionlist kind = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Kind, buyitemRequestParam.getKind());
            if (null == kind) {
                throw new ParamException("采购预算枚举值异常:数据中心找不到对应枚举值Kind:" + buyitemRequestParam.getKind());
            }
        }

        if (StringUtils.isNotBlank(buyitemRequestParam.getPurcatalogType())) {
            Optionlist purCatalogType = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_PurCatalogType, buyitemRequestParam.getPurcatalogType());
            if (null == purCatalogType) {
                throw new ParamException("采购预算枚举值异常:数据中心找不到对应枚举值purCatalogType:" + buyitemRequestParam.getPurcatalogType());
            }
        }

        if (StringUtils.isNotBlank(buyitemRequestParam.getOrigin())) {
            Optionlist origin = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Origin, buyitemRequestParam.getOrigin());
            if (null == origin) {
                throw new ParamException("采购预算枚举值异常:数据中心找不到对应枚举值origin:" + buyitemRequestParam.getOrigin());
            }
        }
    }

    @Override
    public int getBuyitem(String interfaceCode, String dataResource) {
        Map<String, Object> map = new HashMap<>();
        map.put("interfaceCode", interfaceCode);
        map.put("dataResource", dataResource);
        return buyitemDao.getBuyitem(map);
    }

    /**
     * @Description:从t_a_budget表获取Budget_Guid
     * @Author: zhangnengwei
     * @Date: 2020-4-15 17:12
     */
    private void checkAndSetBudgetGuid(Buyitem buyitem) throws ParamException {
        String budgetGuid = buyitem.getBudgetGuid();
        String dataResource = buyitem.getDataResource();
        if (StringUtils.isNotBlank(budgetGuid)) {
            // 字段名
            String columnName = "Budget_Guid";
            String swmsBudgetGuid = commonUtilsService.getGuidByCodeAndResource(
                    TablesEnum.BUDGET.getKey(), budgetGuid, dataResource, columnName);
            if (StringUtils.isBlank(swmsBudgetGuid)) {
                throw new ParamException("数据中心无法转换来自" + dataResource + "的budgetGuid:" + budgetGuid);
            }
            buyitem.setBudgetGuid(swmsBudgetGuid);
        }
    }


    /**
     * @Description:新增预算子表信息
     * @Author: zhangnengwei
     * @Date: 2020-4-15 17:13
     */
    private void insertChildTableByRequestParam(BuyitemRequestParam buyitemRequestParam, Buyitem buyitem) throws Exception {
        List<Buyitemconfirm> buyitemconfirmList = buyitemRequestParam.getBuyitemconfirmList();
        logger.info("开始：新增t_a_buyitemconfirm和t_a_buyitemconfirmmoney子表");
        for (Buyitemconfirm buyitemconfirm : buyitemconfirmList) {
            // 校验请求参数
            checkBuyitemConfirmParams(buyitemconfirm);

            // 设置时间戳、业务ID
            Date currentSqlDate = commonUtilsService.getCurrentSqlDate();
            Date dateWithoutTime = commonUtilsService.getCurrentSqlDateWithoutTime(currentSqlDate);
            buyitemconfirm.setBizTimeStamp(currentSqlDate);
            buyitemconfirm.setBizDate(dateWithoutTime);
            String confirmGuid = UUIDGenerator.getUUID();
            buyitemconfirm.setBuyitemConfirmGuid(confirmGuid);
            buyitemconfirm.setBuyitemGuid(buyitem.getBuyitemGuid());
            buyitemconfirmService.insert(buyitemconfirm);

            //新增t_a_buyitemconfirmmoney子表
            List<Buyitemconfirmmoney> buyitemconfirmmoneyList = buyitemconfirm.getBuyitemconfirmmoneyList();
            for (Buyitemconfirmmoney buyitemconfirmmoney : buyitemconfirmmoneyList) {
                // 校验请求参数
                checkBuyitemConfirmMoneyParams(buyitemconfirmmoney);
                buyitemconfirmmoney.setBuyitemConfirmGuid(confirmGuid);
                buyitemconfirmmoneyDao.insert(buyitemconfirmmoney);
            }
        }

        List<Buyitemmoney> buyitemmoneyList = buyitemRequestParam.getBuyitemmoneyList();
        logger.info("开始：新增t_a_buyitemmoney子表");
        for (Buyitemmoney buyitemmoney : buyitemmoneyList) {
            // 校验请求参数
            checkBuyitemMoneyParams(buyitemmoney);

            // 设置业务ID
            buyitemmoney.setBuyitemMoneyGuid(UUIDGenerator.getUUID());
            buyitemmoney.setBuyitemGuid(buyitem.getBuyitemGuid());
            String budgetMoneyGuid = getBudgetMoneyGuidByCodeAndResource(
                    buyitemmoney.getBudgetmoneyGuid(), buyitemmoney.getDataResource());
            buyitemmoney.setBudgetmoneyGuid(budgetMoneyGuid);
            buyitemmoney.setBudgetGuid(buyitem.getBudgetGuid());
            buyitemmoneyService.insert(buyitemmoney);
        }

        List<Audithistory> audithistoryList = buyitemRequestParam.getAudithistoryList();
        if (CollectionUtils.isNotEmpty(audithistoryList)) {
            logger.info("开始：新增T_A_AuditHistory信息");
            for (Audithistory audithistory : audithistoryList) {
                // 校验
                audithistoryService.checkAuditHistoryParam(audithistory);
                audithistory.setBizGuid(buyitem.getBuyitemGuid());
                audithistoryService.insertAuditHistory(audithistory);
            }
        }

        List<Bizattachment> bizattachmentList = buyitemRequestParam.getBizattachmentList();
        if (CollectionUtils.isNotEmpty(bizattachmentList)) {
            logger.info("开始：新增附件信息");
            for (Bizattachment bizattachment : bizattachmentList) {
                // 校验
                bizattachmentService.checkAttachmentParam(bizattachment);
                bizattachment.setBizGuid(buyitem.getBuyitemGuid());
                bizattachment.setBizType(BizTypeEnum.BUYITEM.getKey());
                bizattachmentService.insertBizAttachment(bizattachment);
            }
        }

    }

    private void checkBuyitemMoneyParams(Buyitemmoney buyitemmoney) throws Exception {
        BuyitemMoneyCheckoutParam buyitemMoneyCheckoutParam = ListUtil.copy(buyitemmoney, BuyitemMoneyCheckoutParam.class);
        List<String> nullConfirmParamList = commonUtilsService.checkRequestParam(buyitemMoneyCheckoutParam);
        if (CollectionUtils.isNotEmpty(nullConfirmParamList)) {
            String errorParams = nullConfirmParamList.toString();
            throw new Exception(errorParams + "为空!");
        }

        // 校验基础数据
      /*  int resourceGuid = resourceService.getResource(buyitemmoney.getResourceGuid());
        if (StatusEnum.FALSE.getValue() == resourceGuid) {
            throw new ParamException("推送Buyitemmoney失败 :数据中心找不到对应resourceGuid:" + buyitemmoney.getResourceGuid());
        }*/

        // 校验枚举值
        String valid = String.valueOf(buyitemmoney.getValid());
        if (null != buyitemmoney.getValid()) {
            Optionlist bizValidFromSql = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Valid, valid);
            if (null == bizValidFromSql) {
                throw new ParamException("推送Buyitemmoney失败: 枚举值valid超出规定范围" + valid);
            }
        }
    }

    private void checkBuyitemConfirmMoneyParams(Buyitemconfirmmoney buyitemconfirmmoney) throws Exception {
        ConfirmMoneyCheckoutParam confirmMoneyCheckoutParam = ListUtil.copy(buyitemconfirmmoney, ConfirmMoneyCheckoutParam.class);
        List<String> nullConfirmMoneyParamList = commonUtilsService.checkRequestParam(confirmMoneyCheckoutParam);
        if (CollectionUtils.isNotEmpty(nullConfirmMoneyParamList)) {
            String errorParams = nullConfirmMoneyParamList.toString();
            throw new Exception(errorParams + "为空!");
        }

        // 校验基础数据
        /*int resourceGuid = resourceService.getResource(buyitemconfirmmoney.getResourceGuid());
        if (StatusEnum.FALSE.getValue() == resourceGuid) {
            throw new ParamException("推送Buyitemconfirmmoney失败 :数据中心找不到对应resourceGuid:" + buyitemconfirmmoney.getResourceGuid());
        }*/
    }

    private void checkBuyitemConfirmParams(Buyitemconfirm buyitemconfirm) throws Exception {
        ConfirmCheckoutParam confirmCheckoutParam = ListUtil.copy(buyitemconfirm, ConfirmCheckoutParam.class);
        List<String> nullConfirmParamList = commonUtilsService.checkRequestParam(confirmCheckoutParam);
        if (CollectionUtils.isNotEmpty(nullConfirmParamList)) {
            String errorParams = nullConfirmParamList.toString();
            throw new Exception(errorParams + "为空!");
        }

        // 校验枚举值
        String bizValid = String.valueOf(buyitemconfirm.getBizValid());
        if (null != buyitemconfirm.getBizValid()) {
            Optionlist bizValidFromSql = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Biz_Valid, bizValid);
            if (null == bizValidFromSql) {
                throw new ParamException("推送buyitemconfirm失败: 枚举值bizValid超出规定范围" + bizValid);
            }
        }
    }

    /**
     * @Description:更新预算子表信息
     * @Author: zhangnengwei
     * @Date: 2020-4-15 17:13
     */
    private void updateChildTableByRequestParam(BuyitemRequestParam buyitemRequestParam, Buyitem sqlBuyitem) throws Exception {
        logger.info("更新T_A_BuyitemConfirm子表信息和t_a_buyitemconfirmmoney子表(全删全增)信息");
        List<Buyitemconfirm> buyitemconfirmList = buyitemRequestParam.getBuyitemconfirmList();
        List<String> buyitemconfirmCodes = new ArrayList<>();
        // 更新、新增有效信息
        for (Buyitemconfirm buyitemconfirm : buyitemconfirmList) {
            // 校验请求参数
            checkBuyitemConfirmParams(buyitemconfirm);

            // 设置时间戳
            Date currentSqlDate = commonUtilsService.getCurrentSqlDate();
            Date dateWithoutTime = commonUtilsService.getCurrentSqlDateWithoutTime(currentSqlDate);
            buyitemconfirm.setBizTimeStamp(currentSqlDate);
            buyitemconfirm.setBizDate(dateWithoutTime);

            Buyitemconfirm sqlBuyitemconfirm = buyitemconfirmService.selectBuyitemconfirm(buyitemconfirm);
            // 不为空更新,为空新增
            if (null != sqlBuyitemconfirm) {
                // 更新
                buyitemconfirm.setBuyitemGuid(sqlBuyitem.getBuyitemGuid());
                buyitemconfirm.setBuyitemConfirmGuid(sqlBuyitemconfirm.getBuyitemConfirmGuid());
                buyitemconfirmService.updateBuyitemConfirmByPrimaryKey(buyitemconfirm);

                // 更新————[t_a_buyitemconfirmmoney]子表数据(全删全增)
                List<Buyitemconfirmmoney> buyitemconfirmmoneyList = buyitemconfirm.getBuyitemconfirmmoneyList();
                Example buyitemconfirmmoneyExcample = new Example(Buyitemconfirmmoney.class);
                Example.Criteria confirmCriteria = buyitemconfirmmoneyExcample.createCriteria();
                confirmCriteria.andEqualTo("buyitemConfirmGuid", sqlBuyitemconfirm.getBuyitemConfirmGuid());
                for (Buyitemconfirmmoney buyitemconfirmmoney : buyitemconfirmmoneyList) {
                    // 校验
                    checkBuyitemConfirmMoneyParams(buyitemconfirmmoney);
                }
                buyitemconfirmmoneyDao.deleteByExample(buyitemconfirmmoneyExcample);
                if (CollectionUtils.isNotEmpty(buyitemconfirmmoneyList)) {
                    for (Buyitemconfirmmoney buyitemconfirmmoney : buyitemconfirmmoneyList) {
                        buyitemconfirmmoney.setBuyitemConfirmGuid(sqlBuyitemconfirm.getBuyitemConfirmGuid());
                        buyitemconfirmmoneyDao.insert(buyitemconfirmmoney);
                    }
                }
            } else {
                // 新增
                String buyitemConfirmGuid = UUIDGenerator.getUUID();
                buyitemconfirm.setBuyitemConfirmGuid(buyitemConfirmGuid);
                buyitemconfirm.setBuyitemGuid(sqlBuyitem.getBuyitemGuid());
                buyitemconfirmService.insert(buyitemconfirm);
                // 新增————[t_a_buyitemconfirmmoney]子表数据
                List<Buyitemconfirmmoney> buyitemconfirmmoneyList = buyitemconfirm.getBuyitemconfirmmoneyList();
                if (CollectionUtils.isNotEmpty(buyitemconfirmmoneyList)) {
                    for (Buyitemconfirmmoney buyitemconfirmmoney : buyitemconfirmmoneyList) {
                        buyitemconfirmmoney.setBuyitemConfirmGuid(buyitemConfirmGuid);
                        buyitemconfirmmoneyDao.insert(buyitemconfirmmoney);
                    }
                }
            }
            buyitemconfirmCodes.add(buyitemconfirm.getInterfaceCode());
        }

        Example example = new Example(Buyitemconfirm.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("dataResource", buyitemRequestParam.getDataResource());
        criteria.andEqualTo("buyitemGuid", sqlBuyitem.getBuyitemGuid());
        if (CollectionUtils.isNotEmpty(buyitemconfirmCodes)) {
            criteria.andNotIn("interfaceCode", buyitemconfirmCodes);
        }

        // 1.删除子表[t_a_buyitemconfirmmoney]里的失效数据
        List<Buyitemconfirm> buyitemconfirms = buyitemconfirmService.selectByExample(example);
        for (Buyitemconfirm buyitemconfirm : buyitemconfirms) {
            Example buyitemconfirmmoneyExcample = new Example(Buyitemconfirmmoney.class);
            Example.Criteria confirmCriteria = buyitemconfirmmoneyExcample.createCriteria();
            confirmCriteria.andEqualTo("buyitemConfirmGuid", buyitemconfirm.getBuyitemConfirmGuid());
            buyitemconfirmmoneyDao.deleteByExample(buyitemconfirmmoneyExcample);
        }

        // 2.删除子表[T_A_BuyitemConfirm]里的失效数据
        buyitemconfirmService.deleteConfirmsByExample(example);

        logger.info("更新T_A_BuyItemMoney子表信息");
        List<Buyitemmoney> buyitemmoneyList = buyitemRequestParam.getBuyitemmoneyList();
        List<String> buyitemmoneyCodes = new ArrayList<>();
        // 更新/新增有效信息
        for (Buyitemmoney buyitemmoney : buyitemmoneyList) {
            // 校验请求参数
            BuyitemMoneyCheckoutParam buyitemMoneyCheckoutParam = ListUtil.copy(buyitemmoney, BuyitemMoneyCheckoutParam.class);
            List<String> nullParamList = commonUtilsService.checkRequestParam(buyitemMoneyCheckoutParam);
            if (CollectionUtils.isNotEmpty(nullParamList)) {
                String errorParams = nullParamList.toString();
                throw new Exception(errorParams + "为空!");
            }

            // 查询数据库对象,不为空更新,为空新增
            Buyitemmoney sqlBuyitemmoney = buyitemmoneyService.selectBuyitemmoney(buyitemmoney);
            if (null != sqlBuyitemmoney) {
                // 更新
                String budgetMoneyGuid = getBudgetMoneyGuidByCodeAndResource(buyitemmoney.getBudgetmoneyGuid(), buyitemmoney.getDataResource());
                buyitemmoney.setBudgetmoneyGuid(budgetMoneyGuid);
                buyitemmoney.setBuyitemMoneyGuid(sqlBuyitemmoney.getBuyitemMoneyGuid());
                buyitemmoney.setBudgetGuid(sqlBuyitem.getBudgetGuid());
                buyitemmoney.setBuyitemGuid(sqlBuyitem.getBuyitemGuid());
                buyitemmoneyService.updateBuyitemMoneyByRequestParam(buyitemmoney);
            } else {
                // 新增
                String budgetMoneyGuid = getBudgetMoneyGuidByCodeAndResource(buyitemmoney.getBudgetmoneyGuid(), buyitemmoney.getDataResource());
                buyitemmoney.setBudgetmoneyGuid(budgetMoneyGuid);
                buyitemmoney.setBuyitemMoneyGuid(UUIDGenerator.getUUID());
                buyitemmoney.setBuyitemGuid(sqlBuyitem.getBuyitemGuid());
                buyitemmoney.setBudgetGuid(sqlBuyitem.getBudgetGuid());
                buyitemmoneyService.insert(buyitemmoney);
            }
            buyitemmoneyCodes.add(buyitemmoney.getInterfaceCode());
        }

        // 删除失效信息
        Example buyitemmoneyExample = new Example(Buyitemmoney.class);
        Example.Criteria buyitemmoneyCriteria = buyitemmoneyExample.createCriteria();
        buyitemmoneyCriteria.andEqualTo("dataResource", buyitemRequestParam.getDataResource());
        buyitemmoneyCriteria.andEqualTo("buyitemGuid", sqlBuyitem.getBuyitemGuid());
        if (CollectionUtils.isNotEmpty(buyitemmoneyCodes)) {
            buyitemmoneyCriteria.andNotIn("interfaceCode", buyitemmoneyCodes);
        }
        buyitemmoneyService.deleteBuyitemMoneysByExample(buyitemmoneyExample);


        List<Audithistory> audithistoryList = buyitemRequestParam.getAudithistoryList();
        if (CollectionUtils.isNotEmpty(audithistoryList)) {
            for (Audithistory audithistory : audithistoryList) {
                // 校验参数
                audithistoryService.checkAuditHistoryParam(audithistory);
            }
            logger.info("开始：更新T_A_AuditHistory信息(全删全增)");
            audithistoryService.deleteAuditHistryByBizId(sqlBuyitem.getBuyitemGuid());
            for (Audithistory audithistory : audithistoryList) {
                audithistory.setBizGuid(sqlBuyitem.getBuyitemGuid());
                audithistoryService.insertAuditHistory(audithistory);
            }
        }

        List<Bizattachment> bizattachmentList = buyitemRequestParam.getBizattachmentList();
        if (CollectionUtils.isNotEmpty(bizattachmentList)) {
            for (Bizattachment bizattachment : bizattachmentList) {
                // 校验参数
                bizattachmentService.checkAttachmentParam(bizattachment);
            }
            logger.info("开始：更新附件信息(全删全增)");
            bizattachmentService.deleteAttachmentByBizIdAndType(sqlBuyitem.getBuyitemGuid(), BizTypeEnum.BUYITEM.getKey());
            for (Bizattachment bizattachment : bizattachmentList) {
                bizattachment.setBizGuid(sqlBuyitem.getBuyitemGuid());
                bizattachment.setBizType(BizTypeEnum.BUYITEM.getKey());
                bizattachmentService.insertBizAttachment(bizattachment);
            }
        }
    }


    /**
     * @Description:从t_a_budgetmoney表获取Budget_Money_Guid
     * @Author: zhangnengwei
     * @Date: 2020-4-15 16:41
     */
    private String getBudgetMoneyGuidByCodeAndResource(String interfaceCode, String dataResource) {
        // 字段名
        String columnName = "Budget_Money_Guid";
        String budgetMoneyGuid = commonUtilsService.getGuidByCodeAndResource(
                TablesEnum.BUDGETMONEY.getKey(), interfaceCode, dataResource, columnName);
        return budgetMoneyGuid;
    }
}
