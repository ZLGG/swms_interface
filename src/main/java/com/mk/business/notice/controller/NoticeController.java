package com.mk.business.notice.controller;

import com.mk.business.Constance.Constance;
import com.mk.business.commonutils.model.Interfacesituation;
import com.mk.business.commonutils.service.CommonUtilsService;
import com.mk.business.notice.service.NoticeService;
import com.mk.utils.enums.ResponseStatusEnum;
import com.mk.utils.request.RequestInfoVo;
import com.mk.utils.request.ResponseInfoVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date: 2020-5-15 14:57
 * @author: Znw · Smile
 * @Description:
 */
@RestController
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @Autowired
    private CommonUtilsService commonUtilsService;
    @RequestMapping(value = "/saveOrUpdateNotice.do",method = RequestMethod.POST,consumes = "application/json;charset=utf-8")
    @ApiOperation(value = "新增/更新公告信息", notes = "新增/更新公告信息")
    public ResponseInfoVo saveOrUpdateNotice(@RequestBody RequestInfoVo requestInfoVo) {
        ResponseInfoVo responseInfoVo = new ResponseInfoVo();
        try {
            responseInfoVo = noticeService.saveOrUpdateNotice(requestInfoVo);
            //插入接口执行情况
            Interfacesituation interfacesituation = new Interfacesituation();
            interfacesituation.setInterfaceName(Constance.NoticesaveOrUpdateNotice);
            interfacesituation.setInterfaceUrl("/saveOrUpdateNotice.do");
            interfacesituation.setInterfaceState(ResponseStatusEnum.SUCCESS.getValue());
            interfacesituation.setInterfaceSituation(ResponseStatusEnum.SUCCESS.getValue());
            interfacesituation.setInterfaceDesc("新增/更新公告信息");
            commonUtilsService.insertInterfacesituation(interfacesituation);
        } catch (Exception e) {
            e.printStackTrace();
            //插入接口执行情况
            Interfacesituation interfacesituation = new Interfacesituation();
            interfacesituation.setInterfaceName(Constance.NoticesaveOrUpdateNotice);
            interfacesituation.setInterfaceUrl("/saveOrUpdateNotice.do");
            interfacesituation.setInterfaceState(ResponseStatusEnum.FAILED.getValue());
            interfacesituation.setInterfaceSituation(e.getMessage());
            interfacesituation.setInterfaceDesc("新增/更新公告信息");
            commonUtilsService.insertInterfacesituation(interfacesituation);
            responseInfoVo.returnErrorResult("-1","系统异常:"+e.getMessage());
        }
        return responseInfoVo;
    }
}
