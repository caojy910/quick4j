package com.eliteams.quick4j.web.model;

import java.util.Date;

public class Job {
    private Long id;

    private Date createTime;

    private Integer type;

    private Long deciveid;

    private String description;

    private String lastsuggest;

    private Long localengineerid;

    private Long remoteengineerid;

    private Integer devicestate;

    private Integer jobstate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getDeciveid() {
        return deciveid;
    }

    public void setDeciveid(Long deciveid) {
        this.deciveid = deciveid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getLastsuggest() {
        return lastsuggest;
    }

    public void setLastsuggest(String lastsuggest) {
        this.lastsuggest = lastsuggest == null ? null : lastsuggest.trim();
    }

    public Long getLocalengineerid() {
        return localengineerid;
    }

    public void setLocalengineerid(Long localengineerid) {
        this.localengineerid = localengineerid;
    }

    public Long getRemoteengineerid() {
        return remoteengineerid;
    }

    public void setRemoteengineerid(Long remoteengineerid) {
        this.remoteengineerid = remoteengineerid;
    }

    public Integer getDevicestate() {
        return devicestate;
    }

    public void setDevicestate(Integer devicestate) {
        this.devicestate = devicestate;
    }

    public Integer getJobstate() {
        return jobstate;
    }

    public void setJobstate(Integer jobstate) {
        this.jobstate = jobstate;
    }
}