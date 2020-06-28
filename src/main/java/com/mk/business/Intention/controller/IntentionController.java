package com.mk.business.Intention.controller;

import com.alibaba.fastjson.JSON;
import com.mk.business.Intention.service.IntentionService;
import com.mk.utils.model.ReturnMessage;
import com.mk.utils.request.RequestInfoVo;
import com.mk.utils.request.ResponseInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IntentionController {

    @Autowired
    private IntentionService intentionService;

    @RequestMapping(value = "/saveOrUpdateIntention", method = RequestMethod.POST, consumes = "application/json;charset=utf-8")
    public ResponseInfoVo saveOrUpdateIntention(@RequestBody RequestInfoVo requestInfoVo) {
        ResponseInfoVo responseInfoVo = new ResponseInfoVo();

        try {
            ReturnMessage returnMessage = intentionService.saveOrUpdateIntention(requestInfoVo);
            responseInfoVo.returnSuccessResult(JSON.toJSONString(returnMessage),"意向公开信息保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            responseInfoVo.returnErrorResult("-2","意向公开信息保存失败");
        }
        return responseInfoVo;
    }
}
