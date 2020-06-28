package com.mk.business.region.dao;

import com.mk.business.region.model.Region;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
*Description:
*Created by zhangnengwei on 2020-4-8 14:23
*/
public interface RegionDao extends Mapper<Region> {
    @Select("select count(1) from t_d_region where Region_Guid = #{regionGuid}")
    public Integer getRegion(@Param("regionGuid") String regionGuid);
}
