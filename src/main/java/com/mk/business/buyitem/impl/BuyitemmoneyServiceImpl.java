package com.mk.business.buyitem.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.mk.business.buyitem.dao.BuyitemmoneyDao;
import com.mk.business.buyitem.model.Buyitemmoney;
import com.mk.business.buyitem.service.BuyitemmoneyService;
import tk.mybatis.mapper.entity.Example;

/**
*Description:
*Created by zhangnengwei on 2020-4-7 11:02
*/
@Service
@Primary
public class BuyitemmoneyServiceImpl implements BuyitemmoneyService{

    @Resource
    private BuyitemmoneyDao buyitemmoneyDao;

    @Override
    public int deleteByPrimaryKey(String buyitemMoneyGuid) {
        return buyitemmoneyDao.deleteByPrimaryKey(buyitemMoneyGuid);
    }

    @Override
    public int insert(Buyitemmoney record) {
        return buyitemmoneyDao.insert(record);
    }

    @Override
    public int insertSelective(Buyitemmoney record) {
        return buyitemmoneyDao.insertSelective(record);
    }

    @Override
    public Buyitemmoney selectByPrimaryKey(String buyitemMoneyGuid) {
        return buyitemmoneyDao.selectByPrimaryKey(buyitemMoneyGuid);
    }

    @Override
    public int updateByPrimaryKeySelective(Buyitemmoney record) {
        return buyitemmoneyDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Buyitemmoney record) {
        return buyitemmoneyDao.updateByPrimaryKey(record);
    }

    @Override
    public void deleteBuyitemMoneysByBuyitemGuid(String buyitemGuid) {
        Example example = new Example(Buyitemmoney.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("buyitemGuid",buyitemGuid);
        buyitemmoneyDao.deleteByExample(example);
    }

    @Override
    public Buyitemmoney selectBuyitemmoney(Buyitemmoney buyitemmoney) {
        Example buyitemmoneyExample = new Example(Buyitemmoney.class);
        Example.Criteria criteria = buyitemmoneyExample.createCriteria();
        criteria.andEqualTo("interfaceCode",buyitemmoney.getInterfaceCode());
        criteria.andEqualTo("dataResource",buyitemmoney.getDataResource());
        Buyitemmoney buyitemmoneyResult = buyitemmoneyDao.selectOneByExample(buyitemmoneyExample);
        return buyitemmoneyResult;
    }

    @Override
    public void deleteBuyitemMoneysByExample(Example buyitemmoneyExample) {
        buyitemmoneyDao.deleteByExample(buyitemmoneyExample);
    }

    @Override
    public void updateBuyitemMoneyByRequestParam(Buyitemmoney buyitemmoney) {
        buyitemmoneyDao.updateByPrimaryKey(buyitemmoney);
    }

}
