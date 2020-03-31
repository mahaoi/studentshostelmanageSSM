package com.hao.controller;

import com.alibaba.fastjson.JSON;
import com.hao.domain.StudentInfo;
import com.hao.service.Room_StuService;
import com.hao.service.StuService;
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
 * @date 2020/3/15 19:28
 */
@Controller
@RequestMapping(value = "/stu",produces = "text/json;charset=UTF-8")
@ResponseBody
public class StuController {

    @Autowired
    private StuService stuService;

    @Autowired
    private Room_StuService room_stuService;

    //查询所有
    @RequestMapping("/findAll")
    public String findAll(){
        List<StudentInfo> list = stuService.findAll();
        List objectList = new ArrayList();
        for (StudentInfo stu : list) {
            Map<String,Object> map = new HashMap();
            map.put("id",stu.getId());
            map.put("name",stu.getName());
            map.put("sex",stu.getSex());
            map.put("major",stu.getMajor());
            map.put("classes",stu.getClasses());
            map.put("phone",stu.getPhone());
            map.put("state",stu.getState());
            map.put("roomid",room_stuService.findRoomidById(stu.getId()));
            //添加至objectList
            objectList.add(map);
        }
        return JSON.toJSON(objectList).toString();
    }

    //未分配学生
    @RequestMapping("/findByState")
    public String findByState(String state){
        return JSON.toJSON(stuService.findByState(state)).toString();
    }

    //姓名模糊查询
    @RequestMapping("/findByName")
    public String findByName(String name){
        return JSON.toJSON(stuService.findByName(name)).toString();
    }

    //学号查询
    @RequestMapping("/findById")
    public String findById(String id){
        return JSON.toJSON(stuService.findById(id)).toString();
    }

    //班级查询
    @RequestMapping("/findByClass")
    public String findByClass(String classes){
        return JSON.toJSON(stuService.findByClass(classes)).toString();
    }

    //根据学号删除
    @RequestMapping("/del")
    public void delById(String id){
        stuService.delete(id);
    }

    //设置学生状态
    @RequestMapping("/upstate")
    public void upState(String state,String id){
        stuService.upState(state,id);
    }
}
