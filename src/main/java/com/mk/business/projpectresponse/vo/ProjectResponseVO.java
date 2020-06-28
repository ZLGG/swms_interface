package com.mk.business.projpectresponse.vo;

import com.mk.business.projpectresponse.model.ProjectResponse;

import java.util.List;

public class ProjectResponseVO {

    private String interfaceCode;
    private String dataResource;

    private List<ProjectResponse> projectResponseList;

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

    public List<ProjectResponse> getProjectResponseList() {
        return projectResponseList;
    }

    public void setProjectResponseList(List<ProjectResponse> projectResponseList) {
        this.projectResponseList = projectResponseList;
    }
}
