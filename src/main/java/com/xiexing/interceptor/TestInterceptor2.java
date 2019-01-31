/**
 * Copyright (C): 长安新生(深圳)金融投资有限公司
 * FileName: TestInterceptor1
 * Author:   xiexing
 * Date:     2018/12/26 13:48
 * Description: 拦截器测试1
 */
package com.xiexing.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestInterceptor2 implements HandlerInterceptor {


    /**
     * 在DispatcherServlet之前执行
     * */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("************TestInterceptor2 preHandle executed**********");
        return true;
    }

    /**
     * 在controller执行之后的DispatcherServlet之后执行
     * */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("************TestInterceptor2 postHandle executed**********");

    }

    /**
     * 在页面渲染完成返回给客户端之前执行
     * */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("************TestInterceptor2 afterCompletion executed**********");

    }
}
