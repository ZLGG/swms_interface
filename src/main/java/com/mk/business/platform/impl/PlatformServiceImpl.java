package com.mk.business.platform.impl;

import com.mk.business.platform.model.Platform;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.mk.business.platform.dao.PlatformDao;
import com.mk.business.platform.service.PlatformService;
import org.springframework.transaction.annotation.Transactional;

/**
*Description: 实施形式
*Created by zhangnengwei on 2020-4-8 15:52
*/
@Service
@Primary
public class PlatformServiceImpl implements PlatformService{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PlatformDao platformDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdatePlatform(Platform platform) {
        logger.info("判断数据是否存在(存在则更新，不存在插入)");
        //根据主键查询该数据
        Platform platformInfo = platformDao.selectByPrimaryKey(platform);
        if (null != platformInfo) {
            logger.info("开始: 更新数据");
            platformDao.updateByPrimaryKeySelective(platform);
        } else {
            logger.info("开始: 新增数据");
            platformDao.insertSelective(platform);
        }
    }

    @Override
    public Integer getPlatform(String platformGuid) {
        Integer num = platformDao.countPlatformByPrimaryKey(platformGuid);
        return num;
    }
}
