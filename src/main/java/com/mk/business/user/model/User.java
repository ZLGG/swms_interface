package com.mk.business.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

/**
*@date: 2020-5-15 16:56
*@author: Znw · Smile
*@Description: 
*/
@ApiModel(value="com-mk-business-user-model-User")
@Table(name = "t_user")
public class User implements Serializable {
    @Id
    @Column(name = "User_Guid")
    @ApiModelProperty(value="")
    private String userGuid;

    /**
     * 用户名称
     */
    @Column(name = "User_Name")
    @ApiModelProperty(value="用户名称")
    private String userName;

    /**
     * 系统管理员(1:管理员,0:普通用户)
     */
    @Column(name = "`Admin`")
    @ApiModelProperty(value="系统管理员(1:管理员,0:普通用户)")
    private Integer admin;

    /**
     * 所属区域ID(专家/供应商/代理机构/金融机构此字段为空)
     */
    @Column(name = "Region_Guid")
    @ApiModelProperty(value="所属区域ID(专家/供应商/代理机构/金融机构此字段为空)")
    private String regionGuid;

    /**
     * 用户类型(0:系统管理员,1:采购单位,2:供应商,3:代理机构,4:采购监管机构,5:财政业务部门,6:评审专家,7:金融机构用户)
     */
    @Column(name = "User_Type")
    @ApiModelProperty(value="用户类型(0:系统管理员,1:采购单位,2:供应商,3:代理机构,4:采购监管机构,5:财政业务部门,6:评审专家,7:金融机构用户)")
    private String userType;

    /**
     * 登录名
     */
    @Column(name = "Login_Name")
    @ApiModelProperty(value="登录名")
    private String loginName;

    /**
     * 登录方式(0:密码,1:CA登录)
     */
    @Column(name = "Login_Type")
    @ApiModelProperty(value="登录方式(0:密码,1:CA登录)")
    private String loginType;

    /**
     * CA证书的硬件序列号
     */
    @Column(name = "CA_Key")
    @ApiModelProperty(value="CA证书的硬件序列号")
    private String caKey;

    /**
     * 登录后是否需要强制修改密码(1:需要强制修改)
     */
    @Column(name = "Change_Password")
    @ApiModelProperty(value="登录后是否需要强制修改密码(1:需要强制修改)")
    private Integer changePassword;

    /**
     * 密码错误重试的次数限制(默认5次,超过次数帐号锁定,NULL:不限制)
     */
    @Column(name = "Retry_Number")
    @ApiModelProperty(value="密码错误重试的次数限制(默认5次,超过次数帐号锁定,NULL:不限制)")
    private Integer retryNumber;

    /**
     * QQCode
     */
    @Column(name = "QQ_Code")
    @ApiModelProperty(value="QQCode")
    private String qqCode;

    /**
     * 微信号码
     */
    @Column(name = "Micro_Msg_Code")
    @ApiModelProperty(value="微信号码")
    private String microMsgCode;

    /**
     * 办公电话
     */
    @Column(name = "Telphone")
    @ApiModelProperty(value="办公电话")
    private String telphone;

    /**
     * 移动电话
     */
    @Column(name = "Mobile")
    @ApiModelProperty(value="移动电话")
    private String mobile;

    /**
     * 邮件地址
     */
    @Column(name = "Email")
    @ApiModelProperty(value="邮件地址")
    private String email;

    @Column(name = "`PASSWORD`")
    @ApiModelProperty(value="")
    private String password;

    @Column(name = "Regulators_Guid")
    @ApiModelProperty(value="")
    private String regulatorsGuid;

    @Column(name = "Org_Guid")
    @ApiModelProperty(value="")
    private String orgGuid;

    @Column(name = "Finance_Dept_Guid")
    @ApiModelProperty(value="")
    private String financeDeptGuid;

    @Column(name = "Agent_Guid")
    @ApiModelProperty(value="")
    private String agentGuid;

    @Column(name = "Supplier_Guid")
    @ApiModelProperty(value="")
    private String supplierGuid;

    @Column(name = "Expert_Guid")
    @ApiModelProperty(value="")
    private String expertGuid;

    @Column(name = "Bank_Guid")
    @ApiModelProperty(value="")
    private String bankGuid;

    /**
     * 排序号
     */
    @Column(name = "Dorder")
    @ApiModelProperty(value="排序号")
    private BigDecimal dorder;

    /**
     * 有效标志(1:有效,0:无效,-1:锁定)
     */
    @Column(name = "`Valid`")
    @ApiModelProperty(value="有效标志(1:有效,0:无效,-1:锁定)")
    private String valid;

