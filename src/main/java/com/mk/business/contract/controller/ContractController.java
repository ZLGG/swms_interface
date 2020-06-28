package com.mk.business.contract.controller;

import com.alibaba.fastjson.JSON;
import com.mk.business.Constance.Constance;
import com.mk.business.commonutils.model.Interfacesituation;
import com.mk.business.commonutils.service.CommonUtilsService;
import com.mk.business.contract.param.ContractRequestParam;
import com.mk.business.contract.service.ContractService;
import com.mk.utils.model.ReturnMessage;
import com.mk.utils.request.RequestInfoVo;
import com.mk.utils.request.ResponseInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description:采购合同Controller
 * Created by zhangnengwei on 2020-4-7 18:40
 */
@RestController
@Api(description = "采购合同")
public class ContractController {
    @Autowired
    private ContractService contractService;

    @Autowired
    private CommonUtilsService commonUtilsService;

    @ApiOperation(value = "新/删除采购合同信息", notes = "新/删除采购合同信息")
    @RequestMapping(value = "/saveOrUpdateContract.do", method = RequestMethod.POST, consumes = "application/json;charset=utf-8")
    public ResponseInfoVo saveOrUpdateContract(@RequestBody RequestInfoVo requestInfoVo) throws Exception {
        ResponseInfoVo responseInfoVo = new ResponseInfoVo();
        try {
            ReturnMessage returnMessage = contractService.saveOrUpdateContract(requestInfoVo);
            //插入接口执行情况
            Interfacesituation interfacesituation =new Interfacesituation();
            interfacesituation.setInterfaceName(Constance.ContractsaveOrUpdateContract);
            interfacesituation.setInterfaceUrl("/saveOrUpdateContract.do");
            interfacesituation.setInterfaceState("成功");
            interfacesituation.setInterfaceSituation("成功");
            interfacesituation.setInterfaceDesc("新增/更新采购合同信息信息");
            commonUtilsService.insertInterfacesituation(interfacesituation);
            responseInfoVo.returnSuccessResult(JSON.toJSONString(returnMessage), "新增/更新采购合同信息信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            //插入接口执行情况
            Interfacesituation interfacesituation =new Interfacesituation();
            interfacesituation.setInterfaceName(Constance.ContractsaveOrUpdateContract);
            interfacesituation.setInterfaceUrl("/saveOrUpdateContract.do");
            interfacesituation.setInterfaceState("失败");
            interfacesituation.setInterfaceSituation(e.getMessage());
            interfacesituation.setInterfaceDesc("新增/更新采购合同信息信息");
            commonUtilsService.insertInterfacesituation(interfacesituation);
            responseInfoVo.returnErrorResult("-2","新增/更新采购合同信息信息失败"+e.toString());
        }
        return responseInfoVo;
    }
}
