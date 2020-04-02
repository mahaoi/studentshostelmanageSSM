package com.hao.service.impl;

import com.hao.dao.ManagerDao;
import com.hao.domain.ManagerInfo;
import com.hao.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/4/1 16:28
 */
@Service("ManagerService")
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerDao managerDao;

    @Override
    public ManagerInfo testOldPass(ManagerInfo managerInfo) {
        return managerDao.testOldPass(managerInfo);
    }

    @Override
    public ManagerInfo findManager(ManagerInfo managerInfo) {
        return managerDao.findManager(managerInfo);
    }

    @Override
    public void saveManager(ManagerInfo managerInfo) {
        managerDao.saveManager(managerInfo);
    }

    @Override
    public void update(String username, String password) {
        managerDao.update(username,password);
    }
}
