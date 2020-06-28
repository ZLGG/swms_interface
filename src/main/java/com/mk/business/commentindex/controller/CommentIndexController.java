package com.mk.business.commentindex.controller;

import com.alibaba.fastjson.JSON;
import com.mk.business.Constance.Constance;
import com.mk.business.commentindex.service.CommentIndexService;
import com.mk.business.commentindex.vo.CommentIndexVO;
import com.mk.business.commonutils.model.Interfacesituation;
import com.mk.business.commonutils.service.CommonUtilsService;
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

@RestController
@Api(description = "评审指标")
public class CommentIndexController {

    @Autowired
    private CommentIndexService commentIndexService;
    @Autowired
    private CommonUtilsService commonUtilsService;

    @ApiOperation(value = "保存评审指标")
    @RequestMapping(value = "/saveCommentIndex.do", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseInfoVo saveOrUpdateCommentIndex(@RequestBody RequestInfoVo requestInfoVo) {
        ResponseInfoVo responseInfoVo = new ResponseInfoVo();
        try {
            ReturnMessage returnMessage = commentIndexService.saveOrUpdateCommentIndex(requestInfoVo);
            //插入接口执行情况
            Interfacesituation interfacesituation = new Interfacesituation();
            interfacesituation.setInterfaceName(Constance.CommentIndexsaveCommentIndex);
            interfacesituation.setInterfaceUrl("/saveCommentIndex.do");
            interfacesituation.setInterfaceState("成功");
            interfacesituation.setInterfaceSituation("成功");
            interfacesituation.setInterfaceDesc("新增评审指标信息");
            commonUtilsService.insertInterfacesituation(interfacesituation);

            responseInfoVo.returnSuccessResult(JSON.toJSONString(returnMessage), "新增评审指标信息成功");
            return responseInfoVo;
        } catch (Exception e) {
            e.printStackTrace();
            //插入接口执行情况
            Interfacesituation interfacesituation = new Interfacesituation();
            interfacesituation.setInterfaceName(Constance.CommentIndexsaveCommentIndex);
            interfacesituation.setInterfaceUrl("/saveCommentIndex.do");
            interfacesituation.setInterfaceState("失败");
            interfacesituation.setInterfaceSituation(e.getMessage());
            interfacesituation.setInterfaceDesc("新增评审指标信息");
            commonUtilsService.insertInterfacesituation(interfacesituation);
            //new ReturnMessage("400", "评审指标保存失败" + e.toString());
            responseInfoVo.returnErrorResult("-2", "新增评审指标信息失败");
            return responseInfoVo;
        }

    }

}
