package com.dengjingxu.controller;

import com.dengjingxu.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author: dengjingxu
 * @date: 2020/5/2
 * @description: com.dengjingxu.controller
 * @version: 1.0
 */
@Controller
@RequestMapping("mvc")
public class HelloController {


    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("Hello world");
        return "success";
    }

    /**
     * @RequestMapping注解的属性：
     *      path：value：这两个属性的作用一样，是请求的url所要匹配的值
     *      method：要求的请求方式，有RequestMethod.POST等等
     *      params：要求的要有具体的参数，或者具体的参数及参数值
     *      headers：要求请求头中必须有具体的某个或某些头信息，如accept等。。
     * @return
     */
    @RequestMapping(path = "/hello2",method = RequestMethod.GET,params ={"username=djx","password"},headers ={"accept"} )
    public String sayHello2(){
        System.out.println("Hello world");
        return "success";
    }

    /**
     * 参数绑定
     *   参数类型：
     *      基本类型和String：
     *          当方法中有与请求的带有的参数名相同的参数，则自动绑定到该方法参数中
     *      类类型:
     *          方法参数为类类型时，只要请求中带的参数名与类类型的属性set方法去掉set前缀，后首字母小写后的字符串相同时，
     *          则自动绑定到对应类类型属性
     *      集合list，set，map
     *          略微复杂，一般不用，为在前端input标签的name属性为list[i]...,map[' ']...
     *   还有其他类型可自动绑定，其涉及到类型转换器，原理是Converter类型转换器将String（请求过来的都是String类型）转成各类型以匹配
     *   如Date类型，spring自带String转yyyy/mmmm/dddd的Date类型转换器，
     *   如果想要自定义类型转换器：
     *          1.创建类继承Converter接口中的converter方法，
     *          2.在springmvc配置文件中配置类型转换器ConversionServiceFactoryBean的bean
     *             其中有属性converters,用实现了Converter接口中的converter方法的类注入，
     *          3.在<mvc:annotation-driven />中加入conversion-services属性，值为
     *            类型转换器ConversionServiceFactoryBean的bean的id
     *
     * @return
     */
    @RequestMapping(path = "/hello3")
    public String sayHello3(String username,String password){
        System.out.println("Hello world");
        System.out.println("username:"+username);
        System.out.println("password:"+password);
        return "success";
    }
    @RequestMapping(path = "/hello4")
    public String sayHello4(Account account){
        System.out.println("Hello world");
        System.out.println(account);
        return "success";
    }
    @RequestMapping(path = "/hello5")
    public String sayHello5(Date date){
        System.out.println("Hello world");
        System.out.println(date);
        return "success";
    }
    /**
     * 获取原生的sevlet的request和response对象
     */
    @RequestMapping(path = "/hello6")
    public String sayHello6(HttpServletRequest request, HttpServletResponse response){
        System.out.println("Hello world");
        System.out.println(request.getContextPath());
        return "success";
    }

    /**
     * springMVC中的ModelAndView(需要自己示例化）,Model（作为方法参数），
     *          ModelMap对象主要用于传递控制方法处理数据到结果页面，类似于request对象的setAttribute方法的作用
     *
     * 常用参数相关注解：
     *          RequestParam:
     *              使用位置：有@RequestMapping注解的方法参数前
     *              作用：要求请求中带有特定的参数，然后将请求中的特定参数绑定到方法参数上
     *          RequestBody:
     *              使用位置：有@RequestMapping注解的方法参数前
     *              作用：将请求中的请求体（post才有）绑定到方法的参数上
     *          PathVariable:
     *              使用位置：有@RequestMapping注解的方法参数前
     *              作用：要求请求url中带有特定的参数（非键值对，而是占位符/{参数}，然后将请求中的特定参数绑定到方法参数上
     *                    是支持restful风格url的标志
     *          RequestHeader:
     *              使用位置：有@RequestMapping注解的方法参数前
     *              作用：获取特定的请求头信息，如@RequestHeader("accept")
     *          CookieValue:
     *              使用位置：有@RequestMapping注解的方法参数前
     *              使用：获取特定的cookie值，绑定到方法参数上
     *
     */
    @RequestMapping(path = "/hello7")
    public String sayHello7(@RequestParam("username") String uname){
        System.out.println("Hello world");
        System.out.println(uname);
        return "success";
    }
    @RequestMapping(path = "/hello8")
    public String sayHello8(@RequestBody String body){
        System.out.println("Hello world");
        System.out.println(body);
        return "success";
    }
    @RequestMapping(path = "/hello9/{username}")
    public String sayHello9(@PathVariable(name = "username") String uname){
        System.out.println("Hello world");
        System.out.println(uname);
        return "success";
    }
    @RequestMapping(path = "/hello10")
    public String sayHello10(@CookieValue(name = "JSESSIONID") String cookie){
        System.out.println("Hello world");
        System.out.println(cookie);
        return "success";
    }
}
