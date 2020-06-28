package com.mk.business.organization.service;

import com.mk.business.organization.model.Organization;

/**
 * Description: 保存/更新采购单位
 * Created by zhangnengwei on 2020-4-8 15:21
 */
public interface OrganizationService {

    /**
     * @Description:保存/更新采购单位
     * @Author: zhangnengwei
     * @Date: 2020-4-8 15:23
     */
    void saveOrUpdateOrganization(Organization organization);

    /**
     * 根据id查询采购单位
     * @param orgguid
     * @return
     */
    Integer getOrganization(String orgguid);
}
