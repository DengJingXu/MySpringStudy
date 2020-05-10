package com.dengjingxu.controller;

import com.dengjingxu.exception.SysException;
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
     * springmvc异常处理器：
     *          如果业务层和持久层和web层的异常抛到前端控制器DispatcherServlet,则可以自定义异常处理器处理
     *          1.编写异常类（可有可无，自定义）
     *          2.编写异常处理器类（实现HandlerExceptionResolver接口的resolveException方法）
     *          3.在springmvc配置文件中配值异常处理器类的bean
     *
     * @return
     * @throws SysException
     */
    @RequestMapping("testException")
    public String testException() throws SysException {
        System.out.println("testException（controller）执行。。。");

        try {
            int i=10/0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("除零错误");
        }
        return "success";
    }
}
