package com.mk.utils.enums;

/**
 * @date: 2020-5-15 10:31
 * @author: Znw · Smile
 * @Description:状态码
 */
public enum StatusEnum {
    TRUE(1),
    FALSE(0);

    private Integer value;

    StatusEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
