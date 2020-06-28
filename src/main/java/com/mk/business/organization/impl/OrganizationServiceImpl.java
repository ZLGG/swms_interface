package com.mk.business.organization.impl;

import com.mk.business.organization.model.Organization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.mk.business.organization.dao.OrganizationDao;
import com.mk.business.organization.service.OrganizationService;
import org.springframework.transaction.annotation.Transactional;

/**
*Description: 采购单位
*Created by zhangnengwei on 2020-4-8 15:21
*/
@Service
@Primary
public class OrganizationServiceImpl implements OrganizationService{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private OrganizationDao organizationDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdateOrganization(Organization organization) {
        logger.info("判断数据是否存在(存在则更新，不存在插入)");
        //根据主键查询该数据
        Organization organizationInfo = organizationDao.selectByPrimaryKey(organization);
        if (null != organizationInfo) {
            logger.info("开始: 更新数据");
            organizationDao.updateByPrimaryKeySelective(organization);
        } else {
            logger.info("开始: 新增数据");
            organizationDao.insertSelective(organization);
        }
    }

    @Override
    public Integer getOrganization(String orgguid) {
        Integer count = organizationDao.getOrganization(orgguid);
        return count;
    }
}
