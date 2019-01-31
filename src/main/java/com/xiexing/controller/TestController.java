/**
 * Copyright (C): 长安新生(深圳)金融投资有限公司
 * FileName: TestController
 * Author:   xiexing
 * Date:     2018/12/26 14:20
 * Description: 拦截器与过滤器测试
 */
package com.xiexing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    @RequestMapping("/test.html")
    public ModelAndView handleRequest() {
        System.out.println("---------TestController executed--------");
        return new ModelAndView("test");
    }

}
