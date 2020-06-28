package com.mk.business.financedept.service;

import com.mk.business.financedept.model.Financedept;

/**
*Description: 财政业务部门
*Created by zhangnengwei on 2020-4-8 15:16
*/
public interface FinancedeptService{

    /**
     * @Description:保存/更新财政业务部门信息
     * @Author: zhangnengwei
     * @Date: 2020-4-8 15:18
     */
    void saveOrUpdateFinanceDept(Financedept financedept);

    /**
     * 查询财政业务部门数据完整性
     * @Param: [financeDeptGuid]
     * @return: java.lang.Integer
     * @Author: Znw · Smile
     * @CreateDate: 2020-5-15 10:40
     */
    Integer getFinanceDept(String financeDeptGuid);

}
