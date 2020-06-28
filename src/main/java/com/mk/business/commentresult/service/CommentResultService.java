package com.mk.business.commentresult.service;

import com.mk.business.commentresult.vo.CommenResultVO;
import com.mk.utils.model.ReturnMessage;
import com.mk.utils.request.RequestInfoVo;

public interface CommentResultService {
    /**
     * 保存 采购评审结果
     * @param requestInfoVo
     * @return
     */
    ReturnMessage saveOrUpdateCommentResult(RequestInfoVo requestInfoVo)throws Exception;

    /**
     * 删除采购评审过程 结果，结果明细，明细报价表
     */
    void delCommentResultAndCommentResultDetail(String projectguid);
}
