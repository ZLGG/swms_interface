package com.mk.business.commentindex.vo;

import com.mk.business.commentindex.model.CommentIndex;
import com.mk.business.commentindex.model.CommentIndexPoint;
import com.mk.business.commentindex.model.CommentResultPrice;
import com.mk.business.project.model.Project;

import java.util.List;

public class CommentIndexVO {
    private String interfaceCode;
    private String dataResource;

    private List<CommentIndex> commentIndexList;

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

    public List<CommentIndex> getCommentIndexList() {
        return commentIndexList;
    }

    public void setCommentIndexList(List<CommentIndex> commentIndexList) {
        this.commentIndexList = commentIndexList;
    }
}
