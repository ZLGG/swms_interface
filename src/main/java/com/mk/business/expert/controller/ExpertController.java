package com.mk.business.expert.controller;

import com.mk.business.expert.model.Expert;
import com.mk.business.expert.service.ExpertService;
import com.mk.utils.model.ReturnMessage;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:专家信息
 * Created by zhangnengwei on 2020-4-8 17:16
 */
@RestController
@Api(description = "专家信息")
public class ExpertController {
    @Autowired
    private ExpertService expertService;

    @RequestMapping(value = "/saveOrUpdateExpertInfo.do",method = RequestMethod.POST,consumes = "application/json;charset=utf-8")
    public ReturnMessage saveOrUpdateExpertInfo (@RequestBody Expert expert){
        try {
            expertService.saveOrUpdateExpertInfo(expert);
            return new ReturnMessage().ReturnMessageSuccess("保存专家信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new ReturnMessage("400", e.getMessage() + "专家信息保存失败");
        }
    }
}
