package com.mk.business.user.service;

/**
 * @date: 2020-5-15 16:56
 * @author: Znw · Smile
 * @Description:
 */
public interface UserService {

    /**
     * 根据主键校验数据完整性
     * @Param: [excuteUserGuid]
     * @return: java.lang.Integer
     * @Author: Znw · Smile
     * @CreateDate: 2020-5-15 17:03
     */
    Integer getUser(String excuteUserGuid);
}
