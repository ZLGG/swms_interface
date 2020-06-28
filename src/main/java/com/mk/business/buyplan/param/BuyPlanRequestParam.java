package com.mk.business.buyplan.param;

import com.mk.business.audithistory.model.Audithistory;
import com.mk.business.bizattachment.model.Bizattachment;
import com.mk.business.buyplan.model.Buyplan;
import com.mk.business.buyplan.model.Buyplandetail;
import com.mk.business.buyplan.model.Buyplanmoney;
import com.mk.business.buyplan.model.Buyplansupplier;
import com.mk.business.notice.model.Notice;

import javax.persistence.Transient;
import java.util.List;

/**
 * Description:计划请求参数
 * Created by zhangnengwei on 2020-4-7 17:33
 */
public class BuyPlanRequestParam extends Buyplan {

    /**
     * 采购计划明细
     */
    List<Buyplandetail> buyplandetailList;

    /**
     * 采购计划资金明细
     */
    List<Buyplanmoney> buyplanmoneyList;

    /**
     * 计划拟定供应商
     */
    List<Buyplansupplier> buyplansupplierList;

    /**
     * 审核历史
     */
    List<Audithistory> audithistoryList;

    /**
     * 附件信息
     */
    List<Bizattachment> bizattachmentList;

    public List<Buyplandetail> getBuyplandetailList() {
        return buyplandetailList;
    }

    public void setBuyplandetailList(List<Buyplandetail> buyplandetailList) {
        this.buyplandetailList = buyplandetailList;
    }

    public List<Buyplanmoney> getBuyplanmoneyList() {
        return buyplanmoneyList;
    }

    public void setBuyplanmoneyList(List<Buyplanmoney> buyplanmoneyList) {
        this.buyplanmoneyList = buyplanmoneyList;
    }

    public List<Buyplansupplier> getBuyplansupplierList() {
        return buyplansupplierList;
    }

    public void setBuyplansupplierList(List<Buyplansupplier> buyplansupplierList) {
        this.buyplansupplierList = buyplansupplierList;
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
