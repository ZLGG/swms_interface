package com.mk.business.buyitem.service;

import com.mk.business.buyitem.model.Buyitemmoney;
import tk.mybatis.mapper.entity.Example;

/**
*Description:采购预算资金明细Service
*Created by zhangnengwei on 2020-4-7 11:02
*/
public interface BuyitemmoneyService{


    int deleteByPrimaryKey(String buyitemMoneyGuid);

    int insert(Buyitemmoney record);

    int insertSelective(Buyitemmoney record);

    Buyitemmoney selectByPrimaryKey(String buyitemMoneyGuid);

    int updateByPrimaryKeySelective(Buyitemmoney record);

    int updateByPrimaryKey(Buyitemmoney record);

    void deleteBuyitemMoneysByBuyitemGuid(String buyitemGuid);

    /**
     * @Description:查询已存在的Buyitemmoney数量
     * @Author: zhangnengwei
     * @Date: 2020-4-14 18:31
     */
    Buyitemmoney selectBuyitemmoney(Buyitemmoney buyitemmoney);

    /**
     * @Description:删除失效的BuyitemMoney
     * @Author: zhangnengwei
     * @Date: 2020-4-14 18:31
     */
    void deleteBuyitemMoneysByExample(Example buyitemmoneyExample);

    /**
     * @Description:根据请求参数更新buyitemmoney信息
     * @Author: zhangnengwei
     * @Date: 2020-4-14 20:49
     */
    void updateBuyitemMoneyByRequestParam(Buyitemmoney buyitemmoney);
}
