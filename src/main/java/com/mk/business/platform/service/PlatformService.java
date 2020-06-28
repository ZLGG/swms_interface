package com.mk.business.platform.service;

import com.mk.business.platform.model.Platform;

/**
*Description: 实施形式Service
*Created by zhangnengwei on 2020-4-8 15:52
*/
public interface PlatformService{

    /**
     * @Description:保存/更新实施形式
     * @Author: zhangnengwei
     * @Date: 2020-4-8 16:24
     */
    void saveOrUpdatePlatform(Platform platform);

    /**
     * 校验实施形式数据完整性
     * @Param: [platformGuid]
     * @return: int
     * @Author: Znw · Smile
     * @CreateDate: 2020-5-15 16:25
     */
    Integer getPlatform(String platformGuid);
}
