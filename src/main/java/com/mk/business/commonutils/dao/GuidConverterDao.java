package com.mk.business.commonutils.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * Description:实现不同表之间——InterFaceCode查Guid的方法
 * Created by zhangnengwei on 2020-4-15 15:01
 */
public interface GuidConverterDao {
    Map getGuidByCodeAndResource(@Param("tableName") String tableName,
                                 @Param("interfaceCode") String interfaceCode,
                                 @Param("dataResource") String dataResource);
}
