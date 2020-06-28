package com.mk.business.buyitem.service;

import com.mk.business.buyitem.model.Buyitemconfirm;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
*Description:预算确认Service
*Created by zhangnengwei on 2020-4-7 10:58
*/
public interface BuyitemconfirmService{


    int deleteByPrimaryKey(String buyitemConfirmGuid);

    int insert(Buyitemconfirm record);

    int insertSelective(Buyitemconfirm record);

    Buyitemconfirm selectByPrimaryKey(String buyitemConfirmGuid);

    int updateByPrimaryKeySelective(Buyitemconfirm record);

    int updateByPrimaryKey(Buyitemconfirm record);

    /**
     * @Description:删除失效的Buyitemconfirm数据
     * @Author: zhangnengwei
     * @Date: 2020-4-14 18:32
     */
    void deleteConfirmsByExample(Example example);

    /**
     * 根据条件查询 [t_a_buyitemconfirm]表信息
     * @Param: [example通用Mapper过滤条件]
     * @return: java.util.List<com.mk.business.buyitem.model.Buyitemconfirm>
     * @Author: Znw · Smile
     * @CreateDate: 2020-4-26 16:38
     */
    List<Buyitemconfirm> selectByExample(Example example);

    Buyitemconfirm selectBuyitemconfirm(Buyitemconfirm buyitemconfirm);

    /**
     * @Description:根据请求参数更新子表
     * @Author: zhangnengwei
     * @Date: 2020-4-14 20:35
     */
    void updateBuyitemConfirmByPrimaryKey(Buyitemconfirm buyitemconfirm);
}
