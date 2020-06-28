package com.mk.business.fpsupplier.controller;


import com.alibaba.fastjson.JSON;
import com.mk.business.fpsupplier.service.FpSuppllierService;
import com.mk.utils.model.ReturnMessage;
import com.mk.utils.request.RequestInfoVo;
import com.mk.utils.request.ResponseInfoVo;
import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FpSuppllierController {

    @Autowired
    private FpSuppllierService fpSuppllierService;


    @RequestMapping(value = "/saveOrUpdateFpSupplier",method = RequestMethod.POST,consumes = "application/json;charset=utf-8")
    public ResponseInfoVo saveOrUpdateFpSupplier(@RequestBody RequestInfoVo requestInfoVo) {
        ResponseInfoVo responseInfoVo = new ResponseInfoVo();
        try {
            ReturnMessage returnMessage = fpSuppllierService.saveOrUpdateFpSupplier(requestInfoVo);
            responseInfoVo.returnSuccessResult(JSON.toJSONString(returnMessage), "扶贫馆供应商信息保存成功");
            return responseInfoVo;
        } catch (Exception e) {
            e.printStackTrace();
            responseInfoVo.returnErrorResult("-2",e.getMessage()+"扶贫馆供应商信息保存失败");
            return responseInfoVo;
        }
    }
}
