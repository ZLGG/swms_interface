package com.mk.business.pay.param;

import com.mk.business.audithistory.model.Audithistory;
import com.mk.business.bizattachment.model.Bizattachment;
import com.mk.business.pay.model.Pay;
import com.mk.business.pay.model.Paymoney;

import java.util.List;

/**
 * Description:
 * Created by zhangnengwei on 2020-4-7 19:02
 */
public class PayRequestParam extends Pay {

    /**
     * 资金支付资金
     */
    private List<Paymoney> paymoneyList;

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

    public List<Paymoney> getPaymoneyList() {
        return paymoneyList;
    }

    public void setPaymoneyList(List<Paymoney> paymoneyList) {
        this.paymoneyList = paymoneyList;
    }
}
