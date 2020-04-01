package com.hao.service;

import com.hao.domain.Room_Stu;

import java.util.List;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/3/16 21:23
 */
public interface Room_StuService extends BaseService<Room_Stu>{
    //查询已入住
    List<Room_Stu> findByRoomid(String roomid);

    //每个宿舍已入住人数
    Integer stuCount(String roomid);

    //查询宿舍号
    String findRoomidById(String id);

    //查询宿舍学生学号
    List<Room_Stu> findIdList(String roomId);

    //修改
    void update(String roomid,String id);
}
