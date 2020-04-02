package com.hao.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/4/2 16:32
 */
public class Repair implements Serializable {
    private Integer repairId;
    private String repairName;
    private Date repairTime;
    private String repairText;
    private Date endTime;
    private String repairState;

    public Integer getRepairId() {
        return repairId;
    }

    public void setRepairId(Integer repairId) {
        this.repairId = repairId;
    }

    public String getRepairName() {
        return repairName;
    }

    public void setRepairName(String repairName) {
        this.repairName = repairName;
    }

    public Date getRepairTime() {
        return repairTime;
    }

    public void setRepairTime(Date repairTime) {
        this.repairTime = repairTime;
    }

    public String getRepairText() {
        return repairText;
    }

    public void setRepairText(String repairText) {
        this.repairText = repairText;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getRepairState() {
        return repairState;
    }

    public void setRepairState(String repairState) {
        this.repairState = repairState;
    }

    @Override
    public String toString() {
        return "Repair{" +
                "repairId=" + repairId +
                ", repairName='" + repairName + '\'' +
                ", repairTime=" + repairTime +
                ", repairText='" + repairText + '\'' +
                ", endTime=" + endTime +
                ", repairState='" + repairState + '\'' +
                '}';
    }
}
