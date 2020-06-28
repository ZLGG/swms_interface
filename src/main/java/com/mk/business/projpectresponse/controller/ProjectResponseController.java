package com.mk.business.projpectresponse.controller;

import com.alibaba.fastjson.JSON;
import com.mk.business.Constance.Constance;
import com.mk.business.commonutils.model.Interfacesituation;
import com.mk.business.commonutils.service.CommonUtilsService;
import com.mk.business.project.vo.ProjectVO;
import com.mk.business.projpectresponse.model.ProjectResponse;
import com.mk.business.projpectresponse.service.ProjectResponseService;
import com.mk.business.projpectresponse.vo.ProjectResponseVO;
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
@Api(description = "投标登记")
public class ProjectResponseController {
    @Autowired
    private ProjectResponseService projectResponseService;
    @Autowired
    private CommonUtilsService commonUtilsService;

    /**
     * 保存投标登记及投标供应商明细
     * @param requestInfoVo
     * @return
     */
    @ApiOperation(value = "保存投标登记")
    @RequestMapping(value = "/saveProjectResponse.do", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseInfoVo saveOrUpdateProjectResponse(@RequestBody RequestInfoVo requestInfoVo) {
        ResponseInfoVo responseInfoVo = new ResponseInfoVo();
        try {
            ReturnMessage returnMessage = projectResponseService.saveOrUpdateProjectResponse(requestInfoVo);
            //插入接口执行情况
            Interfacesituation interfacesituation =new Interfacesituation();
            interfacesituation.setInterfaceName(Constance.ProjectResponsesaveProjectResponse);
            interfacesituation.setInterfaceUrl("/saveProjectResponse.do");
            interfacesituation.setInterfaceState("成功");
            interfacesituation.setInterfaceSituation("成功");
            interfacesituation.setInterfaceDesc("新增投标登记信息");
            commonUtilsService.insertInterfacesituation(interfacesituation);
            responseInfoVo.returnSuccessResult(JSON.toJSONString(returnMessage), "新增投标登记信息成功");
            return responseInfoVo;
        } catch (Exception e) {
            e.printStackTrace();
            //插入接口执行情况
            Interfacesituation  interfacesituation =new Interfacesituation();
            interfacesituation.setInterfaceName(Constance.ProjectResponsesaveProjectResponse);
            interfacesituation.setInterfaceUrl("/saveProjectResponse.do");
            interfacesituation.setInterfaceState("失败");
            interfacesituation.setInterfaceSituation(e.getMessage());
            interfacesituation.setInterfaceDesc("新增投标登记信息");
            commonUtilsService.insertInterfacesituation(interfacesituation);
            responseInfoVo.returnErrorResult("-2", "投标登记信息保存失败" + e.toString());
            return responseInfoVo;
        }
    }
}
