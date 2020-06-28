package com.mk.business.resource.controller;

import com.mk.business.resource.model.Resource;
import com.mk.business.resource.service.ResourceService;
import com.mk.utils.model.ReturnMessage;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:采购预算资金来源
 * Created by zhangnengwei on 2020-4-8 16:30
 */
@RestController
@Api(description = "采购预算资金来源")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @RequestMapping(value = "/saveOrUpdateResource.do",method = RequestMethod.POST,consumes = "application/json;charset=utf-8")
    public ReturnMessage saveOrUpdateResource (@RequestBody Resource resource) {
        resourceService.saveOrUpdateResource(resource);
        return new ReturnMessage().ReturnMessageSuccess();
    }
}
