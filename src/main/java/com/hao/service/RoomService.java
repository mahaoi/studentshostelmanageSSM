package com.hao.service;

import com.hao.domain.RoomInfo;

import java.util.List;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/3/16 16:37
 */
public interface RoomService {

    //查询所有
    List<RoomInfo> findAll();

}
