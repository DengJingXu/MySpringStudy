package com.dengjingxu.controller;

import com.dengjingxu.domain.Student;
import com.dengjingxu.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.rmi.StubNotFoundException;

/**
 * @author: dengjingxu
 * @date: 2020/5/7
 * @description: com.dengjingxu.controller
 * @version: 1.0
 */
@RestController
@RequestMapping("account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("transfer")
    @ResponseBody
    public String transfer(String sourceName, String username, double money, HttpServletRequest request){
        Student user = (Student) request.getSession().getAttribute("user");
        accountService.transfer(user.getStudentName(),username,money);
        return "transfer success";
    }
}
