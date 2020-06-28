package com.mk.business.buyplan.dao;

import com.mk.business.buyplan.model.Buyplandetail;
import tk.mybatis.mapper.common.Mapper;


public interface BuyplandetailDao extends Mapper<Buyplandetail> {
    int selectBuyplandetailCount(Buyplandetail buyplandetail);
}
