package com.hao.domain;

import java.io.Serializable;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/3/7 15:48
 */
public class Student implements Serializable {

    private Integer sid;//id
    private String username;//姓名
    private String password;//密码
    private String phone;//电话

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
