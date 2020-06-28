package com.mk.business.expert.impl;

import com.mk.business.commonutils.service.CommonUtilsService;
import com.mk.business.expert.model.Expert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.mk.business.expert.dao.ExpertDao;
import com.mk.business.expert.service.ExpertService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
*Description:专家信息
*Created by zhangnengwei on 2020-4-8 17:16
*/
@Service
@Primary
public class ExpertServiceImpl implements ExpertService{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ExpertDao expertDao;

    @Autowired
    private CommonUtilsService commonUtilsService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdateExpertInfo(Expert expert) throws Exception {
        logger.info("判断数据是否存在(存在则更新，不存在插入)");
        // 根据主键查询该数据
        Expert expertInfo = expertDao.selectByPrimaryKey(expert.getExpertGuid());
        // 设置时间戳
        Date currentSqlDate = commonUtilsService.getCurrentSqlDate();
        Date dateWithoutTime = commonUtilsService.getCurrentSqlDateWithoutTime(currentSqlDate);
        expert.setBizTimeStamp(currentSqlDate);
        expert.setBizDate(dateWithoutTime);
        if (null != expertInfo) {
            logger.info("开始: 更新数据");
            expertDao.updateByPrimaryKey(expert);
        } else {
            logger.info("开始: 新增数据");
            expertDao.insert(expert);
        }
    }

    @Override
    public Integer getExpert(String expertGuid) {
        Expert expert = expertDao.selectByPrimaryKey(expertGuid);
        if (expert == null) {
            return 0;
        }
        return 1;
    }
}
