package com.mk.business.platformtype.service;

import com.mk.business.platformtype.model.Platformtype;

/**
*Description: 实施形式分类
*Created by zhangnengwei on 2020-4-8 15:35
*/
public interface PlatformtypeService{


    /**
     * @Description:保存/更新实施形式分类
     * @Author: zhangnengwei
     * @Date: 2020-4-8 15:49
     */
    void saveOrUpdatePlatformType(Platformtype platformtype);

    /**
     * 根据主键校验实施形式分类数据完整性
     * @Param: [platformTypeGuid]
     * @return: java.lang.Integer
     * @Author: Znw · Smile
     * @CreateDate: 2020-5-15 16:29
     */
    Integer getPlatformType(String platformTypeGuid);
}
