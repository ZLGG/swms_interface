package com.mk.business.contract.dao;

import com.mk.business.contract.model.Contractdetail;
import tk.mybatis.mapper.common.Mapper;

/**
*Description:采购合同明细Dao
*Created by zhangnengwei on 2020-4-7 18:34
*/
public interface ContractdetailDao extends Mapper<Contractdetail> {
    void deleteByContractGuid(String contractGuid);
}
