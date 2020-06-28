package com.mk.business.bidexpert.service;

import com.mk.utils.model.ReturnMessage;
import com.mk.utils.request.RequestInfoVo;

public interface BidExpertService {
    /**
     * 保存评审专家
     * @param requestInfoVo
     * @return
     */
    ReturnMessage saveOrUpdateBidExpert(RequestInfoVo requestInfoVo)throws Exception;

    /**
     * 删除项目 ：标项评审专家 及 评审专家评分记录
     * @param projectGuid
     */
    void delChildBidExpertAndCommentIndexPoint(String projectGuid);


}
