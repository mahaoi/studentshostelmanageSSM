package com.hao.controller;

import com.alibaba.fastjson.JSON;
import com.hao.domain.Room;
import com.hao.domain.Student;
import com.hao.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @author guoguo
 * @version 1.0
 * @date 2020/3/7 15:29
 */
@Controller
@RequestMapping("/login")
@ResponseBody
public class LogController {

    @Autowired
    private LogService logService;

    @RequestMapping("/test")
    public String testUserName(Student student){
        // 用户名是否存在(0:存在   1:不存在)
        System.out.println("用户检测==========>" + student.getUsername());
        return logService.testUserName(student).getPassword()!=null ? "0" : "1";
    }

    @RequestMapping("/log")
    public String loginController(Student student){
        //0：登陆成功  1：登陆失败
        Student findstudent = logService.findStudent(student);
        System.out.println(findstudent + "==登录判断==" + student);
        if (findstudent == null){
            return "1";
        }
        return findstudent.getUsername().equals(student.getUsername()) && findstudent.getPassword().equals(student.getPassword()) ? "0" : "1";
    }

    @RequestMapping("/add")
    public String addController(Student student){
        System.out.println("用户添加==========>" + student);
        logService.saveStudent(student);
        return "0";
    }

    //查询所有
    @RequestMapping("/findall")
    public String findAll(){
        List<Student> list = logService.findAll();
        return JSON.toJSON(list).toString();
    }

    //查询有空床位的宿舍
    @RequestMapping("/updateRoom")
    public String updateRoom(){
        List<Room> roomList = logService.updateRoom();
        System.out.println(roomList);
        return JSON.toJSON(roomList).toString();
    }
}
