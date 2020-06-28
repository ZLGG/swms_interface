package com.mk.business.agent.controller;

import com.mk.business.agent.model.Agent;
import com.mk.business.agent.service.AgentService;
import com.mk.utils.model.ReturnMessage;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

/**
 * Description:采购机构
 * Created by zhangnengwei on 2020-4-8 17:21
 */
@RestController
@Api(description = "采购机构")
public class AgentController {
    @Autowired
    private AgentService agentService;

    @RequestMapping(value = "/saveOrUpdatePurchaseAgency.do",method = RequestMethod.POST,consumes = "application/json;charset=utf-8")
    public ReturnMessage saveOrUpdatePurchaseAgency (@RequestBody Agent agent) throws ParseException {
        try {
            agentService.saveOrUpdatePurchaseAgency(agent);
            return new ReturnMessage().ReturnMessageSuccess("采购机构推送成功");
        } catch (Exception e) {
            e.printStackTrace();
            ReturnMessage returnMessage = new ReturnMessage().ReturnMessageFail();
            returnMessage.setMsg(e.getMessage());
            return returnMessage;
        }
    }
}
