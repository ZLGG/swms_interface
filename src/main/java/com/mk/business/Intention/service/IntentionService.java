package com.mk.business.Intention.service;

import com.mk.utils.model.ReturnMessage;
import com.mk.utils.request.RequestInfoVo;

public interface IntentionService {

    /**
     * 保存或更新 意向公开信息
     * @param requestInfoVo
     * @return
     */
    ReturnMessage saveOrUpdateIntention(RequestInfoVo requestInfoVo) throws Exception;
}
