package com.mk.business.order.controller;


import com.alibaba.fastjson.JSON;
import com.mk.business.order.service.OrderService;
import com.mk.utils.model.ReturnMessage;
import com.mk.utils.request.RequestInfoVo;
import com.mk.utils.request.ResponseInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/saveOrUpdateOrder",method = RequestMethod.POST,consumes = "application/json;charset=utf-8")
    public ResponseInfoVo saveOrUpdateOrder(@RequestBody RequestInfoVo requestInfoVo) {
        ResponseInfoVo responseInfoVo = new ResponseInfoVo();
        try {
            ReturnMessage returnMessage = orderService.saveOrUpdateOrder(requestInfoVo);
            responseInfoVo.returnSuccessResult(JSON.toJSONString(returnMessage),"扶贫馆订单信息保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            responseInfoVo.returnErrorResult("-2",e.getMessage()+":扶贫馆订单信息保存失败");
        }
        return responseInfoVo;
    }
}
