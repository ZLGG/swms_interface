package com.mk.business.Intention.model;

import java.io.Serializable;
import java.util.Date;

/**
 * t_intentionpublic
 * @author 
 */
public class Intentionpublic implements Serializable {
    private String id;

    private String title;

    private String district;

    private String announcementtype;

    private Integer status;

    private String projectcode;

    private String metadata;

    private Date releasedat;

    private String createorgname;

    private String outurl;

    private String dataResource;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAnnouncementtype() {
        return announcementtype;
    }

    public void setAnnouncementtype(String announcementtype) {
        this.announcementtype = announcementtype;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getProjectcode() {
        return projectcode;
    }

    public void setProjectcode(String projectcode) {
        this.projectcode = projectcode;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public Date getReleasedat() {
        return releasedat;
    }

    public void setReleasedat(Date releasedat) {
        this.releasedat = releasedat;
    }

    public String getCreateorgname() {
        return createorgname;
    }

    public void setCreateorgname(String createorgname) {
        this.createorgname = createorgname;
    }

    public String getOuturl() {
        return outurl;
    }

    public void setOuturl(String outurl) {
        this.outurl = outurl;
    }

    public String getDataResource() {
        return dataResource;
    }

    public void setDataResource(String dataResource) {
        this.dataResource = dataResource;
    }
}