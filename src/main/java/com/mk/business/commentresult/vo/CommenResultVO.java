package com.mk.business.commentresult.vo;

import com.mk.business.commentresult.model.CommentResult;
import com.mk.business.commentresult.model.CommentResultDetail;
import com.mk.business.project.model.Project;

import java.util.List;

public class CommenResultVO {
    private String interfaceCode;
    private String dataResource;

    private List<CommentResult> commentResultList;

    public String getInterfaceCode() {
        return interfaceCode;
    }

    public void setInterfaceCode(String interfaceCode) {
        this.interfaceCode = interfaceCode;
    }

    public String getDataResource() {
        return dataResource;
    }

    public void setDataResource(String dataResource) {
        this.dataResource = dataResource;
    }

    public List<CommentResult> getCommentResultList() {
        return commentResultList;
    }

    public void setCommentResultList(List<CommentResult> commentResultList) {
        this.commentResultList = commentResultList;
    }
}
