package com.mk.business.expert.service;

import com.mk.business.expert.model.Expert;

import java.text.ParseException;

/**
 * Description: 专家信息
 * Created by zhangnengwei on 2020-4-8 17:16
 */
public interface ExpertService {

    /**
     * @Description:更新/保存专家信息
     * @Author: zhangnengwei
     * @Date: 2020-4-8 17:19
     */
    void saveOrUpdateExpertInfo(Expert expert) throws Exception;

    /**
     * 根据id查询专家
     * @param expertGuid
     * @return
     */
    Integer getExpert(String expertGuid);
}
