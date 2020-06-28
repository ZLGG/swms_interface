package com.mk.business.budget.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.mk.business.budget.dao.BudgetmoneyDao;
import com.mk.business.budget.model.Budgetmoney;
import com.mk.business.budget.service.BudgetmoneyService;
import tk.mybatis.mapper.entity.Example;

/**
*Description:支出预算资金明细Impl
*Created by zhangnengwei on 2020-4-7 15:02
*/
@Service
@Primary
public class BudgetmoneyServiceImpl implements BudgetmoneyService{

    @Resource
    private BudgetmoneyDao budgetmoneyDao;

    @Override
    public int deleteByPrimaryKey(String budgetMoneyGuid) {
        return budgetmoneyDao.deleteByPrimaryKey(budgetMoneyGuid);
    }

    @Override
    public int insert(Budgetmoney record) {
        return budgetmoneyDao.insert(record);
    }

    @Override
    public int insertSelective(Budgetmoney record) {
        return budgetmoneyDao.insertSelective(record);
    }

    @Override
    public Budgetmoney selectByPrimaryKey(String budgetMoneyGuid) {
        return budgetmoneyDao.selectByPrimaryKey(budgetMoneyGuid);
    }

    @Override
    public int updateByPrimaryKeySelective(Budgetmoney record) {
        return budgetmoneyDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Budgetmoney record) {
        return budgetmoneyDao.updateByPrimaryKey(record);
    }

    @Override
    public void deleteBudgetmoneysByBudgetID(String budgetGuid){
        Example example = new Example(Budgetmoney.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("budgetGuid",budgetGuid);
        budgetmoneyDao.deleteByExample(example);
    }
}
