package com.hao.service.impl;

import com.hao.dao.VisitDao;
import com.hao.domain.VisitorInfo;
import com.hao.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/3/30 12:48
 */
@Service("VisitService")
public class VisitServiceImpl implements VisitService {

    @Autowired
    private VisitDao visitDao;

    @Override
    public void delete(String id) {
        //访客记录不支持删除
    }

    @Override
    public List<VisitorInfo> findAll() {
        return visitDao.findAll();
    }

    @Override
    public int insert(VisitorInfo visitor) {
        return visitDao.insert(visitor);
    }
}
