package com.mk.business.bidexpert.dao;

import com.mk.business.bidexpert.model.BidExpert;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface BidExpertDao {
    void insert(BidExpert bidExpert);

    void updateBidExpert(BidExpert bidExpert);

    Integer getBidExpert(String bidExpertGuid);

    /**
     * 根据项目id 删除标项评标专家
     * @param projectGuid
     */
    void delBidExpertByProjectGuid(String projectGuid);

    /**
     * 删除失效数据 标项评审专家
     * @param projectGuid
     * @param dataResource
     * @param bidExpertInterfaceCodes
     */
    void delNonexistentbidExpert(@Param("projectGuid") String projectGuid,@Param("dataResource") String dataResource,
                                 @Param("bidExpertInterfaceCodes") List bidExpertInterfaceCodes);

    /**
     * 删除该项目所有 标项评审专家
     * @param projectGuid
     */
    void delAllbidExpertByProject(String projectGuid);

    /**
     * 根据interfacecode获取 标项评审专家
     * @param condition
     * @return
     */
    BidExpert getBidExpertByInterfaceCode(HashMap<String, String> condition);

    /**
     * 根据项目guid查询所有标项评审专家guid
     * @param projectGuid
     */
    List<String> getBidExpertByProjectGuid(String projectGuid);

    /**
     * 根据id 查询专家
     * @param expertGuid
     */
    String getExpert(String expertGuid);
}
