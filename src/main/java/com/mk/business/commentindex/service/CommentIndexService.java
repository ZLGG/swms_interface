package com.mk.business.commentindex.service;

import com.mk.business.commentindex.vo.CommentIndexVO;
import com.mk.utils.model.ReturnMessage;
import com.mk.utils.request.RequestInfoVo;
import com.mk.utils.request.ResponseInfoVo;

public interface CommentIndexService {
    /**
     * 保存评审指标
     * @param requestInfoVo
     * @return
     */
    ReturnMessage saveOrUpdateCommentIndex(RequestInfoVo requestInfoVo)throws Exception;

    /**
     * 根据项目id，全删评审指标
     * @param projectGuid
     */
    void delCommentIndexByProject(String projectGuid);
}
