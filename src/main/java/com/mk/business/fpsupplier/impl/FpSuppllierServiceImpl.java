package com.mk.business.fpsupplier.impl;

import com.alibaba.fastjson.JSONObject;
import com.mk.business.fpsupplier.dao.FpSupplierDao;
import com.mk.business.fpsupplier.model.FpSupplier;
import com.mk.business.fpsupplier.service.FpSuppllierService;
import com.mk.utils.model.ReturnMessage;
import com.mk.utils.request.RequestInfoVo;
import com.mk.utils.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

@Service
@Primary
public class FpSuppllierServiceImpl implements FpSuppllierService {

    @Autowired
    private FpSupplierDao fpSupplierDao;

    @Override
    @Transactional
    public ReturnMessage saveOrUpdateFpSupplier(RequestInfoVo requestInfoVo)throws Exception {
        FpSupplier fpSupplier = null;
        String messageDecryptStringToBase64 = null;
        //解密数据
        try {
            messageDecryptStringToBase64 = requestInfoVo.MessageDecryptStringToBase64();
        } catch (Exception e) {
            throw new Exception("解密失败" + e.getMessage());
        }
        try {
            fpSupplier = JSONObject.parseObject(messageDecryptStringToBase64, FpSupplier.class);
        } catch (Exception e) {
            throw new Exception("数据解析异常" + e.getMessage());
        }
        FpSupplier oldFpSupplier = fpSupplierDao.selectByOrderId(fpSupplier.getOrderId());
        if (oldFpSupplier == null) {
            //插入
            fpSupplier.setId(UUIDGenerator.randomUUID());
            fpSupplierDao.insert(fpSupplier);
        } else {
            //更新
            fpSupplier.setId(oldFpSupplier.getId());
            fpSupplierDao.updateByPrimaryKey(fpSupplier);
        }
        return new ReturnMessage().ReturnMessageSuccess("扶贫馆供应商信息保存成功");
    }

}
