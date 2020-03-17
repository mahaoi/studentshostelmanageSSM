package com.hao.service;

import com.hao.domain.Room_Stu;

import java.util.List;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/3/16 21:23
 */
public interface Room_StuService {
    //查询已入住
    List<Room_Stu> findByRoomid(String roomid);

    //每个宿舍已入住人数
    Integer stuCount(String roomid);
}
