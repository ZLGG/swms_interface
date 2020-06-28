package com.mk.business.trustinfo.dao;

import com.mk.business.trustinfo.model.Trustinfo;

import java.util.HashMap;

public interface TrustinfoDao {
    int deleteByPrimaryKey(String trustInfoGuid);

    int insert(Trustinfo record);

    int insertSelective(Trustinfo record);

    Trustinfo selectByPrimaryKey(String trustInfoGuid);

    int updateByPrimaryKeySelective(Trustinfo record);

    int updateByPrimaryKey(Trustinfo record);

    Trustinfo getTrustinfo(HashMap<String, String> condition);
}