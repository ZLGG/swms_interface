package com.mk.business.buyitem.service;

import com.mk.business.buyitem.model.Buyitem;

import com.mk.utils.request.RequestInfoVo;
import com.mk.utils.request.ResponseInfoVo;

/**
*Description: 采购预算Service
*Created by zhangnengwei on 2020-4-7 10:56
*/
public interface BuyitemService{


    int deleteByPrimaryKey(String buyitemGuid);

    int insert(Buyitem record);

    int insertSelective(Buyitem record);

    Buyitem selectByPrimaryKey(String buyitemGuid);

    int updateByPrimaryKeySelective(Buyitem record);

    int updateByPrimaryKey(Buyitem record);

    /**
     * @Description:新增/保存采购预算
     * @Author: zhangnengwei
     * @Date: 2020-4-7 11:28
     * @return
     */
    ResponseInfoVo saveOrUpdateBuyitem(RequestInfoVo requestInfoVo) throws Exception;

    int getBuyitem(String interfaceCode,String dataResource);

    }
