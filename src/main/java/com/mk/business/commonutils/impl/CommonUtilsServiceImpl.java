package com.mk.business.commonutils.impl;

import com.mk.business.commonutils.dao.GuidConverterDao;
import com.mk.business.commonutils.dao.InterfaceSituationDao;
import com.mk.business.commonutils.dao.SqlDateDao;
import com.mk.business.commonutils.model.Interfacesituation;
import com.mk.business.commonutils.service.CommonUtilsService;
import com.mk.business.project.dao.ProjectDao;
import com.mk.business.project.model.Project;
import com.mk.utils.enums.TablesEnum;
import com.mk.utils.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Description:通用工具ServiceImpl
 * Created by zhangnengwei on 2020-4-16 14:35
 */
@Service
@Primary
public class CommonUtilsServiceImpl implements CommonUtilsService {

    @Autowired
    private GuidConverterDao guidConverterDao;

    @Autowired
    private SqlDateDao sqlDateDao;

    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private InterfaceSituationDao interfaceSituationDao;

    @Override
    public String getGuidByCodeAndResource(String tableName, String interfaceCode, String dataResource, String column) {
        Map<String,Object> resultMap = guidConverterDao.getGuidByCodeAndResource(tableName, interfaceCode, dataResource);
        if (null == resultMap) {
            return null;
        } else {
            Object columnObject = resultMap.get(column);
            if (null == columnObject) {
                return null;
            } else {
               String columnValue = (String) columnObject;
               return columnValue;
            }
        }
    }

    @Override
    public Date getCurrentSqlDate() {
        Date currentSqlDate = sqlDateDao.getCurrentSqlDate();
        return currentSqlDate;
    }

    @Override
    public Date getCurrentSqlDateWithoutTime(Date currentSqlDate) throws ParseException {
        SimpleDateFormat timeRemovingFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = timeRemovingFormat.format(currentSqlDate);
        Date formattedSqlDate = timeRemovingFormat.parse(formattedDate);
        return formattedSqlDate;
    }


    @Override
    public List<String> checkRequestParam(Object model) throws Exception {
        List<String> nullParamList = new ArrayList<>();
        Field[] declaredFields = model.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            if (null == declaredField.get(model)) {
                String fieldName = declaredField.getName();
                nullParamList.add(fieldName);
            }
        }
        return nullParamList;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertInterfacesituation(Interfacesituation interfacesituation) {
        interfacesituation.setInterfaceSituationGuid(UUIDGenerator.randomUUID());
        interfacesituation.setInterfaceDate(new Date());
        interfaceSituationDao.insertInterfacesituation(interfacesituation);
    }
}
