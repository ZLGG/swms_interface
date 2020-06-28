package com.mk.business.commentresult.dao;

import com.mk.business.commentresult.model.CommentResult;
import com.mk.business.commentresult.model.CommentResultDetail;

import java.util.List;

public interface CommentResultDao {
    /**
     * 根据评审结果id,删除采购评审结果明细
     * @param commentResultGuid
     */
    void delCommentResultDetail(String commentResultGuid);

    /**
     * 根据id查询评审结果
     * @param commentResultGuid
     * @return
     */
    Integer getCommentResult(String commentResultGuid);

    /**
     * 更新评审结果
     * @param commentResult
     */
    void updateCommentResult(CommentResult commentResult);

    /**
     * 插入评审结果
     * @param commentResult
     */
    void insertCommentResult(CommentResult commentResult);

    /**
     * 插入采购评审结果明细
     * @param commentResultDetail
     */
    void insertCommentResultDetail(CommentResultDetail commentResultDetail);

    /**
     * 根据项目guid，查询评审结果guid list
     * @param projectGuid
     * @return
     */
    List<String> getCommentResultList(String projectGuid);

    /**
     * 删除采购项目对应的 采购评审结果
     * @param projectGuid
     */
    void delCommentResult(String projectGuid);

    /**
     * 根据采购评审结果明细guid，删除采购评审结果分项报价
     * @param commentResultDetailGuid
     */
    void delCommentResultPrice(String commentResultDetailGuid);

    /**
     * 根据采购评审结果guid，查询采购评审结果明细guid
     * @param commentResuletGuid
     * @return
     */
    List<String> getCommentResultDetailGuids(String commentResuletGuid);
}