    @Column(name = "Modi_User")
    @ApiModelProperty(value="")
    private String modiUser;

    @Column(name = "Modi_Date")
    @ApiModelProperty(value="")
    private Date modiDate;

    /**
     * 备注
     */
    @Column(name = "Remark")
    @ApiModelProperty(value="备注")
    private String remark;

    @Column(name = "ID_CARD")
    @ApiModelProperty(value="")
    private String idCard;

    private static final long serialVersionUID = 1L;

    /**
     * @return User_Guid
     */
    public String getUserGuid() {
        return userGuid;
    }

    /**
     * @param userGuid
     */
    public void setUserGuid(String userGuid) {
        this.userGuid = userGuid;
    }

    /**
     * 获取用户名称
     *
     * @return User_Name - 用户名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名称
     *
     * @param userName 用户名称
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取系统管理员(1:管理员,0:普通用户)
     *
     * @return Admin - 系统管理员(1:管理员,0:普通用户)
     */
    public Integer getAdmin() {
        return admin;
    }

    /**
     * 设置系统管理员(1:管理员,0:普通用户)
     *
     * @param admin 系统管理员(1:管理员,0:普通用户)
     */
    public void setAdmin(Integer admin) {
        this.admin = admin;
    }

    /**
     * 获取所属区域ID(专家/供应商/代理机构/金融机构此字段为空)
     *
     * @return Region_Guid - 所属区域ID(专家/供应商/代理机构/金融机构此字段为空)
     */
    public String getRegionGuid() {
        return regionGuid;
    }

    /**
     * 设置所属区域ID(专家/供应商/代理机构/金融机构此字段为空)
     *
     * @param regionGuid 所属区域ID(专家/供应商/代理机构/金融机构此字段为空)
     */
    public void setRegionGuid(String regionGuid) {
        this.regionGuid = regionGuid;
    }

    /**
     * 获取用户类型(0:系统管理员,1:采购单位,2:供应商,3:代理机构,4:采购监管机构,5:财政业务部门,6:评审专家,7:金融机构用户)
     *
     * @return User_Type - 用户类型(0:系统管理员,1:采购单位,2:供应商,3:代理机构,4:采购监管机构,5:财政业务部门,6:评审专家,7:金融机构用户)
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 设置用户类型(0:系统管理员,1:采购单位,2:供应商,3:代理机构,4:采购监管机构,5:财政业务部门,6:评审专家,7:金融机构用户)
     *
     * @param userType 用户类型(0:系统管理员,1:采购单位,2:供应商,3:代理机构,4:采购监管机构,5:财政业务部门,6:评审专家,7:金融机构用户)
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * 获取登录名
     *
     * @return Login_Name - 登录名
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 设置登录名
     *
     * @param loginName 登录名
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * 获取登录方式(0:密码,1:CA登录)
     *
     * @return Login_Type - 登录方式(0:密码,1:CA登录)
     */
    public String getLoginType() {
        return loginType;
    }

    /**
     * 设置登录方式(0:密码,1:CA登录)
     *
     * @param loginType 登录方式(0:密码,1:CA登录)
     */
    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    /**
     * 获取CA证书的硬件序列号
     *
     * @return CA_Key - CA证书的硬件序列号
     */
    public String getCaKey() {
        return caKey;
    }

    /**
     * 设置CA证书的硬件序列号
     *
     * @param caKey CA证书的硬件序列号
     */
    public void setCaKey(String caKey) {
        this.caKey = caKey;
    }

    /**
     * 获取登录后是否需要强制修改密码(1:需要强制修改)
     *
     * @return Change_Password - 登录后是否需要强制修改密码(1:需要强制修改)
     */
    public Integer getChangePassword() {
        return changePassword;
    }

    /**
     * 设置登录后是否需要强制修改密码(1:需要强制修改)
     *
     * @param changePassword 登录后是否需要强制修改密码(1:需要强制修改)
     */
    public void setChangePassword(Integer changePassword) {
        this.changePassword = changePassword;
    }

    /**
     * 获取密码错误重试的次数限制(默认5次,超过次数帐号锁定,NULL:不限制)
     *
     * @return Retry_Number - 密码错误重试的次数限制(默认5次,超过次数帐号锁定,NULL:不限制)
     */
    public Integer getRetryNumber() {
        return retryNumber;
    }

    /**
     * 设置密码错误重试的次数限制(默认5次,超过次数帐号锁定,NULL:不限制)
     *
     * @param retryNumber 密码错误重试的次数限制(默认5次,超过次数帐号锁定,NULL:不限制)
     */
    public void setRetryNumber(Integer retryNumber) {
        this.retryNumber = retryNumber;
    }

