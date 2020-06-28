package com.mk.business.expert.dao;

import com.mk.business.expert.model.Expert;

public interface ExpertDao {
    int deleteByPrimaryKey(String expertGuid);

    int insert(Expert record);

    int insertSelective(Expert record);

    Expert selectByPrimaryKey(String expertGuid);

    int updateByPrimaryKeySelective(Expert record);

    int updateByPrimaryKey(Expert record);
}