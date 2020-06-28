package com.mk.business.financedept.controller;

import com.mk.business.financedept.model.Financedept;
import com.mk.business.financedept.service.FinancedeptService;
import com.mk.utils.model.ReturnMessage;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:财政业务部门
 * Created by zhangnengwei on 2020-4-8 15:16
 */
@RestController
@Api(description = "财政业务部门")
public class FinancedeptController {
    @Autowired
    private FinancedeptService financedeptService;

    @RequestMapping(value = "/saveOrUpdateFinanceDept.do",method = RequestMethod.POST,consumes = "application/json;charset=utf-8")
    public ReturnMessage saveOrUpdateFinanceDept (@RequestBody Financedept financedept) {
        financedeptService.saveOrUpdateFinanceDept(financedept);
        return new ReturnMessage().ReturnMessageSuccess();
    }
}
