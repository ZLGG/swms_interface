package com.mk.business.bidexpert.checkmodel;

public class BidExpertCheck {
    private String name;
    private Integer isTeamLeader;
    private Integer isOwnerRepresentative;
    private String interfaceCode;
    private String dataResource;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIsTeamLeader() {
        return isTeamLeader;
    }

    public void setIsTeamLeader(Integer isTeamLeader) {
        this.isTeamLeader = isTeamLeader;
    }

    public Integer getIsOwnerRepresentative() {
        return isOwnerRepresentative;
    }

    public void setIsOwnerRepresentative(Integer isOwnerRepresentative) {
        this.isOwnerRepresentative = isOwnerRepresentative;
    }

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
}
