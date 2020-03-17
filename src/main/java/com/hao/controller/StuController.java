package com.hao.controller;

import com.alibaba.fastjson.JSON;
import com.hao.domain.StudentInfo;
import com.hao.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    //查询所有
    @RequestMapping("/findall")
    public String findAll(){
        List<StudentInfo> list = stuService.findAll();
        return JSON.toJSON(list).toString();
    }

    //根据学号删除
    @RequestMapping("/del")
    public void delById(String id){
        stuService.delById(id);
    }
}
