package com.mk.business.budget.controller;

import com.mk.business.Constance.Constance;
import com.mk.business.budget.service.BudgetService;
import com.mk.business.commonutils.model.Interfacesituation;
import com.mk.business.commonutils.service.CommonUtilsService;
import com.mk.utils.enums.ResponseStatusEnum;
import com.mk.utils.request.RequestInfoVo;
import com.mk.utils.request.ResponseInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:支出预算Controller
 * Created by zhangnengwei on 2020-4-7 15:00
 */
@RestController
@Api(value = "Budget", description = "支出预算")
public class BudgetController {
    @Autowired
    private BudgetService budgetService;

    @Autowired
    private CommonUtilsService commonUtilsService;

    @RequestMapping(value = "/saveOrUpdateBudget.do", method = RequestMethod.POST, consumes = "application/json;charset=utf-8")
    @ApiOperation(value = "新增/更新支出预算信息", notes = "新增/更新支出预算信息")
    public ResponseInfoVo saveOrUpdateBudget(@RequestBody RequestInfoVo requestInfoVo){
        ResponseInfoVo responseInfoVo = new ResponseInfoVo();
        try {
            responseInfoVo = budgetService.saveOrUpdateBudget(requestInfoVo);
            //插入接口执行情况
            Interfacesituation interfacesituation = new Interfacesituation();
            interfacesituation.setInterfaceName(Constance.BudgetsaveOrUpdateBudget);
            interfacesituation.setInterfaceUrl("/saveOrUpdateBudget.do");
            interfacesituation.setInterfaceState(ResponseStatusEnum.SUCCESS.getValue());
            interfacesituation.setInterfaceSituation(ResponseStatusEnum.SUCCESS.getValue());
            interfacesituation.setInterfaceDesc("新增/更新支出预算信息");
            commonUtilsService.insertInterfacesituation(interfacesituation);
        } catch (Exception e) {
            e.printStackTrace();
            //插入接口执行情况
            Interfacesituation interfacesituation = new Interfacesituation();
            interfacesituation.setInterfaceName(Constance.BudgetsaveOrUpdateBudget);
            interfacesituation.setInterfaceUrl("/saveOrUpdateBudget.do");
            interfacesituation.setInterfaceState(ResponseStatusEnum.FAILED.getValue());
            interfacesituation.setInterfaceSituation(e.getMessage());
            interfacesituation.setInterfaceDesc("新增/更新支出预算信息");
            commonUtilsService.insertInterfacesituation(interfacesituation);
            responseInfoVo.returnErrorResult("-1", "系统异常:" + e.getMessage());
        }
        return responseInfoVo;
    }
}
