package com.hao.service.impl;

import com.hao.dao.RoomDao;
import com.hao.domain.RoomInfo;
import com.hao.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/3/16 16:37
 */
@Service("RoomService")
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomDao roomDao;

    @Override
    public List<RoomInfo> findAll() {
        return roomDao.findAll();
    }

    @Override
    public void delete(String roomid) {
        roomDao.delRoom(roomid);
    }

    @Override
    public void update(String roomid, String roomIn) {
        roomDao.update(roomid,roomIn);
    }

    @Override
    public int insert(RoomInfo roomInfo) {
        return 0;
    }
}
