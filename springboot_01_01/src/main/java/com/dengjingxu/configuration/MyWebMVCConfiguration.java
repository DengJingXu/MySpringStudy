package com.dengjingxu.configuration;

import com.dengjingxu.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author: dengjingxu
 * @date: 2020/5/10
 * @description: com.dengjingxu.configuration
 * @version: 1.0
 */
@Configuration
public class MyWebMVCConfiguration extends WebMvcConfigurationSupport {


    @Override
    protected void addInterceptors(InterceptorRegistry registry) {  //拦截器配置
        System.out.println("拦截器配置");
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/account/**");
        super.addInterceptors(registry);
    }

    /**
     * templates文件下的页面不能直接访问，但是static文件下的可以直接访问
     * 修改原有默认进入主页，相当于新增了controller，匹配路径为/，
     * 而原本出错后会转发到路径/error。所以可在这里加上error的路径匹配
     * @param registry
     */
    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        System.out.println("修改了原有默认页");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/loginPage").setViewName("index");
        //registry.addViewController("/error").setViewName("error");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }

}
