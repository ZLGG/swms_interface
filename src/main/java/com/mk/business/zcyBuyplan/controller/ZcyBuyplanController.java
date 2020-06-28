package com.mk.business.zcyBuyplan.controller;

import com.alibaba.fastjson.JSON;
import com.mk.business.zcyBuyplan.servcie.ZcyBuyplanService;
import com.mk.utils.model.ReturnMessage;
import com.mk.utils.request.RequestInfoVo;
import com.mk.utils.request.ResponseInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZcyBuyplanController {

    @Autowired
    private ZcyBuyplanService zcyBuyplanService;

    @RequestMapping(value = "/saveOrUpdateZcyBuyplan", method = RequestMethod.POST, consumes = "application/json;charset=utf-8")
    public ResponseInfoVo saveOrUpdateZcyBuyplan(@RequestBody RequestInfoVo requestInfoVo) {
        ResponseInfoVo responseInfoVo = new ResponseInfoVo();
        try {
            ReturnMessage returnMessage = zcyBuyplanService.saveOrUpdateZcyBuyplan(requestInfoVo);
            responseInfoVo.returnSuccessResult(JSON.toJSONString(returnMessage), "政采云采购计划保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            responseInfoVo.returnErrorResult("-2",e.getMessage()+"政采云采购计划保存失败");
        }
        return responseInfoVo;
    }
}
