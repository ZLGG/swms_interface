package com.mk.business.order.Impl;

import com.alibaba.fastjson.JSONObject;
import com.mk.business.Constance.Constance;
import com.mk.business.bidexpert.model.BidExpertVo;
import com.mk.business.fpsupplier.dao.FpSupplierDao;
import com.mk.business.fpsupplier.model.FpSupplier;
import com.mk.business.fpsupplier.service.FpSuppllierService;
import com.mk.business.optionlist.model.Optionlist;
import com.mk.business.optionlist.service.OptionlistService;
import com.mk.business.order.dao.FpItemDao;
import com.mk.business.order.dao.FpOrderDao;
import com.mk.business.order.model.FpItem;
import com.mk.business.order.model.FpOrder;
import com.mk.business.order.service.OrderService;
import com.mk.utils.model.ReturnMessage;
import com.mk.utils.request.RequestInfoVo;
import com.mk.utils.util.UUIDGenerator;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;


@Primary
@Service
public class OrderServieceImpl implements OrderService {

    @Autowired
    private OptionlistService optionlistService;

    @Autowired
    private FpOrderDao orderDao;

    @Autowired
    private FpItemDao itemDao;

    @Autowired
    private FpSupplierDao fpSupplierDao;

    @Transactional
    @Override
    public ReturnMessage saveOrUpdateOrder(RequestInfoVo requestInfoVo) throws Exception {
        FpOrder order = null;
        String messageDecryptStringToBase64 = null;
        //解密数据
        try {
            messageDecryptStringToBase64 = requestInfoVo.MessageDecryptStringToBase64();
        } catch (Exception e) {
            throw new Exception("解密失败" + e.getMessage());
        }
        try {
            order = JSONObject.parseObject(messageDecryptStringToBase64, FpOrder.class);
        } catch (Exception e) {
            throw new Exception("数据解析异常" + e.getMessage());
        }
        checkRequestParam(order.getDataResource());
        FpOrder oldOrder = orderDao.selectByPrimaryKey(order.getOrderId());
        if (oldOrder != null) {
            //更新订单信息
            orderDao.updateByPrimaryKey(order);
            //全删商品信息
            itemDao.deleteByOrderId(order.getOrderId());
            //全删供应商信息
            itemDao.deleteFpsupplierByOrderId(order.getOrderId());
            //插入商品和供应商信息
            insertChildTable(order);
        } else {
            //插入订单信息
            orderDao.insert(order);
            //插入商品信息
            insertChildTable(order);
        }
        return new ReturnMessage().ReturnMessageSuccess("订单信息保存成功");
    }

    /**
     * 插入商品信息
     *
     * @param order
     */
    private void insertChildTable(FpOrder order) {
        List<FpItem> items = order.getFpItems();
        if (CollectionUtils.isNotEmpty(items)) {
            for (FpItem item : items) {
                item.setOrderId(order.getOrderId());
                itemDao.insert(item);
            }
        }
        List<FpSupplier> fpSuppliers = order.getFpSuppliers();
        if (CollectionUtils.isNotEmpty(fpSuppliers)) {
            for (FpSupplier fpSupplier : fpSuppliers) {
                fpSupplier.setOrderId(order.getOrderId());
                fpSupplier.setId(UUIDGenerator.randomUUID());
                fpSupplierDao.insert(fpSupplier);            }
        }

    }


    private void checkRequestParam(String dataResource) throws Exception {
        if (StringUtils.isBlank(dataResource)) {
            throw new Exception("保存失败：项目dataResource为空");
        }
        Optionlist dataResourceOption = optionlistService.checkOptionListByTypeAndCode(Constance.OptionLIst_Data_Resource, dataResource);
        if (dataResourceOption == null) {
            throw new Exception(dataResource + "不存在该项目数据来源");
        }
    }
}
