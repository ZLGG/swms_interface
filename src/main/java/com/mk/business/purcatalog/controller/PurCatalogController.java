package com.mk.business.purcatalog.controller;

import com.mk.business.purcatalog.model.Purcatalog;
import com.mk.business.purcatalog.service.PurcatalogService;
import com.mk.utils.model.ReturnMessage;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:采购目录
 * Created by zhangnengwei on 2020-4-8 15:03
 */
@RestController
@Api(description = "区域")
public class PurCatalogController {
    @Autowired
    private PurcatalogService purcatalogService;

    @RequestMapping(value = "/saveOrUpdatePurCatalog.do",method = RequestMethod.POST,consumes = "application/json;charset=utf-8")
    public ReturnMessage saveOrUpdatePurCatalog (@RequestBody Purcatalog purcatalog) {
        purcatalogService.saveOrUpdatePurCatalog(purcatalog);
        return new ReturnMessage().ReturnMessageSuccess();
    }
}
