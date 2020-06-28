package com.mk.business.year.controller;

import com.mk.utils.model.ReturnMessage;
import com.mk.business.year.model.Year;
import com.mk.business.year.service.YearService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:年度
 * Created by zhangnengwei on 2020-4-8 15:10
 */
@RestController
@Api(description = "年度")
public class YearController {
    @Autowired
    private YearService yearService;

    @RequestMapping(value = "/saveOrUpdateYear.do",method = RequestMethod.POST,consumes = "application/json;charset=utf-8")
    public ReturnMessage saveOrUpdateYear (@RequestBody Year year) {
        yearService.saveOrUpdateYear(year);
        return new ReturnMessage().ReturnMessageSuccess();
    }
}
