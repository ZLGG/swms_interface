package com.mk.business.buyplan.dao;

import com.mk.business.buyplan.model.Buyplan;
import tk.mybatis.mapper.common.Mapper;

import java.util.Map;

/**
*Description:采购计划Dao
*Created by zhangnengwei on 2020-4-7 17:30
*/
public interface BuyplanDao extends Mapper<Buyplan> {
    int getBuyplan(Map<String,Object> map);
}
