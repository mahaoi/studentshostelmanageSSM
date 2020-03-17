package com.hao.controller;

import com.alibaba.fastjson.JSON;
import com.hao.domain.Room_Stu;
import com.hao.service.Room_StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/3/16 21:29
 */
@Controller
@RequestMapping(value = "/room_stu",produces = "text/json;charset=UTF-8")
@ResponseBody
public class Room_StuController {

    @Autowired
    private Room_StuService room_stuService;

    @RequestMapping("/findAllStu")
    public String findByRoomid(String roomid){
        List<Room_Stu> room_stu = room_stuService.findByRoomid(roomid);
        return JSON.toJSON(room_stu).toString();
    }
}
