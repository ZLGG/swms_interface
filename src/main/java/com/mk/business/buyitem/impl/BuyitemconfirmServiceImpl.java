package com.mk.business.buyitem.impl;

import com.mk.business.buyitem.model.Buyitemmoney;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.mk.business.buyitem.dao.BuyitemconfirmDao;
import com.mk.business.buyitem.model.Buyitemconfirm;
import com.mk.business.buyitem.service.BuyitemconfirmService;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
*Description:
*Created by zhangnengwei on 2020-4-7 10:58
*/
@Service
@Primary
public class BuyitemconfirmServiceImpl implements BuyitemconfirmService{

    @Resource
    private BuyitemconfirmDao buyitemconfirmDao;

    @Override
    public int deleteByPrimaryKey(String buyitemConfirmGuid) {
        return buyitemconfirmDao.deleteByPrimaryKey(buyitemConfirmGuid);
    }

    @Override
    public int insert(Buyitemconfirm record) {
        return buyitemconfirmDao.insert(record);
    }

    @Override
    public int insertSelective(Buyitemconfirm record) {
        return buyitemconfirmDao.insertSelective(record);
    }

    @Override
    public Buyitemconfirm selectByPrimaryKey(String buyitemConfirmGuid) {
        return buyitemconfirmDao.selectByPrimaryKey(buyitemConfirmGuid);
    }

    @Override
    public int updateByPrimaryKeySelective(Buyitemconfirm record) {
        return buyitemconfirmDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Buyitemconfirm record) {
        return buyitemconfirmDao.updateByPrimaryKey(record);
    }

    @Override
    public void deleteConfirmsByExample(Example example) {
        buyitemconfirmDao.deleteByExample(example);
    }

    @Override
    public List<Buyitemconfirm> selectByExample(Example example) {
        List<Buyitemconfirm> buyitemconfirms = buyitemconfirmDao.selectByExample(example);
        return buyitemconfirms;
    }

    @Override
    public Buyitemconfirm selectBuyitemconfirm(Buyitemconfirm buyitemconfirm) {
        Example example = new Example(Buyitemmoney.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("interfaceCode",buyitemconfirm.getInterfaceCode());
        criteria.andEqualTo("dataResource",buyitemconfirm.getDataResource());
        Buyitemconfirm buyitemconfirmResult = buyitemconfirmDao.selectOneByExample(example);
        return buyitemconfirmResult;
    }

    @Override
    public void updateBuyitemConfirmByPrimaryKey(Buyitemconfirm buyitemconfirm) {
        buyitemconfirmDao.updateByPrimaryKey(buyitemconfirm);
    }

}
