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

    @RequestMapping("/test")
    public String testUserName(ManagerInfo managerInfo){
        // 用户名是否存在(0:存在   1:不存在)
        return managerService.testUserName(managerInfo).getPassword()!=null ? "0" : "1";
    }

    @RequestMapping("/login")
    public String loginController(ManagerInfo managerInfo, HttpSession session){
        //0：登陆成功  1：登陆失败
        ManagerInfo manager = managerService.findManager(managerInfo);
        if (manager != null){
            session.setAttribute("user",manager.getUsername());
            return "0";
        }
        return "1";
    }

    @RequestMapping("/add")
    public String addController(ManagerInfo managerInfo){
        managerService.saveManager(managerInfo);
        return "0";
    }

    @RequestMapping(value = "/logout")
    public void logout(HttpSession session) throws Exception {
        // 清除Session
        session.invalidate();
    }
}
