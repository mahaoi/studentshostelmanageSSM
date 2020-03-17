package com.hao.domain;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/3/11 15:36
 */
public class Room {
    private Integer rid;
    private String room;
    private Integer nullroom;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Integer getNullroom() {
        return nullroom;
    }

    public void setNullroom(Integer nullroom) {
        this.nullroom = nullroom;
    }

    @Override
    public String toString() {
        return "Room{" +
                "rid=" + rid +
                ", room='" + room + '\'' +
                ", nullroom=" + nullroom +
                '}';
    }
}
