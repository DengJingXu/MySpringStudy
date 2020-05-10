package com.dengjingxu.interceptor;

import com.dengjingxu.domain.Student;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: dengjingxu
 * @date: 2020/5/9
 * @description: com.dengjingxu.interceptor
 * @version: 1.0
 */
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String contextPath = request.getRequestURI();
        System.out.println(contextPath);
        System.out.println(request.getRequestURL());
        Student student = (Student) request.getSession().getAttribute("user");
        if (null==student){
            response.sendRedirect("index.html");
            return true;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
