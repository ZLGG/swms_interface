package com.mk.business.budget.dao;

import com.mk.business.budget.model.Budget;
import tk.mybatis.mapper.common.Mapper;

import java.util.Map;

/**
*Description:支出预算Dao
*Created by zhangnengwei on 2020-4-7 14:59
*/
public interface BudgetDao extends Mapper<Budget> {

    int getBudget(Map<String,Object> map);
}
