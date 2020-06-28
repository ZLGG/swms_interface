package com.mk.business.contract.dao;

import com.mk.business.contract.model.Contract;
import tk.mybatis.mapper.common.Mapper;

import java.util.Map;

/**
*Description:采购合同Dao
*Created by zhangnengwei on 2020-4-7 18:33
*/
public interface ContractDao extends Mapper<Contract> {


    Integer getContract( Map<String,Object> map);

    Integer getContractMoney(Map<String,Object> map);
}
