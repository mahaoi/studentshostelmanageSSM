package com.hao.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/3/15 19:07
 */
@Data
public class StudentInfo implements Serializable {
    private String id;//学号
    private String name;//姓名
    private String sex;//性别
    private String major;//专业
    private String classes;//班级
    private String phone;//电话
    private String state;//状态(0代表已分配)

    @Override
    public String toString() {
        return "StudentInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", major='" + major + '\'' +
                ", classes='" + classes + '\'' +
                ", phone='" + phone + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
