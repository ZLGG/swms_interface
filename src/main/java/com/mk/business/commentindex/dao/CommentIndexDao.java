package com.mk.business.commentindex.dao;

import com.mk.business.commentindex.model.CommentIndex;
import com.mk.business.commentindex.model.CommentIndexPoint;
import com.mk.business.commentindex.model.CommentResultPrice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CommentIndexDao {
    void delCommentIndexPoint(String commentIndexGuid);

    void delCommentResultPrice(String commentResultDetailGuid);

    Integer getCommentIndex(String commentIndexGuid);

    void updateCommentIndex(CommentIndex commentIndex);

    void insertCommentIndex(CommentIndex commentIndex);

    void insertCommentIndexPoint(CommentIndexPoint commentIndexPoint);

    void insertCommentResultPrice(CommentResultPrice commentResultPrice);

    /**
     * 根据项目id，查询评审指标id集合
     * @param projectGuid
     * @return
     */
    List<String> getCommentIndexGuids(String projectGuid);


    /**
     * 删除评审指标
     * @param projectGuid
     */
    void delCommentIndexByProject(String projectGuid);

    /**
     * 根据项目id、标项id，查询标项评标专家guid
     * @param condition
     * @return
     */
    String getBidExpertGuid(HashMap<String, String> condition);

    /**
     * 根据项目id   全删评审记录分
     * @param projectGuid
     */
    void delCommentIndexPointByProject(String projectGuid);

    /**
     * 根据标项评审专家guid删除评分记录
     * @param bidExpertGuid
     */
    void delCommentIndexPointByBidExpertGuid(String bidExpertGuid);

    /**
     * 获取评审指标的父guid
     * @param condition
     * @return
     */
    String getCommentIndexPGuid(Map condition);

    /**
     * 根据父id，查询是否有子
     * @param commentIndexGuid
     * @return
     */
    List<String> getCommentIndexByPGuid(String commentIndexGuid);

    /**
     * 根据id删除指标
     * @param commentIndexGuid
     */
    void delCommentIndexByCommentIndexGuid(String commentIndexGuid);
}
