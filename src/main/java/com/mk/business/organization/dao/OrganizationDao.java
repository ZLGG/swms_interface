package com.mk.business.organization.dao;

import com.mk.business.organization.model.Organization;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
*Description:
*Created by zhangnengwei on 2020-4-8 15:21
*/
public interface OrganizationDao extends Mapper<Organization> {

    @Select("select count(1) from t_d_organization where Org_Guid = #{orgGuid}")
    public Integer getOrganization(@Param("orgGuid") String orgGuid);

}
