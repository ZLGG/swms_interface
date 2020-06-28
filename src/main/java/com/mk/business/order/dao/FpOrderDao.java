package com.mk.business.order.dao;

import com.mk.business.order.model.FpOrder;

import java.util.HashMap;

public interface FpOrderDao {
    int deleteByPrimaryKey(String orderId);

    int insert(FpOrder record);

    int insertSelective(FpOrder record);

    FpOrder selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(FpOrder record);

    int updateByPrimaryKey(FpOrder record);

    FpOrder getOrderByInterfaceCode(HashMap<String, String> condition);

}