package com.mk.business.bidexpert.controller;

import com.alibaba.fastjson.JSON;
import com.mk.business.Constance.Constance;
import com.mk.business.bidexpert.model.BidExpertVo;
import com.mk.business.bidexpert.service.BidExpertService;
import com.mk.business.commonutils.model.Interfacesituation;
import com.mk.business.commonutils.service.CommonUtilsService;
import com.mk.utils.model.ReturnMessage;
import com.mk.utils.request.RequestInfoVo;
import com.mk.utils.request.ResponseInfoVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "BidExpert", description = "评审专家")
public class BidExpertController {
    @Autowired
    private BidExpertService bidExpertService;
    @Autowired
    private CommonUtilsService commonUtilsService;

    /**
     * 保存评审专家
     * @param requestInfoVo
     * @return
     */
    @RequestMapping( value = "/saveBidExpert.do" ,method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public ResponseInfoVo saveOrUpdateBidExpert(@RequestBody RequestInfoVo requestInfoVo)throws Exception {
        ResponseInfoVo responseInfoVo = new ResponseInfoVo();
        try {
            ReturnMessage returnMessage = bidExpertService.saveOrUpdateBidExpert(requestInfoVo);
            //插入接口执行情况
            Interfacesituation interfacesituation =new Interfacesituation();
            interfacesituation.setInterfaceName(Constance.BidExpertsaveBidExpert);
            interfacesituation.setInterfaceUrl("/saveBidExpert.do");
            interfacesituation.setInterfaceState("成功");
            interfacesituation.setInterfaceSituation("成功");
            interfacesituation.setInterfaceDesc("新增标项评审专家信息");
            commonUtilsService.insertInterfacesituation(interfacesituation);
            responseInfoVo.returnSuccessResult(JSON.toJSONString(returnMessage),"新增标项评审专家信息成功");
            return responseInfoVo;
        } catch (Exception e) {
            e.printStackTrace();
            //插入接口执行情况
            Interfacesituation interfacesituation =new Interfacesituation();
            interfacesituation.setInterfaceName(Constance.BidExpertsaveBidExpert);
            interfacesituation.setInterfaceUrl("/saveBidExpert.do");
            interfacesituation.setInterfaceState("失败");
            interfacesituation.setInterfaceSituation(e.getMessage());
            interfacesituation.setInterfaceDesc("新增标项评审专家信息");
            commonUtilsService.insertInterfacesituation(interfacesituation);
            responseInfoVo.returnErrorResult("-2","新增标项评审专家信息失败"+e.toString());
            return responseInfoVo;
        }
    }
}
