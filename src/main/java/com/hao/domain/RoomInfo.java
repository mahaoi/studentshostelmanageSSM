package com.hao.domain;


import lombok.Data;

import java.io.Serializable;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/3/15 19:16
 */
@Data
public class RoomInfo implements Serializable {
    /**
     * 宿舍编号
     */
    private String roomid;
    /**
     * 可入住人数
     */
    private Integer roomin;
    /**
     * 密码
     */
    private String password;
    /**
     * 备注
     */
    private String remarks;

    @Override
    public String toString() {
        return "RoomInfo{" +
                "roomid='" + roomid + '\'' +
                ", roomin=" + roomin +
                ", password='" + password + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
