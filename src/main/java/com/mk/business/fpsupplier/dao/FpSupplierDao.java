package com.mk.business.fpsupplier.dao;

import com.mk.business.fpsupplier.model.FpSupplier;

public interface FpSupplierDao {
    int deleteByPrimaryKey(String id);

    int insert(FpSupplier record);

    int insertSelective(FpSupplier record);

    FpSupplier selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(FpSupplier record);

    int updateByPrimaryKey(FpSupplier record);

    FpSupplier selectByOrderId(String orderId);
}