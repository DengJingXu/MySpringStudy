package com.dengjingxu.controller;

import com.dengjingxu.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

/**
 * @author: dengjingxu
 * @date: 2020/5/4
 * @description: com.dengjingxu.controller
 * @version: 1.0
 */
@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping("toString")
    public String toSuccess(Model model){
        User user=new User();
        user.setUserName("邓爽");
        user.setPassword("6666");
        user.setAge(20);
        model.addAttribute(user);
        return "success";
    }
    /**
     * 带注解@RequestMapping的方法的返回值解释：
     *          返回值为String：
     *                  则默认转发到以返回值为名称的页面（自动使用视图解析器加前缀和后缀），
     *                  返回值前可以加forward:（视图解析器不再解析，需再在后面加上文件所在目录）控制转发
     *                  返回值前可以加redirect：（重定向不能访问WEB-INF下的文件，但spring会自己在后面加项目名，所以只需redirect：/xxxx.jsp）控制重定向
     *          返回值为void：
     *                  则默认转发到注解@RequestMapping的value参数值，可用原生request和response对象做为参自定义转发或重定向到别的请求或页面，
     *                  但是重定向得用request.getContextPath()加上项目名称
     *          返回值为ModelAndView：
     *                  具备Model的作用，同时可以控制转发或者重定向的目的地
     *
     *  注解RequestBody（返回json数据）：
     *          前端传过来的请求体可以用注解@RequestBody获取，当传过来的是json数据格式，
     *          要自动类型转换json数据格式到javabean或者其他java数据类型中，
     *          或者要返回Java数据格式用到注解@ResponseBody后自动将返回java数据类型转化为json数据格式
     *          需要导入json相关的包（jackson-databind，jackson-core，jackson-annotations）
     *
     */
    @RequestMapping("toVoid")
    public void toSuccess1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("回写成功");
        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
       // response.sendRedirect(request.getContextPath()+"/index.jsp");

    }
    @RequestMapping("toStringForward")
    public String toSuccess2(Model model){
        User user=new User();
        user.setUserName("邓爽");
        user.setPassword("6666");
        user.setAge(20);
        model.addAttribute(user);
        return "forward:/WEB-INF/pages/success.jsp";
        //return "redirect:/index.jsp";
    }
    @RequestMapping("toModelAndView")
    public ModelAndView toSuccess3(){
        ModelAndView mv=new ModelAndView();
        User user=new User();
        user.setUserName("邓爽");
        user.setPassword("6666");
        user.setAge(20);
        mv.addObject("user",user);
        mv.setViewName("success");
        return mv;
    }
    @RequestMapping("toAjax")
    @ResponseBody
    public User toSuccess3(@RequestBody User user){
        System.out.println(user);
        return user;
    }
}
