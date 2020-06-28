package com.mk.business.buyitem.param;

import com.mk.business.audithistory.model.Audithistory;
import com.mk.business.bizattachment.model.Bizattachment;
import com.mk.business.buyitem.model.Buyitem;
import com.mk.business.buyitem.model.Buyitemconfirm;
import com.mk.business.buyitem.model.Buyitemmoney;
import java.util.List;

/**
 * Description:采购预算请求参数
 * Created by zhangnengwei on 2020-4-7 11:20
 */
public class BuyitemRequestParam extends Buyitem {

    /**
     * 预算确认
     */
    private List<Buyitemconfirm> buyitemconfirmList;

    /**
     * 采购预算资金明细
     */
    private List<Buyitemmoney> buyitemmoneyList;

    /**
     * 审核历史信息
     */
    private List<Audithistory> audithistoryList;

    /**
     * 附件信息
     */
    private List<Bizattachment> bizattachmentList;

    public List<Buyitemconfirm> getBuyitemconfirmList() {
        return buyitemconfirmList;
    }

    public void setBuyitemconfirmList(List<Buyitemconfirm> buyitemconfirmList) {
        this.buyitemconfirmList = buyitemconfirmList;
    }

    public List<Buyitemmoney> getBuyitemmoneyList() {
        return buyitemmoneyList;
    }

    public void setBuyitemmoneyList(List<Buyitemmoney> buyitemmoneyList) {
        this.buyitemmoneyList = buyitemmoneyList;
    }

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
