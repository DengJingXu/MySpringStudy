package com.dengjingxu.utils;

/**
 * @author: com.dengjingxu
 * @date: 2020/4/30
 * @description: com.com.dengjingxu.utils
 * @version: 1.0
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 用于记录日志的工具类，它里面提供了公共代码
 */
@Component("logger")
@Aspect //标识该类为一个切面类
public class Logger {

    @Pointcut("execution(* com.dengjingxu.service.Impl.*.*(..))")
    public void pt1(){};
    /**
     * 前置通知
     */
  //  @Before("pt1()")
    public void beforePrintLog(){
        System.out.println("Logger类中的beforePrintLog方法开始记录日志。。。。。。");
    }

    /**
     * 后置通知
     */
 //   @AfterReturning("pt1()")
    public void afterReturningPrintLog(){
        System.out.println("Logger类中的afterReturningPrintLog方法开始记录日志。。。。。。");
    }

    /**
     * 异常通知
     */
  //  @AfterThrowing("pt1()")
    public void afterThrowingPrintLog(){
        System.out.println("Logger类中的afterThrowingPrintLog方法开始记录日志。。。。。。");
    }

    /**
     * 最终通知
     */
   // @After("pt1()")
    public void afterPrintLog(){
        System.out.println("Logger类中的afterPrintLog方法开始记录日志。。。。。。");
    }

    /**
     * 环绕通知
     * 问题：
     *      当我们配置了环绕通知之后，切入点没有执行，而通知方法执行了。
     * 分析：
     *      通过对比JDK动态代理中的环绕通知代码，发现动态代理的环绕通知有明确的切入点方法调用，而我们的代码没有。
     * 解决：
     *      Spring框架为我们提供了一个接口：ProceedingJoinPoint。该接口有一个方法proceed（），此方法就相当于明确调用切入点方法。
     *      该接口可以作为环绕通知的方法参数，在程序执行时，spring框架会为我们提供该方法的实现类供我们使用。
     *
     * Spring中的环绕通知：
     *      他是spring框架为我们提供的一种可以在代码中手动控制增强方法合时执行的方式。
     * @throws Throwable
     * @return
     */
    @Around("pt1()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp) throws Throwable {
        Object rtValue=null;
        try {
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志。。。。。前置。");
            Object[]args=pjp.getArgs();
             rtValue= pjp.proceed(args);
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志。。。。。后置。");
        } catch (Throwable throwable) {
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志。。。。。异常。");
            throwable.printStackTrace();
        } finally {
            System.out.println("Logger类中的aroundPrintLog方法开始记录日志。。。。。最终。");
        }
        return rtValue;
    }
}
