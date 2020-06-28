package com.mk.business.agent.impl;

import com.mk.business.agent.model.Agent;
import com.mk.business.commonutils.service.CommonUtilsService;
import com.mk.utils.util.UUIDGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.mk.business.agent.dao.AgentDao;
import com.mk.business.agent.service.AgentService;
import org.springframework.transaction.annotation.Transactional;
import java.text.ParseException;
import java.util.Date;

/**
*Description: 采购机构
*Created by zhangnengwei on 2020-4-8 17:21
*/
@Service
@Primary
public class AgentServiceImpl implements AgentService{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private AgentDao agentDao;

    @Autowired
    private CommonUtilsService commonUtilsService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdatePurchaseAgency(Agent agent) throws ParseException {
        logger.info("判断数据是否存在(存在则更新，不存在插入)");
        // 根据主键查询该数据
        Agent agentInfo = agentDao.selectByPrimaryKey(agent.getAgentGuid());
        // 设置时间戳
        Date currentSqlDate = commonUtilsService.getCurrentSqlDate();
        Date dateWithoutTime = commonUtilsService.getCurrentSqlDateWithoutTime(currentSqlDate);
        agent.setBizTimeStamp(currentSqlDate);
        agent.setBizDate(dateWithoutTime);
        if (null != agentInfo) {
            logger.info("开始: 更新数据");
            agentDao.updateByPrimaryKeySelective(agent);
        } else {
            logger.info("开始: 新增数据");
            agent.setAgentGuid(UUIDGenerator.randomUUID());
            agentDao.insert(agent);
        }
    }

    @Override
    public Integer getAgent(String agentGuid) {
        Agent agent1 = agentDao.selectByPrimaryKey(agentGuid);
        if (agent1 != null) {
            return 1;
        }
        return 0;
    }

}
