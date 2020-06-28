package com.mk.utils.model;


import com.mk.utils.enums.ReturnMessageEnum;

/**
 * @author sunzihan
 * @Title: ReturnMessage
 * @Description: 返回信息类
 * @date 2018/11/21 15:31
 */
public class ReturnMessage {
    /**
     * 返回信息描述
     */
    private String msg;
    /**
     * 状态码
     */
    private String code;
    /**
     * 返回类
     */
    private Object data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ReturnMessage() {
    }

    public ReturnMessage(String code, String msg, Object data) {
        if (msg != null) {
            this.msg = msg;
        }
        if (code != null) {
            this.code = code;
        }
        if (data != null) {
            this.data = data;
        }
    }
    public ReturnMessage(String code, String msg) {
        if (msg != null) {
            this.msg = msg;
        }
        if (code != null) {
            this.code = code;
        }
    }
    /**
     * 返回成功结果
     * code 固定 msg 固定
     * @param
     * @return
     */
    public ReturnMessage ReturnMessageSuccess() {
        return  new ReturnMessage(ReturnMessageEnum.success.getCode(), ReturnMessageEnum.success.getMsg());
    }

    /**
     * 返回成功结果
     * code 固定 msg 传参
     * @param msg
     * @return
     */
    public ReturnMessage ReturnMessageSuccess(String msg) {
        return  new ReturnMessage(ReturnMessageEnum.success.getCode(), msg);
    }
    /**
     * 返回成功结果
     * code 固定 msg 固定 data 传参
     * @param data
     * @return
     */
    public ReturnMessage ReturnMessageSuccess(Object data) {
        return  new ReturnMessage(ReturnMessageEnum.success.getCode(), ReturnMessageEnum.success.getMsg(),data);
    }
    public ReturnMessage ReturnMessageInvalid_Parameters() {
        return  new ReturnMessage(ReturnMessageEnum.invalid_parameters.getCode(), ReturnMessageEnum.invalid_parameters.getMsg(),null);
    }
    public ReturnMessage returnMessageInvalidParameters(String msg) {
        return  new ReturnMessage(ReturnMessageEnum.invalid_parameters.getCode(), msg,null);
    }
    public ReturnMessage ReturnMessageFail() {
        return  new ReturnMessage(ReturnMessageEnum.fail.getCode(), ReturnMessageEnum.fail.getMsg(),null);
    }
}
