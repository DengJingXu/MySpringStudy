package com.dengjingxu.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: dengjingxu
 * @date: 2020/5/9
 * @description: com.dengjingxu.exception
 * @version: 1.0
 */
public class MyExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        MyException myException=null;
        if(e instanceof MyException){
            myException=(MyException)e;
        }else{
            myException=new MyException("非自定义异常");
        }
        ModelAndView mv=new ModelAndView();
        mv.addObject("error",e.getMessage());
        mv.setViewName("error");
        return mv;
    }
}
