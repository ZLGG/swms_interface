package com.mk.business.bizattachment.impl;

import com.mk.business.Constance.Constance;
import com.mk.business.bizattachment.model.Bizattachment;
import com.mk.business.commonutils.exception.ParamException;
import com.mk.business.commonutils.service.CommonUtilsService;
import com.mk.business.optionlist.model.Optionlist;
import com.mk.business.optionlist.service.OptionlistService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.mk.business.bizattachment.dao.BizattachmentDao;
import com.mk.business.bizattachment.service.BizattachmentService;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
*@date: 2020-5-7 11:25
*@author: Znw · Smile
*@Description:
*/
@Service
@Primary
public class BizattachmentServiceImpl implements BizattachmentService{

    @Resource
    private BizattachmentDao bizattachmentDao;

    @Autowired
    private CommonUtilsService commonUtilsService;

    @Autowired
    private OptionlistService optionlistService;

    @Override
    public void insertBizAttachment(Bizattachment bizattachment) {
        bizattachmentDao.insert(bizattachment);
    }

    @Override
    public void deleteAttachmentByBizIdAndType(String bizGuid, String bizType) {
        Example attachmentDeletingExample = new Example(Bizattachment.class);
        Example.Criteria attachmentDeletingCriteria = attachmentDeletingExample.createCriteria();
        attachmentDeletingCriteria.andEqualTo("bizGuid",bizGuid);
        attachmentDeletingCriteria.andEqualTo("bizType",bizType);
        bizattachmentDao.deleteByExample(attachmentDeletingExample);
    }

    @Override
    public void checkAttachmentParam(Bizattachment bizattachment) throws Exception {
        List<String> nullParamList = commonUtilsService.checkRequestParam(bizattachment);
        if (CollectionUtils.isNotEmpty(nullParamList)) {
            String errorParams = nullParamList.toString();
            throw new Exception(errorParams + "为空！");
        }

        // 枚举值校验
        Optionlist attachmentType = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Attachment_Type, bizattachment.getAttachmentType());
        if (null == attachmentType) {
            throw new ParamException("附件枚举值异常:数据中心找不到对应枚举值attachmentType:" + bizattachment.getAttachmentType());
        }
    }
}
