package com.hao.service;

import com.hao.domain.StudentInfo;

import java.util.List;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/3/15 19:33
 */
public interface StuService extends BaseService<StudentInfo>{

    //查询未分配宿舍学生
    List<StudentInfo> findByState(String state);

    //id学号查询
    List<StudentInfo> findById(String id);

    //姓名模糊查询
    List<StudentInfo> findByName(String name);

    //班级查询
    List<StudentInfo> findByClass(String classes);

    //更新学生状态
    void upState(String state,String id);
}
