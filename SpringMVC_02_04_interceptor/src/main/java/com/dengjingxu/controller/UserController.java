package com.dengjingxu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: dengjingxu
 * @date: 2020/5/5
 * @description: com.dengjingxu.controller
 * @version: 1.0
 */
@Controller
@RequestMapping("user")
public class UserController {


    /**
     * springmvc拦截器：
     *      与filter作用相似，不一样的是，拦截器不拦截静态资源，只拦截controller方法
     *      使用：
     *           1.编写拦截器类实现HandlerInterceptor接口
     *           2.重写接口中的方法
     *           3.springmvc配置文件中配置拦截器（mvc:interceptors）
     * @return
     */
    @RequestMapping("testInterceptor")
    public String testInterceptor() {
        System.out.println("interceptorController执行。。。");
        return "success";
    }
}
