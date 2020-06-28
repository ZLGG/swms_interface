package com.mk.business.budget.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.mk.business.Constance.Constance;
import com.mk.business.budget.dao.BudgetmoneyDao;
import com.mk.business.budget.param.BudgetRequestParam;
import com.mk.business.budget.model.Budgetmoney;
import com.mk.business.commonutils.exception.ParamException;
import com.mk.business.commonutils.service.CommonUtilsService;
import com.mk.business.financedept.service.FinancedeptService;
import com.mk.business.optionlist.model.Optionlist;
import com.mk.business.optionlist.service.OptionlistService;
import com.mk.business.organization.service.OrganizationService;
import com.mk.business.purcatalog.service.PurcatalogService;
import com.mk.business.region.service.RegionService;
import com.mk.utils.enums.StatusEnum;
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
import com.mk.business.budget.dao.BudgetDao;
import com.mk.business.budget.model.Budget;
import com.mk.business.budget.service.BudgetService;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.*;

/**
 * Description:支出预算ServiceImpl
 * Created by zhangnengwei on 2020-4-7 14:59
 */
@Service
@Primary
public class BudgetServiceImpl implements BudgetService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BudgetDao budgetDao;

    @Autowired
    private BudgetmoneyDao budgetmoneyDao;

    @Autowired
    private CommonUtilsService commonUtilsService;

    @Autowired
    private RegionService regionService;

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private FinancedeptService financedeptService;

    @Autowired
    private PurcatalogService purcatalogService;

    @Autowired
    private OptionlistService optionlistService;

    @Override
    public int deleteByPrimaryKey(String budgetGuid) {
        return budgetDao.deleteByPrimaryKey(budgetGuid);
    }

    @Override
    public int insert(Budget record) {
        return budgetDao.insert(record);
    }

    @Override
    public int insertSelective(Budget record) {
        return budgetDao.insertSelective(record);
    }

    @Override
    public Budget selectByPrimaryKey(String budgetGuid) {
        return budgetDao.selectByPrimaryKey(budgetGuid);
    }

    @Override
    public int updateByPrimaryKeySelective(Budget record) {
        return budgetDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Budget record) {
        return budgetDao.updateByPrimaryKey(record);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseInfoVo saveOrUpdateBudget(RequestInfoVo requestInfoVo) throws Exception {
        BudgetRequestParam budgetRequestParam;
        ResponseInfoVo responseInfoVo = new ResponseInfoVo();
        String messageDecryptStringToBase64;
        //解密数据
        try {
            messageDecryptStringToBase64 = requestInfoVo.MessageDecryptStringToBase64();
        } catch (Exception e) {
            responseInfoVo.returnErrorResult("-2", e.getMessage());
            return responseInfoVo;
        }
        try {
            budgetRequestParam = JSONObject.parseObject(messageDecryptStringToBase64, BudgetRequestParam.class);
        } catch (Exception e) {
            responseInfoVo.returnErrorResult("-2", "数据解析异常" + e.getMessage());
            return responseInfoVo;
        }
        checkBudgetRequestParam(budgetRequestParam);
        Budget budget = ListUtil.copy(budgetRequestParam, Budget.class);
        logger.info("判断数据是否存在(存在则更新，不存在插入)");
        Example example = new Example(Budget.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("interfaceCode", budget.getInterfaceCode());
        criteria.andEqualTo("dataResource", budget.getDataResource());
        Budget budgetByExample = budgetDao.selectOneByExample(example);
        Date currentSqlDate = commonUtilsService.getCurrentSqlDate();
        Date dateWithoutTime = commonUtilsService.getCurrentSqlDateWithoutTime(currentSqlDate);
        budget.setBizTimeStamp(currentSqlDate);
        budget.setBizDate(dateWithoutTime);
        if (budgetByExample == null) {
            //插入主表，支出预算
            budget.setBudgetGuid(UUIDGenerator.randomUUID());
            budgetDao.insert(budget);
            //插入子表
            insertChildTableBudgetMoney(budgetRequestParam, budget.getBudgetGuid());
        } else {
            //更新主表，支出预算
            budget.setBudgetGuid(budgetByExample.getBudgetGuid());
            budgetDao.updateByPrimaryKey(budget);
            //更新子表
            updateChildTableBudgetMoney(budgetRequestParam, budget.getBudgetGuid());

        }
        Gson gson = new Gson();
        ReturnMessage returnMessage = new ReturnMessage();
        returnMessage.setCode("200");
        returnMessage.setMsg("保存成功");
        gson.toJson(returnMessage);
        responseInfoVo.returnSuccessResult(gson.toJson(returnMessage), null);
        return responseInfoVo;
    }

    @Override
    public int getBudget(String interfaceCode, String datasource) {
        Map<String, Object> map = new HashMap<>();
        map.put("interfaceCode", interfaceCode);
        map.put("datasource", datasource);
        return budgetDao.getBudget(map);
    }

    /**
     * 插入子表 T_A_BudgetMoney 支出预算资金明细
     *
     * @param budgetRequestParam
     * @param budgetGuid
     */
    private void insertChildTableBudgetMoney(BudgetRequestParam budgetRequestParam, String budgetGuid) throws Exception {
        List<Budgetmoney> budgetmoneyList = budgetRequestParam.getBudgetmoneyList();
        if (CollectionUtils.isNotEmpty(budgetmoneyList)) {
            for (Budgetmoney budgetmoney : budgetmoneyList) {
                //校验数据
                checkBudgetmoneyRequestParam(budgetmoney);
                //插入支出预算资金明细
                budgetmoney.setBudgetGuid(budgetGuid);
                budgetmoney.setBudgetMoneyGuid(UUIDGenerator.randomUUID());
                budgetmoneyDao.insert(budgetmoney);
            }
        }

    }

    /**
     * 校验t_a_budgetmoney表请求参数
     *
     * @Param: [budgetmoney]
     * @return: void
     * @Author: Znw · Smile
     * @CreateDate: 2020-5-13 16:57
     */
    private void checkBudgetmoneyRequestParam(Budgetmoney budgetmoney) throws Exception {
        if (StringUtils.isBlank(budgetmoney.getInterfaceCode())) {
            throw new Exception("推送失败：InterfaceCode为空");
        } else if (StringUtils.isBlank(budgetmoney.getDataResource())) {
            throw new Exception("推送失败：DataResource为空");
        } else if (null == budgetmoney.getResourceGuid()) {
            throw new Exception("推送失败：ResourceGuid为空");
        } else if (null == budgetmoney.getIsBuyitem()) {
            throw new Exception("推送失败：IsBuyitem为空");
        } else if (null == budgetmoney.getMoney()) {
            throw new Exception("推送失败：Money为空");
        } else if (null == budgetmoney.getValid()) {
            throw new Exception("推送失败：Valid为空");
        }
    }

    /**
     * 更新子表 T_A_BudgetMoney 支出预算资金明细
     *
     * @param budgetRequestParam
     * @param budgetGuid
     */
    private void updateChildTableBudgetMoney(BudgetRequestParam budgetRequestParam, String budgetGuid) throws Exception {
        List<Budgetmoney> budgetmoneyList = budgetRequestParam.getBudgetmoneyList();
        //更新，支出预算资金明细id
        List budgetInterfaceCodeList = new ArrayList<String>();
        if (CollectionUtils.isNotEmpty(budgetmoneyList)) {
            for (Budgetmoney budgetmoney : budgetmoneyList) {
                //校验数据
                checkBudgetmoneyRequestParam(budgetmoney);
                Example budgetmoneyExample = new Example(Budgetmoney.class);
                Example.Criteria budgetmoneyExampleCriteria = budgetmoneyExample.createCriteria();
                budgetmoneyExampleCriteria.andEqualTo("interfaceCode", budgetmoney.getInterfaceCode());
                budgetmoneyExampleCriteria.andEqualTo("dataResource", budgetmoney.getDataResource());
                Budgetmoney budgetmoneyByExample = budgetmoneyDao.selectOneByExample(budgetmoneyExample);

                if (budgetmoneyByExample == null) {
                    //插入支出预算资金明细
                    budgetmoney.setBudgetGuid(budgetGuid);
                    budgetmoney.setBudgetMoneyGuid(UUIDGenerator.randomUUID());
                    budgetmoneyDao.insert(budgetmoney);
                } else {
                    //更新支出预算资金明细
                    budgetmoney.setBudgetGuid(budgetGuid);
                    budgetmoney.setBudgetMoneyGuid(budgetmoneyByExample.getBudgetMoneyGuid());
                    budgetmoneyDao.updateByPrimaryKey(budgetmoney);
                }
                budgetInterfaceCodeList.add(budgetmoney.getInterfaceCode());
            }
        }

        //删除失效数据
        Example example = new Example(Budgetmoney.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("dataResource", budgetRequestParam.getDataResource());
        criteria.andEqualTo("budgetGuid", budgetGuid);
        if (CollectionUtils.isNotEmpty(budgetInterfaceCodeList)) {
            criteria.andNotIn("interfaceCode", budgetInterfaceCodeList);
        }
        budgetmoneyDao.deleteByExample(example);
    }


    private void checkBudgetRequestParam(BudgetRequestParam budgetRequestParam) throws Exception {
        // 请求参数校验
        if (StringUtils.isBlank(budgetRequestParam.getInterfaceCode())
                || StringUtils.isBlank(budgetRequestParam.getDataResource())) {
            throw new Exception("支出预算推送失败：interfaceCode或dataResource为空");
        } else if (null == budgetRequestParam.getBudgetCode()) {
            throw new Exception("支出预算推送失败：BudgetCode为空");
        } else if (null == budgetRequestParam.getRegionGuid()) {
            throw new Exception("支出预算推送失败：RegionGuid为空");
        } else if (null == budgetRequestParam.getYear()) {
            throw new Exception("支出预算推送失败：Year为空");
        } else if (null == budgetRequestParam.getOrgGuid()) {
            throw new Exception("支出预算推送失败：OrgGuid为空");
        } else if (null == budgetRequestParam.getFinanceDeptGuid()) {
            throw new Exception("支出预算推送失败：FinanceDeptGuid为空");
        } else if (null == budgetRequestParam.getConfirmDate()) {
            throw new Exception("支出预算推送失败：ConfirmDate为空");
        } else if (null == budgetRequestParam.getBudgetMoney()) {
            throw new Exception("支出预算推送失败：BudgetMoney为空");
        } else if (null == budgetRequestParam.getIsBuyitem()) {
            throw new Exception("支出预算推送失败：IsBuyitem为空");
        } else if (null == budgetRequestParam.getBizValid()) {
            throw new Exception("支出预算推送失败：BizValid为空");
        }

        // 基础数据校验
        int region = regionService.getRegion(budgetRequestParam.getRegionGuid());
        if (StatusEnum.FALSE.getValue() == region) {
            throw new ParamException("支出预算转换异常:数据中心找不到对应regionGuid:" + budgetRequestParam.getRegionGuid());
        }

        int organization = organizationService.getOrganization(budgetRequestParam.getOrgGuid());
        if (StatusEnum.FALSE.getValue() == organization) {
            throw new ParamException("支出预算转换异常:数据中心找不到对应OrgGuid:" + budgetRequestParam.getOrgGuid());
        }

        int financedept = financedeptService.getFinanceDept(budgetRequestParam.getFinanceDeptGuid());
        if (StatusEnum.FALSE.getValue() == financedept) {
            throw new ParamException("支出预算转换异常:数据中心找不到对应FinanceDeptGuid:" + budgetRequestParam.getFinanceDeptGuid());
        }

        int purCatalog = purcatalogService.getPurCatalog(budgetRequestParam.getPurcatalogGuid());
        if (StatusEnum.FALSE.getValue() == purCatalog) {
            throw new ParamException("支出预算转换异常:数据中心找不到对应PurcatalogGuid:" + budgetRequestParam.getPurcatalogGuid());
        }

        // 枚举值校验
        Short isBuyitem = budgetRequestParam.getIsBuyitem();
        String buyitemCheckParam = String.valueOf(isBuyitem);
        Optionlist isBuyitemOptionlist = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Is_Buyitem, buyitemCheckParam);
        if (null == isBuyitemOptionlist) {
            throw new ParamException("支出预算枚举值异常:数据中心找不到对应枚举值IsBuyitem:" + buyitemCheckParam);
        }

        BigDecimal povertyReliefMoney = budgetRequestParam.getPovertyReliefMoney();
        String porvertyCheckParam = String.valueOf(povertyReliefMoney);
        Optionlist porvertyOptionlist = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Is_Poverty_Relief, porvertyCheckParam);
        if (null == porvertyOptionlist) {
            throw new ParamException("支出预算枚举值异常:数据中心找不到对应枚举值tPovertyReliefMoney:" + porvertyCheckParam);
        }

        Optionlist kindOptionlist = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Kind, budgetRequestParam.getKind());
        if (null == kindOptionlist) {
            throw new ParamException("支出预算枚举值异常:数据中心找不到对应枚举值Kind:" + budgetRequestParam.getKind());
        }

        Optionlist purcatalogOptionlist = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_PurCatalogType, budgetRequestParam.getPurcatalogType());
        if (null == purcatalogOptionlist) {
            throw new ParamException("支出预算枚举值异常:数据中心找不到对应枚举值PurcatalogType:" + budgetRequestParam.getPurcatalogType());
        }

        int bizValid = budgetRequestParam.getBizValid();
        String bizValidCheckparam = String.valueOf(bizValid);
        Optionlist bizValidOptionlist = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Biz_Valid, bizValidCheckparam);
        if (null == bizValidOptionlist) {
            throw new ParamException("支出预算枚举值异常:数据中心找不到对应枚举值BizValid:" + bizValidCheckparam);
        }
    }
}
