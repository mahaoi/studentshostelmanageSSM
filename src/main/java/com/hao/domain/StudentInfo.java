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
    /**
     * 学号
     */
    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 专业
     */
    private String major;
    /**
     * 班级
     */
    private String classes;
    /**
     * 电话
     */
    private String phone;
    /**
     * 状态(0代表已分配)
     */
    private String state;
}
