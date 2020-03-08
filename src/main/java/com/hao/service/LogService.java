package com.hao.service;

import com.hao.domain.Student;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/3/7 15:49
 */
public interface LogService {
    //用户名检测
    Student testUserName(Student student);

    //登录用户查询
    Student findStudent(Student student);

    // 保存用户信息
    void saveStudent(Student student);
}
