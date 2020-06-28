package com.mk.business.zcyBuyplan.impl;

import com.alibaba.fastjson.JSONObject;
import com.mk.business.Constance.Constance;
import com.mk.business.optionlist.model.Optionlist;
import com.mk.business.optionlist.service.OptionlistService;
import com.mk.business.zcyBuyplan.dao.ZcyBuyplanDao;
import com.mk.business.zcyBuyplan.model.ZcyBuyplan;
import com.mk.business.zcyBuyplan.servcie.ZcyBuyplanService;
import com.mk.utils.model.ReturnMessage;
import com.mk.utils.request.RequestInfoVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class ZcyBuyplanServiceImpl implements ZcyBuyplanService {

    @Autowired
    private OptionlistService optionlistService;

    @Autowired
    private ZcyBuyplanDao zcyBuyplanDao;

    @Override
    public ReturnMessage saveOrUpdateZcyBuyplan(RequestInfoVo requestInfoVo)throws Exception{
        ZcyBuyplan zcyBuyplan = null;
        String messageDecryptStringToBase64 = null;
        //解密数据
        try {
            messageDecryptStringToBase64 = requestInfoVo.MessageDecryptStringToBase64();
        } catch (Exception e) {
            throw new Exception("解密失败" + e.getMessage());
        }
        try {
            zcyBuyplan = JSONObject.parseObject(messageDecryptStringToBase64, ZcyBuyplan.class);
        } catch (Exception e) {
            throw new Exception("数据解析异常" + e.getMessage());
        }
        checkRequestParam(zcyBuyplan.getDataResource());
        ZcyBuyplan oldZcyBuyplan = zcyBuyplanDao.selectByPrimaryKey(zcyBuyplan.getPurchaseplanId());
        if (oldZcyBuyplan == null) {
            //插入
            zcyBuyplanDao.insert(zcyBuyplan);
        } else {
            //更新
            zcyBuyplanDao.updateByPrimaryKey(zcyBuyplan);
        }
        return new ReturnMessage().ReturnMessageSuccess("政采云采购计划保存成功");
    }

    private void checkRequestParam( String dataResource) throws Exception {
        if ( StringUtils.isBlank(dataResource)) {
            throw new Exception("保存失败：项目dataResource为空");
        }
        Optionlist dataResourceOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Data_Resource, dataResource);
        if (dataResourceOption == null) {
            throw new Exception(dataResource + "不存在该数据来源");
        }
    }
}
