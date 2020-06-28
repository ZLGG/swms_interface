package com.mk.business.projpectresponse.service;

import com.mk.business.projpectresponse.vo.ProjectResponseVO;
import com.mk.utils.model.ReturnMessage;
import com.mk.utils.request.RequestInfoVo;
import com.mk.utils.request.ResponseInfoVo;
import com.sun.org.apache.bcel.internal.generic.RET;

public interface ProjectResponseService {

    /**
     * 保存投标登记及投标供应商明细
     * @param requestInfoVo
     * @return
     */
    ReturnMessage saveOrUpdateProjectResponse(RequestInfoVo requestInfoVo)throws Exception;

    /**
     * 根据项目删除投标登记及明细
     * @param projectGuid
     */
    void delChildProjectResponseAndBidSupplierInfo(String projectGuid);
}
