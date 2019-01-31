/**
 * Copyright (C): 长安新生(深圳)金融投资有限公司
 * FileName: TestFilter1
 * Author:   xiexing
 * Date:     2018/12/26 13:32
 * Description: 过滤器测试类1
 */
package com.xiexing.filter;

import javax.servlet.*;
import java.io.IOException;

public class TestFilter2 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 在DispatcherServlet之前执行
        System.out.println("############TestFilter2 doFilterInternal executed############");
        filterChain.doFilter(servletRequest, servletResponse);
        // 在视图页面返回给客户端之前执行，但是执行顺序在Interceptor之后
        System.out.println("############TestFilter2 doFilter after############");
    }

    @Override
    public void destroy() {
    }
}
