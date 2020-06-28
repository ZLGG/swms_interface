package com.mk.business.pay.controller;

import com.mk.business.Constance.Constance;
import com.mk.business.commonutils.model.Interfacesituation;
import com.mk.business.commonutils.service.CommonUtilsService;
import com.mk.business.pay.param.PayRequestParam;
import com.mk.business.pay.service.PayService;
import com.mk.utils.model.ReturnMessage;
import com.mk.utils.request.RequestInfoVo;
import com.mk.utils.request.ResponseInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description:资金支付Controller
 * Created by zhangnengwei on 2020-4-7 19:01
 */
@RestController
@Api(description = "资金支付")
public class PayController {
    @Autowired
    private PayService payService;

    @Autowired
    private CommonUtilsService commonUtilsService;

    @ApiOperation(value = "新增/更新资金支付信息", notes = "新增/更新资金支付信息")
    @RequestMapping(value = "/saveOrUpdatePayment.do",method = RequestMethod.POST,consumes = "application/json;charset=utf-8")
    public ResponseInfoVo saveOrUpdatePayment (@RequestBody RequestInfoVo requestInfoVo) throws Exception {
        ResponseInfoVo responseInfoVo =new ResponseInfoVo();
        try {
            responseInfoVo = payService.saveOrUpdatePayment(requestInfoVo);
            //插入接口执行情况
            Interfacesituation interfacesituation = new Interfacesituation();
            interfacesituation.setInterfaceName(Constance.PaysaveOrUpdatePayment);
            interfacesituation.setInterfaceUrl("/saveOrUpdatePayment.do");
            interfacesituation.setInterfaceState("成功");
            interfacesituation.setInterfaceSituation("成功");
            interfacesituation.setInterfaceDesc("新增/更新资金支付信息");
            commonUtilsService.insertInterfacesituation(interfacesituation);
        } catch (Exception e) {
            e.printStackTrace();
            //插入接口执行情况
            Interfacesituation interfacesituation = new Interfacesituation();
            interfacesituation.setInterfaceName(Constance.PaysaveOrUpdatePayment);
            interfacesituation.setInterfaceUrl("/saveOrUpdatePayment.do");
            interfacesituation.setInterfaceState("失败");
            interfacesituation.setInterfaceSituation(e.getMessage());
            interfacesituation.setInterfaceDesc("新增/更新资金支付信息");
            commonUtilsService.insertInterfacesituation(interfacesituation);
            responseInfoVo.returnErrorResult("-1","系统异常:"+e.getMessage());
        }
        return responseInfoVo;
    }
}
