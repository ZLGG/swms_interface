package com.mk.business.pay.service;

import com.mk.utils.request.RequestInfoVo;
import com.mk.utils.request.ResponseInfoVo;

/**
*Description: 资金支付Service
*Created by zhangnengwei on 2020-4-7 19:00
*/
public interface PayService{

    /**
     * @Description:新增/修改资金支付信息
     * @Author: zhangnengwei
     * @Date: 2020-4-7 19:04
     */
    ResponseInfoVo saveOrUpdatePayment(RequestInfoVo requestInfoVo) throws Exception;

    int getPay(String interfacecode,String datasource);
}
