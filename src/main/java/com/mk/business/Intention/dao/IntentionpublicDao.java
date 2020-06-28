package com.mk.business.Intention.dao;

import com.mk.business.Intention.model.Intentionpublic;

public interface IntentionpublicDao {
    int deleteByPrimaryKey(String id);

    int insert(Intentionpublic record);

    int insertSelective(Intentionpublic record);

    Intentionpublic selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Intentionpublic record);

    int updateByPrimaryKey(Intentionpublic record);
}