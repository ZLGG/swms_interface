package com.mk.business.trustinfo.service;

import com.mk.utils.model.ReturnMessage;
import com.mk.utils.request.RequestInfoVo;

public interface TrustinfoService {

    /**
     * 保存或更新采购委托
     * @param requestInfoVo
     * @return
     */
    ReturnMessage saveOrUpdateTrustinfo(RequestInfoVo requestInfoVo) throws Exception;
}
