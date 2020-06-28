package com.mk.business.zcyBuyplan.servcie;

import com.mk.utils.model.ReturnMessage;
import com.mk.utils.request.RequestInfoVo;

public interface ZcyBuyplanService {

    /**
     * 保存或更新政采云采购计划
     * @param requestInfoVo
     * @return
     */
    ReturnMessage saveOrUpdateZcyBuyplan(RequestInfoVo requestInfoVo) throws Exception;
}
