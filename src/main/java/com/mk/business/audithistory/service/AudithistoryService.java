package com.mk.business.audithistory.service;

import com.mk.business.audithistory.model.Audithistory;
import com.mk.business.audithistory.param.AudithistoryCheckoutParam;

/**
*@date: 2020-4-27 15:27
*@author: Znw · Smile
*@Description:
*/
public interface AudithistoryService{
    /**
     * 根据业务ID删除审核信息
     * @Param: [bizGuid 业务ID]
     * @return: void
     * @Author: Znw · Smile
     * @CreateDate: 2020-5-7 14:38
     */
    void deleteAuditHistryByBizId(String bizGuid);

    /**
     * 新增一条审核信息
     * @Param: []
     * @return: void
     * @Author: Znw · Smile
     * @CreateDate: 2020-5-7 14:39
     */
    void insertAuditHistory(Audithistory audithistory);

    /**
     * 校验审核历史请求参数
     * @Param: [audithistory]
     * @return: void
     * @Author: Znw · Smile
     * @CreateDate: 2020-5-14 9:49
     */
    void checkAuditHistoryParam(Audithistory audithistory) throws Exception;
}
