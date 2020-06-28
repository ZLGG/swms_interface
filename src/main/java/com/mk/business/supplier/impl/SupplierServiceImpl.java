package com.mk.business.supplier.impl;

import com.mk.business.commonutils.service.CommonUtilsService;
import com.mk.business.supplier.model.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.mk.business.supplier.dao.SupplierDao;
import com.mk.business.supplier.service.SupplierService;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Date;

/**
*Description:
*Created by zhangnengwei on 2020-4-8 17:26
*/
@Service
@Primary
public class SupplierServiceImpl implements SupplierService{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SupplierDao supplierDao;

    @Autowired
    private CommonUtilsService commonUtilsService;

    @Override
    @Transactional
    public void saveOrUpdateSupplierInfo(Supplier supplier) throws Exception {
        logger.info("判断数据是否存在(存在则更新，不存在插入)");
        // 根据主键查询该数据
        Supplier supplierInfo = supplierDao.selectByPrimaryKey(supplier.getSupplierGuid());
        // 设置时间戳
        Date currentSqlDate = commonUtilsService.getCurrentSqlDate();
        Date dateWithoutTime = commonUtilsService.getCurrentSqlDateWithoutTime(currentSqlDate);
        supplier.setBizTimeStamp(currentSqlDate);
        supplier.setBizDate(dateWithoutTime);
        if (null != supplierInfo) {
            logger.info("开始: 更新数据");
            supplierDao.updateByPrimaryKey(supplier);
        } else {
            logger.info("开始: 新增数据");
            supplierDao.insert(supplier);
        }
    }

    @Override
    public Integer getSupplier(String supplierGuid) {
        Supplier supplier = supplierDao.selectByPrimaryKey(supplierGuid);
        if (supplier == null) {
            return 0;
        }
        return 1;
    }
}
