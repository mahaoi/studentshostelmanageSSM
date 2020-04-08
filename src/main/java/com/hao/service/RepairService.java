package com.hao.service;

import com.hao.domain.Repair;

import java.util.List;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/4/2 16:36
 */
public interface RepairService extends BaseService<Repair> {

    /**
     * 查询单个宿舍的报修记录
     * @param repairName
     * @return
     */
    List<Repair> findByRoomId(String repairName);

    /**
     * 修改状态
     * @param repair
     */
    void upState(Repair repair);
}
