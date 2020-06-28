package com.mk.business.location.controller;

import com.mk.business.location.model.Location;
import com.mk.business.location.service.LocationService;
import com.mk.utils.model.ReturnMessage;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:行政区划
 * Created by zhangnengwei on 2020-4-8 14:03
 */
@RestController
@Api(description = "行政区划")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @RequestMapping(value = "/saveOrUpdateLocation.do",method = RequestMethod.POST,consumes = "application/json;charset=utf-8")
    public ReturnMessage saveOrUpdateLocation (@RequestBody Location location) {
        locationService.saveOrUpdateLocation(location);
        return new ReturnMessage().ReturnMessageSuccess();
    }
}
