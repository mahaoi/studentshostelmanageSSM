package com.hao.service.impl;

import cn.hutool.crypto.digest.DigestUtil;
import com.hao.dao.ManagerDao;
import com.hao.domain.ManagerInfo;
import com.hao.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        managerInfo.setPassword(DigestUtil.md5Hex(managerInfo.getPassword()));
        return managerDao.findManager(managerInfo);
    }

    @Override
    public void update(String username, String password) {
        managerDao.update(username,DigestUtil.md5Hex(password));
    }

    @Override
    public void delete(String id) {
        managerDao.delete(id);
    }

    @Override
    public int insert(ManagerInfo managerInfo) {
        managerInfo.setPassword(DigestUtil.md5Hex(managerInfo.getPassword()));
        return managerDao.insert(managerInfo);
    }

    @Override
    public List<ManagerInfo> findAll() {
        return managerDao.findAll();
    }
}
