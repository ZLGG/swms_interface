package com.mk.business.location.dao;

import com.mk.business.location.model.Location;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
*Description:
*Created by zhangnengwei on 2020-4-8 14:03
*/
public interface LocationDao extends Mapper<Location> {

    @Select("select count(1) from t_d_location where Location_Guid = #{locationGuid}")
    public Integer getLocation(@Param("locationGuid") String locationGuid);
}
