package com.mk.business.year.service;

import com.mk.business.year.model.Year;

/**
*Description: 保存/更新年度信息
*Created by zhangnengwei on 2020-4-8 15:07
*/
public interface YearService{

    /**
     * @Description:保存/更新年度信息
     * @Author: zhangnengwei
     * @Date: 2020-4-8 15:12
     */
        void saveOrUpdateYear(Year year);
}
