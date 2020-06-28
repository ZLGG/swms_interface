package com.mk.business.agent.dao;

import com.mk.business.agent.model.Agent;

public interface AgentDao {
    int deleteByPrimaryKey(String agentGuid);

    int insert(Agent record);

    int insertSelective(Agent record);

    Agent selectByPrimaryKey(String agentGuid);

    int updateByPrimaryKeySelective(Agent record);

    int updateByPrimaryKey(Agent record);

}