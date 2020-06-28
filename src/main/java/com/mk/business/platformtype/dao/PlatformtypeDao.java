package com.mk.business.platformtype.dao;

import com.mk.business.platformtype.model.Platformtype;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
*Description:
*Created by zhangnengwei on 2020-4-8 15:35
*/
public interface PlatformtypeDao extends Mapper<Platformtype> {
    @Select("select count(1) from t_d_platformtype where t_d_platformtype.Platform_Type_Guid = #{platformTypeGuid} ")
    Integer countByPrimaryKey(String platformTypeGuid);
}
