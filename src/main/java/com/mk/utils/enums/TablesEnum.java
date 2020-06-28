package com.mk.utils.enums;

/**
 * Description:
 * Created by zhangnengwei on 2020-4-15 15:44
 */
public enum TablesEnum {
    BUYITEMCONFIRM("t_a_buyitemconfirm", "预算确认子表"),
    BUYITEM("t_a_buyitem", "采购预算主表"),
    BUYITEMMONEY("t_a_buyitemmoney","采购预算资金明细子表"),
    BUDGET("t_a_budget","支出预算主表"),
    BUDGETMONEY("t_a_budgetmoney","支出预算资金明细子表"),
    BUYPLANSUPPLIER("t_a_buyplansupplier","单一来源计划拟定供应商"),
    BUYPLANDETAIL("t_a_buyplandetail","采购计划明细"),
    CONTRACTDETAIL("t_a_contractdetail","采购合同明细"),
    CONTRACTSUPPLIER("t_a_contractsupplier","合同供应商"),
    BUYPLANMONEY("t_a_buyplanmoney","采购计划资金明细"),
    BUYPLAN("t_a_buyplan","采购计划"),
    CONTRACT("t_a_contract","采购合同"),
    ACCEPTANCE("t_a_acceptance","合同履约验收"),
    CONTRACTMONEY("t_a_contractmoney","合同资金明细"),
    PAY("t_a_pay","资金支付"),
    PAYMONEY("t_a_paymoney","资金支付资金"),
    EXPERT("t_d_expert","采购专家库"),
    AGENT("t_d_agent","采购机构"),
    SUPPLIER("t_d_supplier","供应商"),
    PROJECT("t_a_project", "采购项目"),
    BIDITEM("T_A_BidItem","项目标项"),
    PROJECTRESPONSE("T_A_ProjectResponse","投标登记"),
    COMMENTINDEX("T_A_CommentIndex","评审指标"),
    REGION("T_D_Region","区域")
    ;

    private String key;

    private String value;

    TablesEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
