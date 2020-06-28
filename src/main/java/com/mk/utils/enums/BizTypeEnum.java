package com.mk.utils.enums;

/**
 * @date: 2020-4-28 15:39
 * @author: Znw · Smile
 * @Description:采购公告业务类型枚举
 */
public enum BizTypeEnum {
    BUDGET("1","支出预算"),
    BUYITEM("2","采购预算"),
    BUYPLAN("3","计划"),
    PROJECT("4","项目"),
    CONTRACT("5","合同"),
    PAY("6","支付"),
    ACCEPTANCE("7","验收")
    ;

    private String key;
    private String value;

    BizTypeEnum(String key, String value){
        this.key = key;
        this.value = value;
    }

    public String getValueByKey(String key) {
        BizTypeEnum[] values = values();
        for (BizTypeEnum value : values) {
            if (value.getKey().equals(key)){
                String resultValue = value.getValue();
                return resultValue;
            }
        }
        return null;
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
