package com.mk.utils.request;


import org.apache.commons.codec.digest.DigestUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:返回参数vo对象
 * @Date: 2018-8-11 16:06
 */
public class ResponseInfoVo implements Serializable {

    //创建时间
    private Date createDate;
    //请求状态码
    private String status;
    //状态提示信息
    private String message;
    //返回数据
    private String data;
    //消息校验值
    private String mac;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }
    //成功时传入json串
    public void returnSuccessResult(String data,String message){
        this.setCreateDate(new Date(System.currentTimeMillis()));
        this.setStatus("0");
        this.setMessage(message);
        try {
            this.setData(EncryptUtil.encryptStringToBase64(data));
            this.setMac(DigestUtils.sha256Hex(data));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //出现异常时传入异常状态
    public void returnErrorResult(String status,String message){
        this.setCreateDate(new Date(System.currentTimeMillis()));
        this.setStatus(status);
        this.setMessage(message);
    }

}
