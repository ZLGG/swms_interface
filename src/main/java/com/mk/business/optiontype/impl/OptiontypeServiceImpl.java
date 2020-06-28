package com.mk.business.optiontype.impl;

import com.mk.business.optiontype.model.Optiontype;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.mk.business.optiontype.dao.OptiontypeDao;
import com.mk.business.optiontype.service.OptiontypeService;
import org.springframework.transaction.annotation.Transactional;

/**
*Description: 选项类别
*Created by zhangnengwei on 2020-4-8 15:26
*/
@Service
@Primary
public class OptiontypeServiceImpl implements OptiontypeService{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private OptiontypeDao optiontypeDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdateOptionType(Optiontype optiontype) {
        logger.info("判断数据是否存在(存在则更新，不存在插入)");
        //根据主键查询该数据
        Optiontype optiontypeInfo = optiontypeDao.selectByPrimaryKey(optiontype);
        if (null != optiontypeInfo) {
            logger.info("开始: 更新数据");
            optiontypeDao.updateByPrimaryKeySelective(optiontype);
        } else {
            logger.info("开始: 新增数据");
            optiontypeDao.insertSelective(optiontype);
        }
    }
}
