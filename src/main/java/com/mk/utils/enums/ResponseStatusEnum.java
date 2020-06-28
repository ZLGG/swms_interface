package com.mk.utils.enums;

/**
 * @date: 2020-5-14 19:26
 * @author: Znw · Smile
 * @Description:响应状态码
 */
public enum ResponseStatusEnum {

    SUCCESS(0,"成功"),

    FAILED(1,"失败");

    private Integer key;
    private String value;

    ResponseStatusEnum(Integer key , String value) {
        this.key = key;
        this.value = value;
    }

    public String getValueByKey(int key) {
        ResponseStatusEnum[] values = values();
        for (ResponseStatusEnum responseStatusEnum : values) {
            int enumKey = responseStatusEnum.getKey();
            if (enumKey == key) {
                String value = responseStatusEnum.getValue();
                return value;
            }
        }
        return null;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
