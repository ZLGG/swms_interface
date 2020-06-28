package com.mk.business.region.controller;

import com.mk.business.region.model.Region;
import com.mk.business.region.service.RegionService;
import com.mk.utils.model.ReturnMessage;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:区域
 * Created by zhangnengwei on 2020-4-8 14:24
 */
@RestController
@Api(description = "区域")
public class RegionClass {
    @Autowired
    private RegionService regionService;

    @RequestMapping(value = "/saveOrUpdateRegion.do",method = RequestMethod.POST,consumes = "application/json;charset=utf-8")
    public ReturnMessage saveOrUpdateRegion (@RequestBody Region region) {
        regionService.saveOrUpdateRegion(region);
        return new ReturnMessage().ReturnMessageSuccess();
    }
}
