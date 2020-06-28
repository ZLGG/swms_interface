package com.mk.business.trustinfo.controller;


import com.alibaba.fastjson.JSON;
import com.mk.business.trustinfo.service.TrustinfoService;
import com.mk.utils.model.ReturnMessage;
import com.mk.utils.request.RequestInfoVo;
import com.mk.utils.request.ResponseInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrustinfoController {


    @Autowired
    private TrustinfoService trustinfoService;

    @RequestMapping(value = "/saveOrUpdateTrustinfo", method = RequestMethod.POST, consumes = "application/json;charset=utf-8")
    public ResponseInfoVo saveOrUpdateTrustinfo(@RequestBody RequestInfoVo requestInfoVo) {
        ResponseInfoVo responseInfoVo = new ResponseInfoVo();
        try {
            ReturnMessage returnMessage = trustinfoService.saveOrUpdateTrustinfo(requestInfoVo);
            responseInfoVo.returnSuccessResult(JSON.toJSONString(returnMessage),"采购委托信息保存失败");
            return responseInfoVo;
        } catch (Exception e) {
            e.printStackTrace();
            responseInfoVo.returnErrorResult("-2",e.getMessage()+"采购委托信息保存失败");
            return responseInfoVo;
        }
    }

}
