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
    public void delById(String id) {
        //根据学号删除
        stuDao.delById(id);
    }
}
