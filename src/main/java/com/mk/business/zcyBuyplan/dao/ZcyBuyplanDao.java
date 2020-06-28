package com.mk.business.zcyBuyplan.dao;

import com.mk.business.zcyBuyplan.model.ZcyBuyplan;

public interface ZcyBuyplanDao {
    int deleteByPrimaryKey(String purchaseplanId);

    int insert(ZcyBuyplan record);

    int insertSelective(ZcyBuyplan record);

    ZcyBuyplan selectByPrimaryKey(String purchaseplanId);

    int updateByPrimaryKeySelective(ZcyBuyplan record);

    int updateByPrimaryKey(ZcyBuyplan record);
}