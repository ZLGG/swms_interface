package com.mk.business.order.dao;


import com.mk.business.order.model.FpItem;

public interface FpItemDao {
    int deleteByPrimaryKey(String itemGuid);

    int insert(FpItem record);

    int insertSelective(FpItem record);

    FpItem selectByPrimaryKey(String itemGuid);

    int updateByPrimaryKeySelective(FpItem record);

    int updateByPrimaryKey(FpItem record);

    void deleteByOrderId(String orderId);

    void deleteFpsupplierByOrderId(String orderId);
}