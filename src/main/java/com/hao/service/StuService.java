package com.hao.service;

import com.hao.domain.StudentInfo;

import java.util.List;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/3/15 19:33
 */
public interface StuService {
    //查询所有
    List<StudentInfo> findAll();

    //删除
    void delById(String id);
}
