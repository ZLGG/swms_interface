package com.mk.business.projpectresponse.dao;

import com.mk.business.projpectresponse.model.BidSupplierInfo;
import com.mk.business.projpectresponse.model.ProjectResponse;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ProjectResponseDao {
    /**
     * 根据投标登记Id，删除投标供应商明细
     * @param responseGuid
     */
    void delBidSupplierInfo(String responseGuid);

    /**
     * 根据id查询投标登记
     * @param responseGuid
     * @return
     */
    ProjectResponse getProjectResponseById(String responseGuid);

    /**
     * 更新投标登记
     * @param projectResponse
     */
    void updateProjectResponse(ProjectResponse projectResponse);

    /**
     * 插入投标登记
     * @param projectResponse
     */
    void insertProjectResponse(ProjectResponse projectResponse);

    /**
     * 插入投标供应商明细
     * @param bidSupplierInfo
     */
    void insertSupplierInfo(BidSupplierInfo bidSupplierInfo);

    /**
     * 根据标项id和项目id查询 投标登记responseguid
     * @param condition
     * @return
     */
    String getProjectResponseGuid(Map condition);

    /**
     * 删除项目下的投标登记
     * @param projectGuid
     */
    void delProjectResponse(String projectGuid);

    /**
     * 根据项目guid，查询投标登记
     * @param projectGuid
     * @return
     */
    List<String> getProjectResponseGuidByProjectguid(String projectGuid);


    String getCommentIndexGuid(HashMap<String, String> map);

    /**
     * 查询投标登记
     * @param condition
     */
    ProjectResponse getProjectResponse(HashMap<String, String> condition);

    /**
     * 删除失效的投标登记
     * @param projectGuid
     * @param dataResource
     * @param projectResponseIds
     */
    void delNonexistentProjectResponse(@Param("projectGuid") String projectGuid,@Param("dataResource") String dataResource,@Param("projectResponseIds") List projectResponseIds);

    /**
     * 删除该项目的所有的投标登记
     * @param projectGuid
     * @param dataResource
     */
    void delAllProjectResponseByProject(@Param("projectGuid") String projectGuid,@Param("dataResource") String dataResource);

    /**
     * 根据id查询 行政区划
     * @param locationGuid
     */
    String getLocation(String locationGuid);

    /**
     * 根据id查询 供应商
     * @param supplierGuid
     */
    String getSupplier(String supplierGuid);
}
