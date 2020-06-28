package com.mk.business.budget.service;

import com.mk.business.budget.model.Budget;
import com.mk.utils.request.RequestInfoVo;
import com.mk.utils.request.ResponseInfoVo;

/**
*Description: 支出预算Service
*Created by zhangnengwei on 2020-4-7 14:59
*/
public interface BudgetService{

    int deleteByPrimaryKey(String budgetGuid);

    int insert(Budget record);

    int insertSelective(Budget record);

    Budget selectByPrimaryKey(String budgetGuid);

    int updateByPrimaryKeySelective(Budget record);

    int updateByPrimaryKey(Budget record);

    /**
     * @Description:更新/删除支出预算信息
     * @Author: zhangnengwei
     * @Date: 2020-4-7 15:04
     */
    ResponseInfoVo saveOrUpdateBudget(RequestInfoVo requestInfoVo)throws Exception;


    int getBudget(String interfacecode,String datasource);
}
