package com.mk.business.post.service;

/**
 * @date: 2020-5-15 16:56
 * @author: Znw · Smile
 * @Description:
 */
public interface PostService {

    /**
     * 根据主键校验数据完整性
     * @Param: [postGuid]
     * @return: java.lang.Integer
     * @Author: Znw · Smile
     * @CreateDate: 2020-5-15 17:00
     */
    Integer getPost(String postGuid);
}
