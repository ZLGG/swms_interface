package com.mk.business.pay.dao;

import com.mk.business.pay.model.Pay;
import tk.mybatis.mapper.common.Mapper;

import java.util.Map;

/**
*Description:资金支付Dao
*Created by zhangnengwei on 2020-4-7 19:00
*/
public interface PayDao extends Mapper<Pay> {
    int getPay(Map<String,Object> map);
}
