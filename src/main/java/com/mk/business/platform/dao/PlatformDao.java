package com.mk.business.platform.dao;

import com.mk.business.platform.model.Platform;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
*Description:
*Created by zhangnengwei on 2020-4-8 15:52
*/
public interface PlatformDao extends Mapper<Platform> {
    @Select("select count(1) from t_d_platform where t_d_platform.Platform_Guid = #{platformGuid} ")
    Integer countPlatformByPrimaryKey(String platformGuid);
}
