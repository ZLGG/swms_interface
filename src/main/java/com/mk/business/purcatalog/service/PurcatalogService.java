package com.mk.business.purcatalog.service;

import com.mk.business.purcatalog.model.Purcatalog;

/**
*Description: 采购目录
*Created by zhangnengwei on 2020-4-8 15:02
*/
public interface PurcatalogService{

    /**
     * @Description:保存/更新采购目录
     * @Author: zhangnengwei
     * @Date: 2020-4-8 15:05
     */
    void saveOrUpdatePurCatalog(Purcatalog purcatalog);

    /**
     * 根据主键判断数是否存在
     * @Param: [purcatalogGuid]
     * @return: java.lang.Integer
     * @Author: Znw · Smile
     * @CreateDate: 2020-5-15 10:46
     */
    Integer getPurCatalog(String purcatalogGuid);
}
