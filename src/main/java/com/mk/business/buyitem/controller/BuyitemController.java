package com.mk.business.buyitem.controller;

import com.mk.business.Constance.Constance;
import com.mk.business.buyitem.service.BuyitemService;
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

import java.util.List;

/**
 * Description:采购预算controller
 * Created by zhangnengwei on 2020-4-7 11:03
 */
@RestController
@Api(description = "采购预算")
public class BuyitemController {
    @Autowired
    private BuyitemService buyitemService;
    @Autowired
    private CommonUtilsService commonUtilsService;

    @ApiOperation(value = "新增/更新采购预算信息", notes = "新增/更新采购预算信息")
    @RequestMapping(value = "/saveOrUpdateBuyitem.do", method = RequestMethod.POST, consumes = "application/json;charset=utf-8")
    public ResponseInfoVo saveOrUpdateBudget(@RequestBody RequestInfoVo requestInfoVo) {
        ResponseInfoVo responseInfoVo = new ResponseInfoVo();
        try {
            responseInfoVo = buyitemService.saveOrUpdateBuyitem(requestInfoVo);
            // 插入接口执行情况
            Interfacesituation interfacesituation = new Interfacesituation();
            interfacesituation.setInterfaceName(Constance.BuyitemsaveOrUpdateBuyitem);
            interfacesituation.setInterfaceUrl("/saveOrUpdateBuyitem.do");
            interfacesituation.setInterfaceState(ResponseStatusEnum.SUCCESS.getValue());
            interfacesituation.setInterfaceSituation(ResponseStatusEnum.SUCCESS.getValue());
            interfacesituation.setInterfaceDesc("新增/更新采购预算信息");
            commonUtilsService.insertInterfacesituation(interfacesituation);
            return responseInfoVo;
        } catch (Exception e) {
            e.printStackTrace();
            // 插入接口执行情况
            Interfacesituation interfacesituation = new Interfacesituation();
            interfacesituation.setInterfaceName(Constance.BuyitemsaveOrUpdateBuyitem);
            interfacesituation.setInterfaceUrl("/saveOrUpdateBuyitem.do");
            interfacesituation.setInterfaceState(ResponseStatusEnum.FAILED.getValue());
            interfacesituation.setInterfaceSituation(e.getMessage());
            interfacesituation.setInterfaceDesc("新增/更新采购预算信息");
            commonUtilsService.insertInterfacesituation(interfacesituation);
            responseInfoVo.returnErrorResult("-1", "系统异常:" + e.getMessage());
        }
        return responseInfoVo;
    }
}
