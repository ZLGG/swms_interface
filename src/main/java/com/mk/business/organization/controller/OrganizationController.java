package com.mk.business.organization.controller;

import com.mk.business.organization.model.Organization;
import com.mk.business.organization.service.OrganizationService;
import com.mk.utils.model.ReturnMessage;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:采购单位
 * Created by zhangnengwei on 2020-4-8 15:22
 */
@RestController
@Api(description = "采购单位")
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    @RequestMapping(value = "/saveOrUpdateOrganization.do",method = RequestMethod.POST,consumes = "application/json;charset=utf-8")
    public ReturnMessage saveOrUpdateOrganization (@RequestBody Organization organization) {
        organizationService.saveOrUpdateOrganization(organization);
        return new ReturnMessage().ReturnMessageSuccess();
    }
}
