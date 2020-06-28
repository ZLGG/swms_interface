package com.mk.business.Intention.impl;

import com.alibaba.fastjson.JSONObject;
import com.mk.business.Constance.Constance;
import com.mk.business.Intention.dao.IntentionpublicDao;
import com.mk.business.Intention.model.Intentionpublic;
import com.mk.business.Intention.service.IntentionService;
import com.mk.business.optionlist.model.Optionlist;
import com.mk.business.optionlist.service.OptionlistService;
import com.mk.utils.model.ReturnMessage;
import com.mk.utils.request.RequestInfoVo;
import com.mk.utils.util.UUIDGenerator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;


@Service
@Primary
public class IntentionServiceImpl implements IntentionService {

    @Autowired
    private OptionlistService optionlistService;

    @Autowired
    private IntentionpublicDao intentionpublicDao;

    @Transactional
    @Override
    public ReturnMessage saveOrUpdateIntention(RequestInfoVo requestInfoVo) throws Exception{
        Intentionpublic intentionpublic = null;
        String messageDecryptStringToBase64 = null;
        //解密数据
        try {
            messageDecryptStringToBase64 = requestInfoVo.MessageDecryptStringToBase64();
        } catch (Exception e) {
            throw new Exception("解密失败" + e.getMessage());
        }
        try {
            intentionpublic = JSONObject.parseObject(messageDecryptStringToBase64, Intentionpublic.class);
        } catch (Exception e) {
            throw new Exception("数据解析异常" + e.getMessage());
        }
        checkRequestParam(intentionpublic.getDataResource());
        Intentionpublic oldIntention = intentionpublicDao.selectByPrimaryKey(intentionpublic.getId());

        if (oldIntention == null) {
            //插入
            intentionpublicDao.insert(intentionpublic);
        } else {
            //更新
            intentionpublicDao.updateByPrimaryKey(intentionpublic);
        }

        return new ReturnMessage().ReturnMessageSuccess("意向公开信息保存成功");
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
