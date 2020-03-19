package com.hao.service.impl;

import com.hao.dao.Room_StuDao;
import com.hao.domain.Room_Stu;
import com.hao.service.Room_StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/3/16 21:23
 */
@Service("Room_StuService")
public class Room_StuServiceImpl implements Room_StuService {

    @Autowired
    private Room_StuDao room_stuDao;

    @Override
    public List<Room_Stu> findByRoomid(String roomid) {
        return room_stuDao.findByRoomid(roomid);
    }

    @Override
    public Integer stuCount(String roomid) {
        return room_stuDao.stuCount(roomid);
    }

    @Override
    public String findRoomidById(String id) {
        return room_stuDao.findRoomidById(id);
    }
}
