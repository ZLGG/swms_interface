package com.mk.business.optionlist.controller;

import com.mk.business.optionlist.model.Optionlist;
import com.mk.business.optionlist.service.OptionlistService;
import com.mk.utils.model.ReturnMessage;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:选项列表
 * Created by zhangnengwei on 2020-4-8 15:31
 */
@RestController
@Api(description = "选项列表")
public class OptionlistController {
    @Autowired
    private OptionlistService optionlistService;

    @RequestMapping(value = "/saveOrUpdateOptionList.do",method = RequestMethod.POST,consumes = "application/json;charset=utf-8")
    public ReturnMessage saveOrUpdateOptionList (@RequestBody Optionlist optionlist) {
        optionlistService.saveOrUpdateOptionList(optionlist);
        return new ReturnMessage().ReturnMessageSuccess();
    }
}
