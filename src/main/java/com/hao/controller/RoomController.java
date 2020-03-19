package com.hao.controller;

import com.alibaba.fastjson.JSON;
import com.hao.domain.RoomInfo;
import com.hao.domain.Room_Stu;
import com.hao.service.RoomService;
import com.hao.service.Room_StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/3/16 16:39
 */
@Controller
@RequestMapping(value = "/room",produces = "text/json;charset=UTF-8")
@ResponseBody
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private Room_StuService room_stuService;

    //查询所有房间
    @RequestMapping("/findAllRoom")
    public String findAll(){
        //房间信息list
        List<RoomInfo> list = roomService.findAll();
        //房间list添加已入住人数和剩余入住人数
        List objectList = new ArrayList();
        for (RoomInfo room : list) {
            Map<String,Object> map = new HashMap();
            map.put("roomid",room.getRoomid());
            map.put("in",room.getIn());
            map.put("ining",room_stuService.stuCount(room.getRoomid()));
            map.put("surplus",room.getIn()-room_stuService.stuCount(room.getRoomid()));
            map.put("password",room.getPassword());
            map.put("remarks",room.getRemarks());
            //添加至objectList
            objectList.add(map);
        }
        return JSON.toJSON(objectList).toString();
    }

    //删除宿舍
    @RequestMapping("/del")
    public void delRoom(String roomid){
        //删除宿舍
        roomService.delRoom(roomid);
    }
}
