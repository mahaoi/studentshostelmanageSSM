package com.hao.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/4/2 16:32
 */
@Data
public class Repair implements Serializable {
    /**
     * 报修id
     */
    private Integer repairId;
    /**
     * 报修名称
     */
    private String repairName;
    /**
     * 报修时间
     */
    private Date repairTime;
    /**
     * 报修内容
     */
    private String repairText;
    /**
     * 报修结束时间
     */
    private Date endTime;
    /**
     * 报修状态
     */
    private String repairState;
}
