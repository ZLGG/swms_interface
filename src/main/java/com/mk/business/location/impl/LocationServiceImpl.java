package com.mk.business.location.impl;

import com.mk.business.location.model.Location;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.mk.business.location.dao.LocationDao;
import com.mk.business.location.service.LocationService;
import org.springframework.transaction.annotation.Transactional;


/**
*Description:行政区划
*Created by zhangnengwei on 2020-4-8 14:03
*/
@Service
@Primary
public class LocationServiceImpl implements LocationService{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private LocationDao locationDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdateLocation(Location location) {
        logger.info("判断数据是否存在(存在则更新，不存在插入)");
        //根据主键查询该数据
        Location locationInfo = locationDao.selectByPrimaryKey(location);
        if (null != locationInfo) {
            logger.info("开始: 更新数据");
            locationDao.updateByPrimaryKeySelective(location);
        } else {
            logger.info("开始: 新增数据");
            locationDao.insertSelective(location);
        }
    }

    @Override
    public Integer getLocation(String locationGuid) {
        return locationDao.getLocation(locationGuid);
    }
}
