package com.dengjingxu.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: dengjingxu
 * @date: 2020/5/5
 * @description: com.dengjingxu.exception
 * @version: 1.0
 */
public class SysExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //获取异常对象
        SysException exception=null;
        if(e instanceof  SysException){
            exception=(SysException)e;
        }else{
            exception=new SysException("系统正在维护");
        }
        ModelAndView mv=new ModelAndView();
        mv.addObject("errorMsg",e.getMessage());
        mv.setViewName("error");
        return mv;
    }
}
