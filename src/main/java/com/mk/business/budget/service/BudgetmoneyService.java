package com.mk.business.budget.service;

import com.mk.business.budget.model.Budgetmoney;
    /**
*Description:支出预算资金明细
*Created by zhangnengwei on 2020-4-7 15:02
*/
public interface BudgetmoneyService{


    int deleteByPrimaryKey(String budgetMoneyGuid);

    int insert(Budgetmoney record);

    int insertSelective(Budgetmoney record);

    Budgetmoney selectByPrimaryKey(String budgetMoneyGuid);

    int updateByPrimaryKeySelective(Budgetmoney record);

    int updateByPrimaryKey(Budgetmoney record);

    /**
     * @Description:根据budgetGuid删除支出预算资金明细
     * @Author: zhangnengwei
     * @Date: 2020-4-7 15:27
     */
    void deleteBudgetmoneysByBudgetID(String budgetGuid);
    }
