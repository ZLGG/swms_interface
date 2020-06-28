package com.mk.business.fpsupplier.service;

import com.mk.utils.model.ReturnMessage;
import com.mk.utils.request.RequestInfoVo;

public interface FpSuppllierService {

    /**
     * 保存或更新扶贫馆供应商
     * @param requestInfoVo
     * @return
     */
    ReturnMessage saveOrUpdateFpSupplier(RequestInfoVo requestInfoVo) throws Exception;
}
