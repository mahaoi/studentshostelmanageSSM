package com.hao.domain;


import java.io.Serializable;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/3/15 19:16
 */
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

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public Integer getRoomin() {
        return roomin;
    }

    public void setRoomin(Integer roomin) {
        this.roomin = roomin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

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
