package com.mk.business.notice.service;

import com.mk.utils.request.RequestInfoVo;
import com.mk.utils.request.ResponseInfoVo;

/**
*@date: 2020-4-28 15:04
*@author: Znw · Smile
*@Description:
*/
public interface NoticeService{

    /**
     * 更新/新增公示信息
     * @Param: [notice]
     * @return: com.mk.utils.request.ResponseInfoVo
     * @Author: Znw · Smile
     * @CreateDate: 2020-5-15 11:42
     */
    ResponseInfoVo saveOrUpdateNotice(RequestInfoVo requestInfoVo) throws Exception;
}
