package com.hao.service.impl;

import com.hao.dao.StuDao;
import com.hao.domain.StudentInfo;
import com.hao.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/3/15 19:34
 */
@Service("StuService")
public class StuServiceImpl implements StuService {
    @Autowired
    private StuDao stuDao;

    @Override
    public List<StudentInfo> findAll() {
        //查询所有
        return stuDao.findAll();
    }

    @Override
    public List<StudentInfo> findByState(String state) {
        //查询未分配
        return stuDao.findByState(state);
    }

    @Override
    public List<StudentInfo> findById(String id) {
        //学号查询
        return stuDao.findById(id);
    }

    @Override
    public List<StudentInfo> findByName(String name) {
        //姓名模糊查询
        return stuDao.findByName(name);
    }

    @Override
    public List<StudentInfo> findByClass(String classes) {
        //班级查询
        return stuDao.findByClass(classes);
    }

    @Override
    public void delById(String id) {
        //根据学号删除
        stuDao.delById(id);
    }

    @Override
    public void upState(String state, String id) {
        stuDao.upState(state,id);
    }
}
