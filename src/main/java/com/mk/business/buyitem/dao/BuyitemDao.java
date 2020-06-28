package com.mk.business.buyitem.dao;

import com.mk.business.buyitem.model.Buyitem;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.Map;

/**
*Description:采购预算Dao
*Created by zhangnengwei on 2020-4-7 10:56
*/
public interface BuyitemDao extends Mapper<Buyitem> {

    int getBuyitem(Map<String,Object> map);
}
