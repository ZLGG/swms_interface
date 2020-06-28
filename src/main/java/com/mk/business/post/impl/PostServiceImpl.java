package com.mk.business.post.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.mk.business.post.dao.PostDao;
import com.mk.business.post.service.PostService;
/**
*@date: 2020-5-15 16:56
*@author: Znw · Smile
*@Description:
*/
@Service
@Primary
public class PostServiceImpl implements PostService{

    @Resource
    private PostDao postDao;

    @Override
    public Integer getPost(String postGuid) {
        Integer num = postDao.countByPrimaryKey(postGuid);
        return num;
    }
}
