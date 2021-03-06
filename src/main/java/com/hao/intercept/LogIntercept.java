package com.hao.intercept;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author guoguo
 * @version 1.0
 * @date 2020/4/1 15:34
 */
public class LogIntercept implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取请求的URL
        String url = request.getRequestURI();
        // 一些静态文件不能拦截，否则会死循环，知道内存耗尽
        if (url.indexOf("login") >= 0 || url.indexOf("logout") >= 0) {
            return true;
        }
        // 获取Session
        Object object = request.getSession().getAttribute("user");
        if (object != null) {
            return true;
        }
        Object obj = request.getSession().getAttribute("room");
        if (obj != null) {
            return true;
        }
        //不符合条件的，跳转到登录界面
        response.sendRedirect("/login.jsp");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
