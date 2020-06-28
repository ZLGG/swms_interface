package com.mk.business.bizattachment.service;

import com.mk.business.bizattachment.model.Bizattachment;

/**
*@date: 2020-5-7 11:25
*@author: Znw · Smile
*@Description:
*/
public interface BizattachmentService{
    /**
     * 新增单条附件信息
     * @Param: [bizattachment 附件实体]
     * @return: void
     * @Author: Znw · Smile
     * @CreateDate: 2020-5-7 11:35
     */
    void insertBizAttachment(Bizattachment bizattachment);

    /**
     * 根据业务主键/类型,删除对应附件信息
     * @Param: [bizGuid 业务主键, bizType 业务类型]
     * @return: void
     * @Author: Znw · Smile
     * @CreateDate: 2020-5-7 11:37
     */
    void deleteAttachmentByBizIdAndType(String bizGuid,String bizType);

    /**
     * 校验附件请求参数
     * @Param: [bizattachment]
     * @return: void
     * @Author: Znw · Smile
     * @CreateDate: 2020-5-14 9:59
     */
    void checkAttachmentParam(Bizattachment bizattachment) throws Exception;
}
