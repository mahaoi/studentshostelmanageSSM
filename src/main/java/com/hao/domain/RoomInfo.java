package com.hao.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/3/15 19:16
 */
public class RoomInfo implements Serializable {
    private String roomid;//宿舍编号
    private Integer roomin;//可入住人数
    private String password;//密码
    private String remarks;//备注

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public Integer getIn() {
        return roomin;
    }

    public void setIn(Integer in) {
        this.roomin = in;
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
                ", in=" + roomin +
                ", password='" + password + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
