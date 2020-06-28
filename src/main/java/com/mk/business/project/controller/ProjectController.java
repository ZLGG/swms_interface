package com.mk.business.project.controller;

import com.alibaba.fastjson.JSON;
import com.mk.business.Constance.Constance;
import com.mk.business.commonutils.model.Interfacesituation;
import com.mk.business.commonutils.service.CommonUtilsService;
import com.mk.business.project.Impl.ProjectServiceImpl;
import com.mk.business.project.service.ProjectService;
import com.mk.business.project.vo.ProjectVO;
import com.mk.utils.model.ReturnMessage;
import com.mk.utils.request.RequestInfoVo;
import com.mk.utils.request.ResponseInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.omg.PortableInterceptor.RequestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "采购项目管理")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private CommonUtilsService commonUtilsService;

    @RequestMapping(value = "/saveOrUpdateProject.do",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    @ApiOperation(value = "保存采购项目")
    public ResponseInfoVo saveOrUpdateProject(@RequestBody RequestInfoVo requestInfoVo) {
        ResponseInfoVo responseInfoVo = new ResponseInfoVo();

        try {
            ReturnMessage returnMessage = projectService.saveOrUpdateProject(requestInfoVo);
            //插入接口执行情况
            Interfacesituation interfacesituation =new Interfacesituation();
            interfacesituation.setInterfaceName(Constance.ProjectsaveOrUpdateProject);
            interfacesituation.setInterfaceUrl("/saveOrUpdateProject.do");
            interfacesituation.setInterfaceState("成功");
            interfacesituation.setInterfaceSituation("成功");
            interfacesituation.setInterfaceDesc("新增/更新采购项目信息");
            commonUtilsService.insertInterfacesituation(interfacesituation);
            responseInfoVo.returnSuccessResult(JSON.toJSONString(returnMessage), "保存采购项目成功");
            return responseInfoVo;
        } catch (Exception e) {
            e.printStackTrace();
            //插入接口执行情况
            Interfacesituation  interfacesituation =new Interfacesituation();
            interfacesituation.setInterfaceName(Constance.ProjectsaveOrUpdateProject);
            interfacesituation.setInterfaceUrl("/saveOrUpdateProject.do");
            interfacesituation.setInterfaceState("失败");
            interfacesituation.setInterfaceSituation(e.getMessage());
            interfacesituation.setInterfaceDesc("新增/更新采购项目信息");
            commonUtilsService.insertInterfacesituation(interfacesituation);
            responseInfoVo.returnErrorResult("-2","新增/更新采购项目失败" + e.getMessage());
            return responseInfoVo;

        }
    }
}
