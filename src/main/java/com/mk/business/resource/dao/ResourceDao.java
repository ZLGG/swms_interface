package com.mk.business.resource.dao;

import com.mk.business.resource.model.Resource;
import tk.mybatis.mapper.common.Mapper;

/**
*Description:
*Created by zhangnengwei on 2020-4-8 16:30
*/
public interface ResourceDao extends Mapper<Resource> {
    int getResource(String resourceGuid);
}
