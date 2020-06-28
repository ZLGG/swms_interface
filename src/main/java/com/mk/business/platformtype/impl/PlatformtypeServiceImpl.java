package com.mk.business.platformtype.impl;

import com.mk.business.platformtype.model.Platformtype;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.mk.business.platformtype.dao.PlatformtypeDao;
import com.mk.business.platformtype.service.PlatformtypeService;
import org.springframework.transaction.annotation.Transactional;

/**
*Description: 实施形式分类
*Created by zhangnengwei on 2020-4-8 15:35
*/
@Service
@Primary
public class PlatformtypeServiceImpl implements PlatformtypeService{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PlatformtypeDao platformtypeDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdatePlatformType(Platformtype platformtype) {
        logger.info("判断数据是否存在(存在则更新，不存在插入)");
        //根据主键查询该数据
        Platformtype platformtypeInfo = platformtypeDao.selectByPrimaryKey(platformtype);
        if (null != platformtypeInfo) {
            logger.info("开始: 更新数据");
            platformtypeDao.updateByPrimaryKeySelective(platformtype);
        } else {
            logger.info("开始: 新增数据");
            platformtypeDao.insertSelective(platformtype);
        }
    }

    @Override
    public Integer getPlatformType(String platformTypeGuid) {
        Integer num = platformtypeDao.countByPrimaryKey(platformTypeGuid);
        return num;
    }
}
