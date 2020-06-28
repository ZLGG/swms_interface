package com.mk.business.region.impl;

import com.mk.business.region.model.Region;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.mk.business.region.dao.RegionDao;
import com.mk.business.region.service.RegionService;
import org.springframework.transaction.annotation.Transactional;

/**
*Description:
*Created by zhangnengwei on 2020-4-8 14:23
*/
@Service
@Primary
public class RegionServiceImpl implements RegionService{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private RegionDao regionDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdateRegion(Region region) {
        logger.info("判断数据是否存在(存在则更新，不存在插入)");
        //根据主键查询该数据
        Region regionInfo = regionDao.selectByPrimaryKey(region);
        if (null != regionInfo) {
            logger.info("开始: 更新数据");
            regionDao.updateByPrimaryKeySelective(region);
        } else {
            logger.info("开始: 新增数据");
            regionDao.insertSelective(region);
        }
    }

    @Override
    public Integer getRegion(String regionGuid) {
        Integer count = regionDao.getRegion(regionGuid);
        return count;
    }
}
