package com.dengjingxu.controller;

import com.dengjingxu.domain.Student;
import com.dengjingxu.exception.MyException;
import com.dengjingxu.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: dengjingxu
 * @date: 2020/5/7
 * @description: com.dengjingxu.controller
 * @version: 1.0
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("login")
    public String login(String username, String password, HttpServletRequest request) throws MyException {
        Student student = (Student) request.getSession().getAttribute("user");
        if(null==student){
            String name=username;
            String pwd=password;
            System.out.println("登录用户名："+username+"   密码"+password);
            Student stu = loginService.findStuentByNameByPassword(name, pwd);
            if(null==stu){
                request.getSession().setAttribute("error","用户名或密码错误");
                return "redirect:index";
            }

            request.getSession().setAttribute("user",stu);
            return "transfer";
        }
        System.out.println("session获取："+student.getStudentName());
        return "transfer";
    }
}
