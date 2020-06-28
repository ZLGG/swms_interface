package com.mk.business.acceptance.service;

import com.mk.business.acceptance.param.AcceptanceRequestParam;
import com.mk.utils.request.RequestInfoVo;
import com.mk.utils.request.ResponseInfoVo;

import java.util.List;

/**
*Description: 合同履约验收Service
*Created by zhangnengwei on 2020-4-7 19:16
*/
public interface AcceptanceService{

    /**
     * @Description:新增/修改合同履约验收
     * @Author: zhangnengwei
     * @Date: 2020-4-7 19:19
     */
    ResponseInfoVo saveOrUpdateAcceptance(RequestInfoVo requestInfoVo)throws Exception;
}
