package com.mk.business.contract.service;

import com.mk.business.contract.param.ContractRequestParam;
import com.mk.utils.model.ReturnMessage;
import com.mk.utils.request.RequestInfoVo;

import java.util.List;

/**
*Description:
*Created by zhangnengwei on 2020-4-7 18:33
*/
public interface ContractService{

    /**
     * @Description:更新/新增采购合同信息
     * @Author: zhangnengwei
     * @Date: 2020-4-7 18:45
     * @return
     */
    ReturnMessage saveOrUpdateContract(RequestInfoVo requestInfoVo)throws Exception;

    Integer getContract(String interfaceCode, String dataResource);

    Integer getContractMoney(String interfaceCode, String dataResource);

}
