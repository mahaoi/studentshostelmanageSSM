package com.hao.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/3/30 12:40
 */
public class VisitorInfo implements Serializable {
    private Integer visitId;
    private String visitName;
    private String visitPhone;
    private Date visitTime;
    private String visitRemarks;

    public Integer getVisitId() {
        return visitId;
    }

    public void setVisitId(Integer visitId) {
        this.visitId = visitId;
    }

    public String getVisitName() {
        return visitName;
    }

    public void setVisitName(String visitName) {
        this.visitName = visitName;
    }

    public String getVisitPhone() {
        return visitPhone;
    }

    public void setVisitPhone(String visitPhone) {
        this.visitPhone = visitPhone;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getVisitRemarks() {
        return visitRemarks;
    }

    public void setVisitRemarks(String visitRemarks) {
        this.visitRemarks = visitRemarks;
    }

    @Override
    public String toString() {
        return "VisitorInfo{" +
                "visitId=" + visitId +
                ", visitName='" + visitName + '\'' +
                ", visitPhone='" + visitPhone + '\'' +
                ", visitTime=" + visitTime +
                ", visitRemarks='" + visitRemarks + '\'' +
                '}';
    }
}
