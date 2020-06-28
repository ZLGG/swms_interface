package com.mk.business.optiontype.controller;

import com.mk.business.optiontype.model.Optiontype;
import com.mk.business.optiontype.service.OptiontypeService;
import com.mk.utils.model.ReturnMessage;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:选项类别
 * Created by zhangnengwei on 2020-4-8 15:27
 */
@RestController
@Api(description = "选项类别")
public class OptiontypeController {
    @Autowired
    private OptiontypeService optiontypeService;

    @RequestMapping(value = "/saveOrUpdateOptionType.do",method = RequestMethod.POST,consumes = "application/json;charset=utf-8")
    public ReturnMessage saveOrUpdateOptionType (@RequestBody Optiontype optiontype) {
        optiontypeService.saveOrUpdateOptionType(optiontype);
        return new ReturnMessage().ReturnMessageSuccess();
    }
}
