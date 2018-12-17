/**
 * Copyright (C): 长安新生(深圳)金融投资有限公司
 * FileName: EncodingFilter
 * Author:   xiexing
 * Date:     2018/12/17 17:13
 * Description:
 */
package com.xiexing.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EncodingFilter implements Filter {
    private String encoding = "UTF-8";

    @Override
    public void init(FilterConfig config) {
        System.out.println("过滤器初始化了");
        encoding = config.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        request.setCharacterEncoding(encoding);
        response.setContentType("text/html;charset=" + encoding);
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("过滤器被销毁了");
    }
}