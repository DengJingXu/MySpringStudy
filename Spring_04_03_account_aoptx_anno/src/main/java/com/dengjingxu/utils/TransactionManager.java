package com.dengjingxu.utils;

/**
 * @author: com.dengjingxu
 * @date: 2020/4/29
 * @description: com.com.dengjingxu.utils
 * @version: 1.0
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * 和事务管理相关的工具类，它包含了，开启，提交，回滚事务和释放连接
 */
@Component("transactionManager")
@Aspect
public class TransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* com.dengjingxu.service.imp.*.*(..))")
    private void pt1(){};
    /**
     * 开启事务
     */
//    @Before("pt1()")
    public void beginTransaction(){
        try {
            System.out.println("前置通知。。。。");
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 提交事务
     */
//    @AfterReturning("pt1()")
    public void commit(){
        try {
            System.out.println("后置通知。。。。");
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 回滚事务
     */
 //   @AfterThrowing("pt1()")
    public void rollback(){
        try {
            System.out.println("异常通知。。。。");
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 释放连接
     */
 //   @After("pt1()")
    public void release(){
        try {
            System.out.println("最终通知。。。。");
            connectionUtils.getThreadConnection().close();
            connectionUtils.removeThreadConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 以上注解最终通知会先于后置通知和异常通知执行，故会生产一些问题，所以我们一般用环绕通知
     */
    @Around("pt1()")
    public Object aroundAdvice(ProceedingJoinPoint pjp){
        Object rtValue=null;
        try {
            //获取参数
            Object[]args=pjp.getArgs();
            //开启事务
            this.beginTransaction();
            //执行操作
            rtValue = pjp.proceed(args);
            //提交事务
            this.commit();
            //返回结果
            return rtValue;
        } catch (Throwable throwable) {
            //回滚事务
            this.rollback();
            throw new RuntimeException(throwable);
        }finally {
            //释放连接
            this.release();
        }
    }
}
