package com.hao.service.impl;

import com.hao.dao.LogDao;
import com.hao.domain.Student;
import com.hao.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/3/7 15:51
 */
@Service("logService")
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao logDao;

    @Override
    public Student testUserName(Student student) {
        return logDao.testUserName(student);
    }

    @Override
    public void saveStudent(Student student) {
        logDao.saveStudent(student);
    }

    @Override
    public Student findStudent(Student student) {
        return logDao.findStudent(student);
    }
}
