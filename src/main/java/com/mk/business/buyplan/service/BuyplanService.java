package com.mk.business.buyplan.service;

import com.mk.business.buyplan.param.BuyPlanRequestParam;
import com.mk.utils.model.ReturnMessage;
import com.mk.utils.request.RequestInfoVo;
import com.mk.utils.request.ResponseInfoVo;

import java.util.List;

/**
*Description:采购计划Service
*Created by zhangnengwei on 2020-4-7 17:30
*/
public interface BuyplanService{

    /**
     * @Description:新增/保存采购计划
     * @Author: zhangnengwei
     * @Date: 2020-4-7 17:38
     * @return
     */
    ResponseInfoVo saveOrUpdateBuyplan(RequestInfoVo requestInfoVo) throws Exception;

    int getBuyplan(String interfaceCode,String dataResource);
}
