package com.mk.business.project.dao;

import com.mk.business.project.model.BidItem;
import com.mk.business.project.model.Project;
import com.mk.business.project.model.ProjectToBuyPlan;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ProjectDao {
    /**
     * 删除项目对应的采购计划明细
     * @param projectGuid
     */
    void delProjectToBuyPlan(String projectGuid);

    /**
     * 删除项目标项
     * @param projectGuid
     */
    void delBidItem(String projectGuid);

    /**
     * 更新项目
     * @param project
     */
    void updateProject(Project project);

    /**
     * 插入项目
     * @param project
     */
    void insertProject(Project project);

    /**
     * 插入项目标项
     * @param bidItem
     */
    void insertBidItem(BidItem bidItem);

    /**
     * 插入项目对应的采购计划明细
     * @param projectToBuyPlan
     */
    void insertProjectToBuyPlan(ProjectToBuyPlan projectToBuyPlan);

    /**
     * 根据interfacecode查询对应的项目
     * @param condition
     */
    Project getProject(Map<String, Object> condition);

    /**
     * 获取项目标项根据interfaceCode
     * @param condition
     * @return
     */
    BidItem getBidItemByGuid(HashMap<String, Object> condition);

    /**
     * 删除失效的项目标项
     * @param
     */
    void delNonexistentBidItem(@Param("projectGuid")String projectGuid,@Param("dataResource") String dataResource,@Param("bidItemGuids") List bidItemGuids);

    void delAllBidItemByProject(@Param("projectGuid") String projectGuid,@Param("dataResource") String dataResource);

    /**
     * 更新项目标项
     * @param bidItem
     */
    void updateBidItem(BidItem bidItem);

    /**
     * 根据id查询采购计划明细
     * @param buyPlanDetailGuid
     */
    String getBuyPlanDetail(String buyPlanDetailGuid);


    /**
     * 根据id查询区域
     * @param regionGuid
     */
    String getRegion(String regionGuid);

    /**
     * 根据id 查询采购单位
     * @param orgGuid
     */
    String getOrg(String orgGuid);

    /**
     * 根据id 查询采购项目
     * @param projectGuid
     */
    Project getProjectByGuid(String projectGuid);

    /**
     * 根据guid查询项目标项
     * @param bidItemGuid
     */
    BidItem getBidItemById(String bidItemGuid);
}
