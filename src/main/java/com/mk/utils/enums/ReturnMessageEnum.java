package com.mk.utils.enums;

public enum ReturnMessageEnum {
    success("200", "成功"),
    invalid_parameters("400","参数异常"),
    fail("500", "系统内部错误,请联系管理员");
    private String code;
    private String msg;

    private ReturnMessageEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
