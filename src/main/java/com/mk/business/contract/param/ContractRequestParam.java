package com.mk.business.contract.param;

import com.mk.business.audithistory.model.Audithistory;
import com.mk.business.bizattachment.model.Bizattachment;
import com.mk.business.contract.model.Contract;
import com.mk.business.contract.model.Contractdetail;
import com.mk.business.contract.model.Contractmoney;
import com.mk.business.contract.model.Contractsupplier;

import java.util.List;

/**
 * Description:
 * Created by zhangnengwei on 2020-4-7 18:41
 */
public class ContractRequestParam extends Contract {

    /**
     * 采购合同明细
     */
    private List<Contractdetail> contractdetailList;

    /**
     * 合同资金明细
     */
    private List<Contractmoney> contractmoneyList;

    /**
     * 合同供应商
     */
    private List<Contractsupplier> contractsupplierList;

    /**
     * 审核历史信息
     */
    private List<Audithistory> audithistoryList;

    /**
     * 附件信息
     */
    private List<Bizattachment> bizattachmentList;

    public List<Contractdetail> getContractdetailList() {
        return contractdetailList;
    }

    public void setContractdetailList(List<Contractdetail> contractdetailList) {
        this.contractdetailList = contractdetailList;
    }

    public List<Contractmoney> getContractmoneyList() {
        return contractmoneyList;
    }

    public void setContractmoneyList(List<Contractmoney> contractmoneyList) {
        this.contractmoneyList = contractmoneyList;
    }

    public List<Contractsupplier> getContractsupplierList() {
        return contractsupplierList;
    }

    public void setContractsupplierList(List<Contractsupplier> contractsupplierList) {
        this.contractsupplierList = contractsupplierList;
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
