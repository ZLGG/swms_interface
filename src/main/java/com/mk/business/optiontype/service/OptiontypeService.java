package com.mk.business.optiontype.service;

import com.mk.business.optiontype.model.Optiontype;

/**
*Description: 选项类别
*Created by zhangnengwei on 2020-4-8 15:26
*/
public interface OptiontypeService{

    /**
     * @Description: 更新/保存选项类别
     * @Author: zhangnengwei
     * @Date: 2020-4-8 15:28
     */
        void saveOrUpdateOptionType(Optiontype optiontype);
}

