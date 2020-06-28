package com.mk.business.contract.dao;

import com.mk.business.contract.model.Contractsupplier;
import tk.mybatis.mapper.common.Mapper;

/**
*Description:合同供应商Dao
*Created by zhangnengwei on 2020-4-7 18:35
*/
public interface ContractsupplierDao extends Mapper<Contractsupplier> {
    void deleteByContractGuid(String contractGuid);
}
