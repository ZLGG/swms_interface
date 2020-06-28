package com.mk.business.order.service;

import com.mk.utils.model.ReturnMessage;
import com.mk.utils.request.RequestInfoVo;

public interface OrderService {
    /**
     * 保存或更新 扶贫馆订单信息
     * @param requestInfoVo
     * @return
     */
    ReturnMessage saveOrUpdateOrder(RequestInfoVo requestInfoVo) throws Exception;
}
