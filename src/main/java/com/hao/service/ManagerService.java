package com.hao.service;

import com.hao.domain.ManagerInfo;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/4/1 16:28
 */
public interface ManagerService {
    //用户名检测
    ManagerInfo testOldPass(ManagerInfo managerInfo);

    //登录用户查询
    ManagerInfo findManager(ManagerInfo managerInfo);

    // 保存用户信息
    void saveManager(ManagerInfo managerInfo);

    //修改
    void update(String username, String password);
}
