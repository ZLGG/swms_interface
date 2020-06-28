package com.mk.business.financedept.impl;

import com.mk.business.financedept.model.Financedept;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.mk.business.financedept.dao.FinancedeptDao;
import com.mk.business.financedept.service.FinancedeptService;
import org.springframework.transaction.annotation.Transactional;

/**
*Description: 财政业务部门
*Created by zhangnengwei on 2020-4-8 15:16
*/
@Service
@Primary
public class FinancedeptServiceImpl implements FinancedeptService{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private FinancedeptDao financedeptDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdateFinanceDept(Financedept financedept) {
        logger.info("判断数据是否存在(存在则更新，不存在插入)");
        //根据主键查询该数据
        Financedept financedeptInfo = financedeptDao.selectByPrimaryKey(financedept);
        if (null != financedeptInfo) {
            logger.info("开始: 更新数据");
            financedeptDao.updateByPrimaryKeySelective(financedept);
        } else {
            logger.info("开始: 新增数据");
            financedeptDao.insertSelective(financedept);
        }
    }

    @Override
    public Integer getFinanceDept(String financeDeptGuid) {
        Integer num = financedeptDao.countFinanceDeptByPrimaryKey(financeDeptGuid);
        return num;
    }

}
