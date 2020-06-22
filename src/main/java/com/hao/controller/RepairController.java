package com.hao.controller;

import com.alibaba.fastjson.JSON;
import com.hao.domain.Repair;
import com.hao.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/4/2 16:38
 */
@Controller
@RequestMapping(value = "/repair",produces = "text/json;charset=UTF-8")
@ResponseBody
public class RepairController {

    @Autowired
    private RepairService repairService;

    @RequestMapping("/findAll")
    public String findAll(){
        return JSON.toJSON(repairService.findAll()).toString();
    }

    @RequestMapping("/addRepair")
    public void add(Repair repair){
        repairService.insert(repair);
    }

    @RequestMapping("/findByRoomId")
    public String findByRoomId(String repairName){
        return JSON.toJSON(repairService.findByRoomId(repairName)).toString();
    }

    @RequestMapping("/upState")
    public void upState(String repairId,String repairState){
        repairService.upState(repairId,repairState);
    }
}
