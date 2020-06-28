package com.mk.business.acceptance.param;

import com.mk.business.acceptance.model.Acceptance;
import com.mk.business.audithistory.model.Audithistory;
import com.mk.business.bizattachment.model.Bizattachment;

import java.util.List;

/**
 * Description:合同履约验收请求参数
 * Created by zhangnengwei on 2020-4-7 19:17
 */
public class AcceptanceRequestParam extends Acceptance {
    /**
     * 审核历史信息
     */
    private List<Audithistory> audithistoryList;

    /**
     * 附件信息
     */
    private List<Bizattachment> bizattachmentList;

    public List<Audithistory> getAudithistoryList() {
        return audithistoryList;
    }

    public void setAudithistoryList(List<Audithistory> audithistoryList) {
        this.audithistoryList = audithistoryList;
    }

    public List<Bizattachment> getBizattachmentList() {
        return bizattachmentList;
    }

    public void setBizattachmentList(List<Bizattachment> bizattachmentList) {
        this.bizattachmentList = bizattachmentList;
    }
}
