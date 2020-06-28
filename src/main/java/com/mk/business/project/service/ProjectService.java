package com.mk.business.project.service;

import com.mk.business.project.model.BidItem;
import com.mk.business.project.model.Project;
import com.mk.utils.model.ReturnMessage;
import com.mk.utils.request.RequestInfoVo;
import com.mk.utils.request.ResponseInfoVo;

public interface ProjectService {

    /**
     * 保存或更新项目主体 更新项目、标项、全删全删更新项目对应的采购计划，全删其余所有子表
     *
     * @param requestInfoVo
     * @return
     * @throws Exception
     */
    public ReturnMessage saveOrUpdateProject(RequestInfoVo requestInfoVo) throws Exception;

    /**
     * 根据interfaceCode和dataResource查询项目
     *
     * @param interfaceCode
     * @param dataResource
     * @return
     */
    public Project getProject(String interfaceCode, String dataResource);

    /**
     * 根据guid查询项目
     * @param projectGuid
     * @return
     */
    public Project getProject(String projectGuid);

    /**
     * 根据guid查询标项
     * @param interfaceCode
     *@param dataResource
     * @return
     */
    public BidItem getBidItem(String interfaceCode, String dataResource);
}
