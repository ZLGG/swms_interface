package com.mk.business.acceptance.controller;

import com.mk.business.Constance.Constance;
import com.mk.business.acceptance.param.AcceptanceRequestParam;
import com.mk.business.acceptance.service.AcceptanceService;
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

import java.util.List;

/**
 * Description:合同履约验收Controller
 * Created by zhangnengwei on 2020-4-7 19:18
 */
@RestController
@Api(description = "合同履约验收")
public class AcceptanceController {
    @Autowired
    private AcceptanceService acceptanceService;
    @Autowired
    private CommonUtilsService commonUtilsService;

    @RequestMapping(value = "/saveOrUpdateAcceptance.do",method = RequestMethod.POST,consumes = "application/json;charset=utf-8")
    public ResponseInfoVo saveOrUpdateAcceptance (@RequestBody RequestInfoVo requestInfoVo) throws Exception{
        ResponseInfoVo responseInfoVo = new ResponseInfoVo();
        try {
            responseInfoVo = acceptanceService.saveOrUpdateAcceptance(requestInfoVo);
            //插入接口执行情况
            Interfacesituation interfacesituation = new Interfacesituation();
            interfacesituation.setInterfaceName(Constance.AcceptancesaveOrUpdateAcceptance);
            interfacesituation.setInterfaceUrl("/saveOrUpdateAcceptance.do");
            interfacesituation.setInterfaceState("成功");
            interfacesituation.setInterfaceSituation("成功");
            interfacesituation.setInterfaceDesc("新增/更新合同履约验收");
            commonUtilsService.insertInterfacesituation(interfacesituation);
        } catch (Exception e) {
            e.printStackTrace();
            //插入接口执行情况
            Interfacesituation interfacesituation = new Interfacesituation();
            interfacesituation.setInterfaceName(Constance.AcceptancesaveOrUpdateAcceptance);
            interfacesituation.setInterfaceUrl("/saveOrUpdateAcceptance.do");
            interfacesituation.setInterfaceState("失败");
            interfacesituation.setInterfaceSituation(e.getMessage());
            interfacesituation.setInterfaceDesc("新增/更新合同履约验收");
            commonUtilsService.insertInterfacesituation(interfacesituation);
            responseInfoVo.returnErrorResult("-1","系统异常:"+e.getMessage());
        }
        return responseInfoVo;
    }
}
