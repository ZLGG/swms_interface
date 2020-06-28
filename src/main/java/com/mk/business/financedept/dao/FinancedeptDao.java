package com.mk.business.financedept.dao;

import com.mk.business.financedept.model.Financedept;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
*Description:
*Created by zhangnengwei on 2020-4-8 15:16
*/
public interface FinancedeptDao extends Mapper<Financedept> {
    /**
     * 根据主键查询数量判断对应数据是否存在
     * @Param: [financeDeptGuid]
     * @return: java.lang.Integer
     * @Author: Znw · Smile
     * @CreateDate: 2020-5-15 10:43
     */
    @Select("select count(1) from t_d_financedept where t_d_financedept.Finance_Dept_Guid = #{financeDeptGuid} ")
    Integer countFinanceDeptByPrimaryKey(String financeDeptGuid);

}
