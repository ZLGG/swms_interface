package com.mk.business.platform.controller;

import com.mk.business.platform.model.Platform;
import com.mk.business.platform.service.PlatformService;
import com.mk.utils.model.ReturnMessage;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:实施形式
 * Created by zhangnengwei on 2020-4-8 15:52
 */
@RestController
@Api(description = "实施形式")
public class PlatformController {
    @Autowired
    private PlatformService platformService;
    @RequestMapping(value = "/saveOrUpdatePlatform.do",method = RequestMethod.POST,consumes = "application/json;charset=utf-8")
    public ReturnMessage saveOrUpdatePlatform (@RequestBody Platform platform) {
        platformService.saveOrUpdatePlatform(platform);
        return new ReturnMessage().ReturnMessageSuccess();
    }
}
