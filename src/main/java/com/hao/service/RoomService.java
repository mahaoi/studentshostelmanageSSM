package com.hao.service;

import com.hao.domain.RoomInfo;


/**
 * @author guoguo
 * @version 1.0
 * @date 2020/3/16 16:37
 */
public interface RoomService extends BaseService<RoomInfo>{
    /**
     * 修改
     * @param roomid
     * @param roomIn
     */
    void update(String roomid,String roomIn);

    /**
     * 登录用户查询
     * @param roomInfo
     * @return
     */
    RoomInfo findRoom(RoomInfo roomInfo);

    /**
     * 修改密码
     * @param roomid
     * @param password
     */
    void upPass(String roomid,String password);
}
