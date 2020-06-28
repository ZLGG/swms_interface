package com.mk.business.bidexpert.model;

import com.mk.business.project.model.Project;

import java.util.List;

public class BidExpertVo {
    private String interfaceCode;
    private String dataResource;



    private List<BidExpert> bidExpertList;
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

    public List<BidExpert> getBidExpertList() {
        return bidExpertList;
    }

    public void setBidExpertList(List<BidExpert> bidExpertList) {
        this.bidExpertList = bidExpertList;
    }
}
