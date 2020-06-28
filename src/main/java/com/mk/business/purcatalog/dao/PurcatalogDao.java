package com.mk.business.purcatalog.dao;

import com.mk.business.purcatalog.model.Purcatalog;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
*Description:
*Created by zhangnengwei on 2020-4-8 15:02
*/
public interface PurcatalogDao extends Mapper<Purcatalog> {
    /**
     * 根据主键判断数据是否存在
     * @Param: [purcatalogGuid]
     * @return: java.lang.Integer
     * @Author: Znw · Smile
     * @CreateDate: 2020-5-15 10:47
     */
    @Select("select count(1) from t_d_purcatalog where t_d_purcatalog.PurCatalog_Guid = #{purcatalogGuid}")
    Integer countByPrimaryKey(String purcatalogGuid);
}
