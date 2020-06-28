package com.mk.business.optionlist.service;

import com.mk.business.optionlist.model.Optionlist;

/**
*Description: 选项列表
*Created by zhangnengwei on 2020-4-8 15:30
*/
public interface OptionlistService{

    /**
     * @Description:更新/保存选项列表
     * @Author: zhangnengwei
     * @Date: 2020-4-8 15:32
     */
      void saveOrUpdateOptionList(Optionlist optionlist);

    /**
     * 根据type和code查询option
     * @param type
     * @param code
     * @return
     */
      Optionlist checkOptionListByTypeAndCode(String type,String code);
}
