package com.mk.business.year.impl;

import com.mk.business.year.model.Year;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.mk.business.year.dao.YearDao;
import com.mk.business.year.service.YearService;
import org.springframework.transaction.annotation.Transactional;

/**
*Description: 年度
*Created by zhangnengwei on 2020-4-8 15:07
*/
@Service
@Primary
public class YearServiceImpl implements YearService{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private YearDao yearDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdateYear(Year year) {
        logger.info("判断数据是否存在(存在则更新，不存在插入)");
        //根据主键查询该数据
        Year yearInfo = yearDao.selectByPrimaryKey(year);
        if (null != yearInfo) {
            logger.info("开始: 更新数据");
            yearDao.updateByPrimaryKeySelective(year);
        } else {
            logger.info("开始: 新增数据");
            yearDao.insertSelective(year);
        }
    }
}
