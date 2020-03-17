package com.hao.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/3/15 19:21
 */
public class Room_Stu implements Serializable {
    private Integer rsid;
    private String roomid;
    private String id;
    private List<StudentInfo> studentInfos;

    public Integer getRsid() {
        return rsid;
    }

    public void setRsid(Integer rsid) {
        this.rsid = rsid;
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<StudentInfo> getStudentInfos() {
        return studentInfos;
    }

    public void setStudentInfos(List<StudentInfo> studentInfos) {
        this.studentInfos = studentInfos;
    }

    @Override
    public String toString() {
        return "Room_Stu{" +
                "rsid=" + rsid +
                ", roomid='" + roomid + '\'' +
                ", id='" + id + '\'' +
                ", studentInfos=" + studentInfos +
                '}';
    }
}
