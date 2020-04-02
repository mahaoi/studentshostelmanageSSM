package com.hao.service;

import com.hao.domain.RoomInfo;


/**
 * @author guoguo
 * @version 1.0
 * @date 2020/3/16 16:37
 */
public interface RoomService extends BaseService<RoomInfo>{
    //修改
    void update(String roomid,String roomIn);

    //登录用户查询
    RoomInfo findRoom(RoomInfo roomInfo);

    //修改密码
    void upPass(String roomid,String password);
}
