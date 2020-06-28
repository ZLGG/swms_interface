package com.mk.business.supplier.dao;

import com.mk.business.supplier.model.Supplier;

public interface SupplierDao {
    int deleteByPrimaryKey(String supplierGuid);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    Supplier selectByPrimaryKey(String supplierGuid);

    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);
}