package com.mk.business.commonutils.service;

import com.mk.business.commonutils.model.Interfacesituation;
import com.mk.business.project.model.Project;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * Description:通用工具Service
 * Created by zhangnengwei on 2020-4-16 14:34
 */
public interface CommonUtilsService {

    /**
     * 实现不同表之间——InterFaceCode查Guid的方法
     * @Param: [tableName表名 , interfaceCode源主键ID, dataResource数据来源, column列名]
     * @return: java.lang.String
     * @Author: Znw · Smile
     * @CreateDate: 2020-4-26 11:28
     */
    String getGuidByCodeAndResource(String tableName, String interfaceCode, String dataResource, String column);

    /**
     * 获取数据库系统中的当前日期(含时分秒)
     * @Param: []
     * @return: java.util.Date
     * @Author: Znw · Smile
     * @CreateDate: 2020-4-26 10:57
     */
    Date getCurrentSqlDate();

    /**
     * 获取不含时分秒的日期(为防时间不统一,需传入带时分秒的当前日期)
     *
     * @Param: [currentSqlDate已查出的当前时间]
     * @return: java.util.Date
     * @Author: Znw · Smile
     * @CreateDate: 2020-4-26 11:42
     */
    Date getCurrentSqlDateWithoutTime(Date currentSqlDate) throws ParseException;


    /**
     *插入接口执行情况
     */
    void insertInterfacesituation(Interfacesituation Interfacesituation);


   /**
    * 校验请求参数
    * @Param: [model]
    * @return: java.util.List
    * @Author: Znw · Smile
    * @CreateDate: 2020-5-13 18:24
    */
    List<String> checkRequestParam(Object model) throws Exception;
}
