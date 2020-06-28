package com.mk.business.resource.service;

import com.mk.business.resource.model.Resource;

/**
*Description: 采购预算资金来源
*Created by zhangnengwei on 2020-4-8 16:30
*/
public interface ResourceService{

    /**
     * @Description:保存/更新采购预算资金来源
     * @Author: zhangnengwei
     * @Date: 2020-4-8 17:11
     */
        void saveOrUpdateResource(Resource resource);

        int getResource(String resourceGuid);
}
