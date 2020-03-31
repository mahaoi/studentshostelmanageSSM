package com.hao.controller;

import com.alibaba.fastjson.JSON;
import com.hao.domain.VisitorInfo;
import com.hao.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/3/30 12:50
 */
@Controller
@RequestMapping(value = "/vis",produces = "text/json;charset=UTF-8")
@ResponseBody
public class VisitController {

    @Autowired
    private VisitService visitService;

    //查询所有
    @RequestMapping("/findAll")
    public String findAll(){
        return JSON.toJSON(visitService.findAll()).toString();
    }

    //插入记录
    @RequestMapping("/add")
    public void add(String visitName,String visitPhone,String visitRemarks){
        Date date = new Date();
        VisitorInfo visitor = new VisitorInfo();
        visitor.setVisitName(visitName);
        visitor.setVisitPhone(visitPhone);
        visitor.setVisitTime(date);
        visitor.setVisitRemarks(visitRemarks);
        visitService.insert(visitor);
    }
}
