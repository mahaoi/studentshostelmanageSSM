package com.hao.service.impl;

import com.hao.dao.RepairDao;
import com.hao.domain.Repair;
import com.hao.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/4/2 16:37
 */
@Service("RepairService")
public class RepairServiceImpl implements RepairService {

    @Autowired
    private RepairDao repairDao;

    @Override
    public List<Repair> findByRoomId(String repairName) {
        return repairDao.findByRoomId(repairName);
    }

    @Override
    public void delete(String id) { }

    @Override
    public int insert(Repair repair) {
        repair.setRepairTime(new Date());
        return repairDao.insert(repair);
    }

    @Override
    public List<Repair> findAll() {
        return repairDao.findall();
    }

    @Override
    public void upState(String repairId,String repairState) {
        Repair repair = new Repair();
        repair.setRepairId(Integer.valueOf(repairId));
        repair.setEndTime(new Date());
        repair.setRepairState(repairState);
        repairDao.upState(repair);
    }
}
