package com.mk.business.platformtype.controller;

import com.mk.business.platformtype.model.Platformtype;
import com.mk.business.platformtype.service.PlatformtypeService;
import com.mk.utils.model.ReturnMessage;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:实施形式分类
 * Created by zhangnengwei on 2020-4-8 15:35
 */
@RestController
@Api(description = "实施形式分类")
public class PlatformtypeController {

    @Autowired
    private PlatformtypeService platformtypeService;
    @RequestMapping(value = "/saveOrUpdatePlatformType.do",method = RequestMethod.POST,consumes = "application/json;charset=utf-8")
    public ReturnMessage saveOrUpdatePlatformType (@RequestBody Platformtype platformtype) {
        platformtypeService.saveOrUpdatePlatformType(platformtype);
        return new ReturnMessage().ReturnMessageSuccess();
    }
}
