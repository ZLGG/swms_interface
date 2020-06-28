package com.mk.business.user.dao;

import com.mk.business.user.model.User;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
*@date: 2020-5-15 16:56
*@author: Znw · Smile
*@Description:
*/
public interface UserDao extends Mapper<User> {
    /**
     * 根据主键校验数据完整性
     * @Param: [excuteUserGuid]
     * @return: java.lang.Integer
     * @Author: Znw · Smile
     * @CreateDate: 2020-5-15 17:04
     */
    @Select("select count(1) from t_user where t_user.User_Guid = #{excuteUserGuid}")
    Integer countByPrimaryKey(String excuteUserGuid);
}
