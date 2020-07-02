package com.hao.controller;

import cn.hutool.crypto.digest.DigestUtil;
import com.alibaba.fastjson.JSON;
import com.hao.domain.ManagerInfo;
import com.hao.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/4/1 16:31
 */
@Controller
@RequestMapping(value = "/sign",produces = "text/json;charset=UTF-8")
@ResponseBody
public class ManagerController {

    final String SUCCESS = "0";
    final String FAIL = "1";

    @Autowired
    private ManagerService managerService;


    @RequestMapping("/login")
    public String loginManager(ManagerInfo managerInfo, HttpSession session){
        ManagerInfo manager = managerService.findManager(managerInfo);
        if (manager != null){
            session.setAttribute("user",manager.getUsername());
            return SUCCESS;
        }
        return FAIL;
    }

    @RequestMapping("/log")
    public String loginPassTest(ManagerInfo managerInfo){
        ManagerInfo manager = managerService.testOldPass(managerInfo);
        if ((manager.getPassword()).equals(DigestUtil.md5Hex(managerInfo.getPassword()))){
            return SUCCESS;
        }
        return FAIL;
    }

    @RequestMapping("/add")
    public void addManager(ManagerInfo managerInfo){
        managerService.insert(managerInfo);
    }

    @RequestMapping("/update")
    public void upManagerPass(String username,String password){
        managerService.update(username,password);
    }

    @RequestMapping(value = "/logout")
    public void logout(HttpSession session) throws Exception {
        // 清除Session
        session.invalidate();
    }

    @RequestMapping("/findAll")
    public String findAllManager() {
        return JSON.toJSON(managerService.findAll()).toString();
    }

    @RequestMapping("/del")
    public void delManager(String username){
        managerService.delete(username);
    }
}
