package com.eliteams.quick4j.web.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Oprecord {
    private Long id;

    private Long deciveid;

    private Long opengineer;

    private Date opdate;

    private String opcontent;

    private Integer type;

    private Long jobid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDeciveid() {
        return deciveid;
    }

    public void setDeciveid(Long deciveid) {
        this.deciveid = deciveid;
    }

    public Long getOpengineer() {
        return opengineer;
    }

    public void setOpengineer(Long opengineer) {
        this.opengineer = opengineer;
    }

    public String getOpdate() {
        if (opdate == null)
            return "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(opdate);
    }

    public void setOpdate(Date opdate) {
        this.opdate = opdate;
    }

    public String getOpcontent() {
        return opcontent;
    }

    public void setOpcontent(String opcontent) {
        this.opcontent = opcontent == null ? null : opcontent.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getJobid() {
        return jobid;
    }

    public void setJobid(Long jobid) {
        this.jobid = jobid;
    }
}