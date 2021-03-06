package com.hao.controller;

import com.alibaba.fastjson.JSON;
import com.hao.domain.RoomInfo;
import com.hao.service.RoomService;
import com.hao.service.Room_StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/3/16 16:39
 */
@Controller
@RequestMapping(value = "/room",produces = "text/json;charset=UTF-8")
@ResponseBody
public class RoomController {

    final String SUCCESS = "0";
    final String FAIL = "1";

    @Autowired
    private RoomService roomService;

    @Autowired
    private Room_StuService room_stuService;

    @RequestMapping("/findAllRoom")
    public String findAll(){
        //房间信息list
        List<RoomInfo> list = roomService.findAll();
        //房间list添加已入住人数和剩余入住人数
        List objectList = new ArrayList();
        for (RoomInfo room : list) {
            Map<String,Object> map = new HashMap();
            map.put("roomid",room.getRoomid());
            map.put("in",room.getRoomin());
            map.put("ining",room_stuService.stuCount(room.getRoomid()));
            map.put("surplus",room.getRoomin()-room_stuService.stuCount(room.getRoomid()));
            map.put("password",room.getPassword());
            map.put("remarks",room.getRemarks());
            //添加至objectList
            objectList.add(map);
        }
        return JSON.toJSON(objectList).toString();
    }

    @RequestMapping("/checkIn")
    public String checkIn(){
        //房间信息list
        List<RoomInfo> list = roomService.findAll();
        //使用filter()过滤List
        List<RoomInfo> nullRoomList = list.stream().filter(
                room -> room.getRoomin() - room_stuService.stuCount(room.getRoomid())!=0
        ).collect(Collectors.toList());
        //List转json
        return JSON.toJSON(nullRoomList).toString();
    }

    @RequestMapping("/del")
    public void delRoom(String roomid){
        roomService.delete(roomid);
    }

    @RequestMapping("/updateRoomIn")
    public void updateRoomIn(String roomid,String roomin){
        roomService.update(roomid,roomin);
    }

    @RequestMapping("/login")
    public String loginRoom(RoomInfo roomInfo, HttpSession session){
        RoomInfo room = roomService.findRoom(roomInfo);
        if (room != null){
            session.setAttribute("room",room.getRoomid());
            return SUCCESS;
        }
        return FAIL;
    }

    @RequestMapping("/log")
    public String oldPassTest(RoomInfo roomInfo){
        RoomInfo room = roomService.findRoom(roomInfo);
        if (room != null){
            return SUCCESS;
        }
        return FAIL;
    }

    @RequestMapping("/upUserPass")
    public void upUserPass(String roomid,String password){
        roomService.upPass(roomid,password);
    }

    @RequestMapping("/add")
    public void addRoom(RoomInfo roomInfo){
        roomService.insert(roomInfo);
    }
}
