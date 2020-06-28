package com.mk.business.location.service;

import com.mk.business.location.model.Location;

/**
*Description: 行政区划
*Created by zhangnengwei on 2020-4-8 14:03
*/
public interface LocationService{

    /**
     * @Description:保存/更新行政区划
     * @Author: zhangnengwei
     * @Date: 2020-4-8 14:05
     */
    void saveOrUpdateLocation(Location location);

    /**
     * 根据id查询区划
     * @param locationGuid
     * @return
     */
    Integer getLocation(String locationGuid);
}
