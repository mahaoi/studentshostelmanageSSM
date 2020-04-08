package com.hao.service;

import com.hao.domain.ManagerInfo;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/4/1 16:28
 */
public interface ManagerService extends BaseService<ManagerInfo> {
    /**
     * 用户名检测
     * @param managerInfo
     * @return
     */
    ManagerInfo testOldPass(ManagerInfo managerInfo);

    /**
     * 登录用户查询
     * @param managerInfo
     * @return
     */
    ManagerInfo findManager(ManagerInfo managerInfo);

    /**
     * 修改
     * @param username
     * @param password
     */
    void update(String username, String password);
}
