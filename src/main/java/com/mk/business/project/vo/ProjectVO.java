package com.mk.business.project.vo;

import com.mk.business.bidexpert.model.BidExpert;
import com.mk.business.bidexpert.model.BidExpertVo;
import com.mk.business.commentindex.model.CommentIndex;
import com.mk.business.commentresult.model.CommentResult;
import com.mk.business.project.model.BidItem;
import com.mk.business.project.model.Project;
import com.mk.business.project.model.ProjectToBuyPlan;
import com.mk.business.projpectresponse.model.ProjectResponse;
import com.mk.business.projpectresponse.vo.ProjectResponseVO;

import java.util.List;

public class ProjectVO extends Project{
    private List<BidItem> bidItemList;
    private List<ProjectToBuyPlan> projectToBuyPlanList;


    public List<BidItem> getBidItemList() {
        return bidItemList;
    }

    public void setBidItemList(List<BidItem> bidItemList) {
        this.bidItemList = bidItemList;
    }

    public List<ProjectToBuyPlan> getProjectToBuyPlanList() {
        return projectToBuyPlanList;
    }

    public void setProjectToBuyPlanList(List<ProjectToBuyPlan> projectToBuyPlanList) {
        this.projectToBuyPlanList = projectToBuyPlanList;
    }
}
