package com.mk.business.resource.impl;

import com.mk.business.resource.model.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.mk.business.resource.dao.ResourceDao;
import com.mk.business.resource.service.ResourceService;
import org.springframework.transaction.annotation.Transactional;

/**
*Description: 采购预算资金来源
*Created by zhangnengwei on 2020-4-8 16:30
*/
@Service
@Primary
public class ResourceServiceImpl implements ResourceService{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ResourceDao resourceDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdateResource(Resource resource) {
        logger.info("判断数据是否存在(存在则更新，不存在插入)");
        //根据主键查询该数据
        Resource resourceInfo = resourceDao.selectByPrimaryKey(resource);
        if (null != resourceInfo) {
            logger.info("开始: 更新数据");
            resourceDao.updateByPrimaryKeySelective(resource);
        } else {
            logger.info("开始: 新增数据");
            resourceDao.insertSelective(resource);
        }
    }

    @Override
    public int getResource(String resourceGuid) {
        return resourceDao.getResource(resourceGuid);
    }
}
