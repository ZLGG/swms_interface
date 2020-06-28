package com.mk.business.optionlist.dao;

import com.mk.business.optionlist.model.Optionlist;
import tk.mybatis.mapper.common.Mapper;

import java.util.Map;

/**
*Description:
*Created by zhangnengwei on 2020-4-8 15:30
*/
public interface OptionlistDao extends Mapper<Optionlist> {

    /**
     *
     * @param map
     * @return
     */
    Optionlist checkOptionListByTypeAndCode(Map<String,Object> map);
}
