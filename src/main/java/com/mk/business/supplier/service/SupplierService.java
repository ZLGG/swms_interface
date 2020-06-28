package com.mk.business.supplier.service;

import com.mk.business.supplier.model.Supplier;

import java.text.ParseException;

/**
 * Description: 供应商
 * Created by zhangnengwei on 2020-4-8 17:26
 */
public interface SupplierService {

    /**
     * @Description:保存/更新供应商
     * @Author: zhangnengwei
     * @Date: 2020-4-8 17:27
     */
    void saveOrUpdateSupplierInfo(Supplier supplier) throws Exception;

    /**
     * 根据id查询供应商
     * @param supplierGuid
     * @return
     */
    Integer getSupplier(String supplierGuid);
}
