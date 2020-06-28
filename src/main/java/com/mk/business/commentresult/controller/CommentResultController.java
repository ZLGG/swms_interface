package com.mk.business.commentresult.controller;

import com.alibaba.fastjson.JSON;
import com.mk.business.Constance.Constance;
import com.mk.business.commentresult.service.CommentResultService;
import com.mk.business.commentresult.vo.CommenResultVO;
import com.mk.business.commonutils.model.Interfacesituation;
import com.mk.business.commonutils.service.CommonUtilsService;
import com.mk.utils.model.ReturnMessage;
import com.mk.utils.request.RequestInfoVo;
import com.mk.utils.request.ResponseInfoVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "采购评审结果")
@RestController
public class CommentResultController {
    @Autowired
    private CommentResultService commentResultService;

    @Autowired
    private CommonUtilsService commonUtilsService;

    @RequestMapping(value = "/saveCommentResult.do", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseInfoVo saveOrUpdateCommentResult(@RequestBody RequestInfoVo requestInfoVo) {
        ResponseInfoVo responseInfoVo = new ResponseInfoVo();
        try {
            ReturnMessage returnMessage = commentResultService.saveOrUpdateCommentResult(requestInfoVo);
            //插入接口执行情况
            Interfacesituation interfacesituation =new Interfacesituation();
            interfacesituation.setInterfaceName(Constance.CommentResultsaveCommentResult);
            interfacesituation.setInterfaceUrl("/saveCommentResult.do");
            interfacesituation.setInterfaceState("成功");
            interfacesituation.setInterfaceSituation("成功");
            interfacesituation.setInterfaceDesc("新增评审过程信息");
            commonUtilsService.insertInterfacesituation(interfacesituation);
            responseInfoVo.returnSuccessResult(JSON.toJSONString(returnMessage), "新增评审过程信息成功");
            return responseInfoVo;
        } catch (Exception e) {
            e.printStackTrace();
            //插入接口执行情况
            Interfacesituation interfacesituation =new Interfacesituation();
            interfacesituation.setInterfaceName(Constance.CommentResultsaveCommentResult);
            interfacesituation.setInterfaceUrl("/saveCommentResult.do");
            interfacesituation.setInterfaceState("失败");
            interfacesituation.setInterfaceSituation(e.getMessage());
            interfacesituation.setInterfaceDesc("新增评审过程信息");
            commonUtilsService.insertInterfacesituation(interfacesituation);
            responseInfoVo.returnErrorResult("-2","新增评审过程失败"+e.toString());
            return responseInfoVo;
        }
    }
}
