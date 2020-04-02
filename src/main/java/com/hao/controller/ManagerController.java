package com.hao.controller;

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
@RequestMapping("/sign")
@ResponseBody
public class ManagerController {

    @Autowired
    private ManagerService managerService;


    @RequestMapping("/login")
    public String loginManager(ManagerInfo managerInfo, HttpSession session){
        //0：登陆成功  1：登陆失败
        ManagerInfo manager = managerService.findManager(managerInfo);
        if (manager != null){
            session.setAttribute("user",manager.getUsername());
            return "0";
        }
        return "1";
    }

    @RequestMapping("/log")
    public String loginPassTest(ManagerInfo managerInfo){
        //0：成功  1：失败
        ManagerInfo manager = managerService.testOldPass(managerInfo);
        if ((manager.getPassword()).equals(managerInfo.getPassword())){
            return "0";
        }
        return "1";
    }

    @RequestMapping("/add")
    public String addManager(ManagerInfo managerInfo){
        managerService.saveManager(managerInfo);
        return "0";
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
}
