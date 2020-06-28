package com.mk.business.post.dao;

import com.mk.business.post.model.Post;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
*@date: 2020-5-15 16:56
*@author: Znw · Smile
*@Description:
*/
public interface PostDao extends Mapper<Post> {

    @Select("select count(1) from t_post where t_post.Post_Guid = #{postGuid}")
    Integer countByPrimaryKey(String postGuid);
}
