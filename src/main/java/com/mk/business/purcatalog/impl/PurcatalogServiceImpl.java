package com.mk.business.purcatalog.impl;

import com.mk.business.purcatalog.model.Purcatalog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.mk.business.purcatalog.dao.PurcatalogDao;
import com.mk.business.purcatalog.service.PurcatalogService;
import org.springframework.transaction.annotation.Transactional;

/**
*Description: 采购目录
*Created by zhangnengwei on 2020-4-8 15:02
*/
@Service
@Primary
public class PurcatalogServiceImpl implements PurcatalogService{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PurcatalogDao purcatalogDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdatePurCatalog(Purcatalog purcatalog) {
        logger.info("判断数据是否存在(存在则更新，不存在插入)");
        //根据主键查询该数据
        Purcatalog purcatalogInfo = purcatalogDao.selectByPrimaryKey(purcatalog);
        if (null != purcatalogInfo) {
            logger.info("开始: 更新数据");
            purcatalogDao.updateByPrimaryKeySelective(purcatalog);
        } else {
            logger.info("开始: 新增数据");
            purcatalogDao.insertSelective(purcatalog);
        }
    }

    @Override
    public Integer getPurCatalog(String purcatalogGuid) {
        Integer num = purcatalogDao.countByPrimaryKey(purcatalogGuid);
        return num;
    }
}