    /**
     * 获取QQCode
     *
     * @return QQ_Code - QQCode
     */
    public String getQqCode() {
        return qqCode;
    }

    /**
     * 设置QQCode
     *
     * @param qqCode QQCode
     */
    public void setQqCode(String qqCode) {
        this.qqCode = qqCode;
    }

    /**
     * 获取微信号码
     *
     * @return Micro_Msg_Code - 微信号码
     */
    public String getMicroMsgCode() {
        return microMsgCode;
    }

    /**
     * 设置微信号码
     *
     * @param microMsgCode 微信号码
     */
    public void setMicroMsgCode(String microMsgCode) {
        this.microMsgCode = microMsgCode;
    }

    /**
     * 获取办公电话
     *
     * @return Telphone - 办公电话
     */
    public String getTelphone() {
        return telphone;
    }

    /**
     * 设置办公电话
     *
     * @param telphone 办公电话
     */
    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    /**
     * 获取移动电话
     *
     * @return Mobile - 移动电话
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置移动电话
     *
     * @param mobile 移动电话
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取邮件地址
     *
     * @return Email - 邮件地址
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮件地址
     *
     * @param email 邮件地址
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return PASSWORD
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return Regulators_Guid
     */
    public String getRegulatorsGuid() {
        return regulatorsGuid;
    }

    /**
     * @param regulatorsGuid
     */
    public void setRegulatorsGuid(String regulatorsGuid) {
        this.regulatorsGuid = regulatorsGuid;
    }

    /**
     * @return Org_Guid
     */
    public String getOrgGuid() {
        return orgGuid;
    }

    /**
     * @param orgGuid
     */
    public void setOrgGuid(String orgGuid) {
        this.orgGuid = orgGuid;
    }

    /**
     * @return Finance_Dept_Guid
     */
    public String getFinanceDeptGuid() {
        return financeDeptGuid;
    }

    /**
     * @param financeDeptGuid
     */
    public void setFinanceDeptGuid(String financeDeptGuid) {
        this.financeDeptGuid = financeDeptGuid;
    }

    /**
     * @return Agent_Guid
     */
    public String getAgentGuid() {
        return agentGuid;
    }

    /**
     * @param agentGuid
     */
    public void setAgentGuid(String agentGuid) {
        this.agentGuid = agentGuid;
    }

    /**
     * @return Supplier_Guid
     */
    public String getSupplierGuid() {
        return supplierGuid;
    }

    /**
     * @param supplierGuid
     */
    public void setSupplierGuid(String supplierGuid) {
        this.supplierGuid = supplierGuid;
    }

    /**
     * @return Expert_Guid
     */
    public String getExpertGuid() {
        return expertGuid;
    }

    /**
     * @param expertGuid
     */
    public void setExpertGuid(String expertGuid) {
        this.expertGuid = expertGuid;
    }

    /**
     * @return Bank_Guid
     */
    public String getBankGuid() {
        return bankGuid;
    }

    /**
     * @param bankGuid
     */
    public void setBankGuid(String bankGuid) {
        this.bankGuid = bankGuid;
    }

    /**
     * 获取排序号
     *
     * @return Dorder - 排序号
     */
    public BigDecimal getDorder() {
        return dorder;
    }

    /**
     * 设置排序号
     *
     * @param dorder 排序号
     */
    public void setDorder(BigDecimal dorder) {
        this.dorder = dorder;
    }

    /**
     * 获取有效标志(1:有效,0:无效,-1:锁定)
     *
     * @return Valid - 有效标志(1:有效,0:无效,-1:锁定)
     */
    public String getValid() {
        return valid;
    }

    /**
     * 设置有效标志(1:有效,0:无效,-1:锁定)
     *
     * @param valid 有效标志(1:有效,0:无效,-1:锁定)
     */
    public void setValid(String valid) {
        this.valid = valid;
    }

    /**
     * @return Modi_User
     */
    public String getModiUser() {
        return modiUser;
    }

    /**
     * @param modiUser
     */
    public void setModiUser(String modiUser) {
        this.modiUser = modiUser;
    }

    /**
     * @return Modi_Date
     */
    public Date getModiDate() {
        return modiDate;
    }

    /**
     * @param modiDate
     */
    public void setModiDate(Date modiDate) {
        this.modiDate = modiDate;
    }

    /**
     * 获取备注
     *
     * @return Remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return ID_CARD
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * @param idCard
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}