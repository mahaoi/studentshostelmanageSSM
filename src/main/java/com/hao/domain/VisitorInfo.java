package com.hao.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/3/30 12:40
 */
@Data
public class VisitorInfo implements Serializable {
    /**
     * id
     */
    private Integer visitId;
    /**
     * 来访者姓名
     */
    private String visitName;
    /**
     * 来访者电话
     */
    private String visitPhone;
    /**
     * 来访时间
     */
    private Date visitTime;
    /**
     * 被访者姓名
     */
    private String stuName;
    /**
     * 被访者宿舍
     */
    private String stuRoom;
    /**
     * 来访原由
     */
    private String visitRemarks;

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
