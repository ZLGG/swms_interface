package com.mk.business.supplier.controller;

import com.mk.business.supplier.model.Supplier;
import com.mk.business.supplier.service.SupplierService;
import com.mk.utils.model.ReturnMessage;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

/**
 * Description:供应商
 * Created by zhangnengwei on 2020-4-8 17:26
 */
@RestController
@Api(description = "供应商")
public class SupplierController {
    @Autowired
    private SupplierService saveOrUpdateYear;

    @RequestMapping(value = "/saveOrUpdateSupplierInfo.do",method = RequestMethod.POST,consumes = "application/json;charset=utf-8")
    public ReturnMessage saveOrUpdateSupplierInfo (@RequestBody Supplier supplier) {
        try {
            saveOrUpdateYear.saveOrUpdateSupplierInfo(supplier);
            return new ReturnMessage().ReturnMessageSuccess("供应商信息保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            ReturnMessage returnMessage = new ReturnMessage().ReturnMessageFail();
            returnMessage.setMsg(e.getMessage());
            return returnMessage;
        }
    }
}
