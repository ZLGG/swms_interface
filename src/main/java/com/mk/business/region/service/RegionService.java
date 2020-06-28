package com.mk.business.region.service;

import com.mk.business.region.model.Region;

/**
*Description: 新增/更新区域信息
*Created by zhangnengwei on 2020-4-8 14:23
*/
public interface RegionService{

    /**
     * @Description:新增/更新区域信息
     * @Author: zhangnengwei
     * @Date: 2020-4-8 14:26
     */
    void saveOrUpdateRegion(Region region);


    /**
     * 根据id查询
     * @param regionGuid
     * @return
     */
    Integer getRegion(String regionGuid);
}
