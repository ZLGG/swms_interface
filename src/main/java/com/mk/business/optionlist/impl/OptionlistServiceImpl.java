package com.mk.business.optionlist.impl;

import com.mk.business.optionlist.model.Optionlist;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.mk.business.optionlist.dao.OptionlistDao;
import com.mk.business.optionlist.service.OptionlistService;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
*Description: 选项列表
*Created by zhangnengwei on 2020-4-8 15:30
*/
@Service
@Primary
public class OptionlistServiceImpl implements OptionlistService{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private OptionlistDao optionlistDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveOrUpdateOptionList(Optionlist optionlist) {
        logger.info("判断数据是否存在(存在则更新，不存在插入)");
        //根据主键查询该数据
        Optionlist optionlistInfo = optionlistDao.selectByPrimaryKey(optionlist);
        if (null != optionlistInfo) {
            logger.info("开始: 更新数据");
            optionlistDao.updateByPrimaryKeySelective(optionlist);
        } else {
            logger.info("开始: 新增数据");
            optionlistDao.insertSelective(optionlist);
        }
    }

    @Override
    public Optionlist checkOptionListByTypeAndCode(String type, String code) {
        if(StringUtils.isNotEmpty(code)){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("optionTypeGuid",type);
            map.put("code",code);
            return optionlistDao.checkOptionListByTypeAndCode(map);
        }else{
            return null;
        }

    }


}
