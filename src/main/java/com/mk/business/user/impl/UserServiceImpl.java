package com.mk.business.user.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.mk.business.user.dao.UserDao;
import com.mk.business.user.service.UserService;
/**
*@date: 2020-5-15 16:56
*@author: Znw · Smile
*@Description:
*/
@Service
@Primary
public class UserServiceImpl implements UserService{

    @Resource
    private UserDao userDao;

    @Override
    public Integer getUser(String excuteUserGuid) {
        Integer num = userDao.countByPrimaryKey(excuteUserGuid);
        return num;
    }
}
