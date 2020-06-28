package com.mk.utils.request;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:请求参数vo对象
 * @Date: 2018-8-11 16:06
 */
public class RequestInfoVo implements Serializable {
    //消息认证码
    private String token;
    //消息体
    private String message;
    //创建时间
    private Date createDate;
    //消息校验值
    private String mac;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public void returnResult(String message){
        this.setCreateDate(new Date(System.currentTimeMillis()));
        try {
            this.setMessage(EncryptUtil.encryptStringToBase64(message));
            this.setMac(org.apache.commons.codec.digest.DigestUtils.sha256Hex(message));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //解密并校验签名是否一致
    public String MessageDecryptStringToBase64(){
        try {
            if (this.getMessage()!=null) {
                if(!org.apache.commons.codec.digest.DigestUtils.sha256Hex(EncryptUtil.decryptStringToBase64(this.getMessage())).equals(this.getMac())){
                    throw new RuntimeException("数据签名不一致!");
                }
                return EncryptUtil.decryptStringToBase64(this.getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("接口数据异常!");
        }
        return "{}";
    }
}
