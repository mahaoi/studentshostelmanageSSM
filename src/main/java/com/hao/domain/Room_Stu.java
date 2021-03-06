package com.hao.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/3/15 19:21
 */
@Data
public class Room_Stu implements Serializable {
    /**
     * id
     */
    private Integer rsid;
    /**
     * 宿舍号
     */
    private String roomid;
    /**
     * 学生id
     */
    private String id;
    /**
     * 宿舍学生list
     */
    private List<StudentInfo> studentInfos;
}
