package com.mk.business.agent.service;

import com.mk.business.agent.model.Agent;

import java.text.ParseException;

/**
 * Description: 采购机构
 * Created by zhangnengwei on 2020-4-8 17:21
 */
public interface AgentService {

    /**
     * @Description:保存/更新采购机构
     * @Author: zhangnengwei
     * @Date: 2020-4-8 17:23
     */
    void saveOrUpdatePurchaseAgency(Agent agent) throws ParseException;

    /**
     * 根据id查询采购机构
     * @param agentGuid
     * @return
     */
    Integer getAgent(String agentGuid);
}
