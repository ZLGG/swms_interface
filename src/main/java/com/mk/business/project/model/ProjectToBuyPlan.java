package com.mk.business.project.model;

public class ProjectToBuyPlan {
    private String projectToBuyPlanGuid;
    private String projectGuid;
    private String bidItemGuid;
    private String buyPlanDetailGuid;

    public String getProjectToBuyPlanGuid() {
        return projectToBuyPlanGuid;
    }

    public void setProjectToBuyPlanGuid(String projectToBuyPlanGuid) {
        this.projectToBuyPlanGuid = projectToBuyPlanGuid;
    }

    public String getProjectGuid() {
        return projectGuid;
    }

    public void setProjectGuid(String projectGuid) {
        this.projectGuid = projectGuid;
    }

    public String getBidItemGuid() {
        return bidItemGuid;
    }

    public void setBidItemGuid(String bidItemGuid) {
        this.bidItemGuid = bidItemGuid;
    }

    public String getBuyPlanDetailGuid() {
        return buyPlanDetailGuid;
    }

    public void setBuyPlanDetailGuid(String buyPlanDetailGuid) {
        this.buyPlanDetailGuid = buyPlanDetailGuid;
    }

}
