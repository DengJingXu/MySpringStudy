package com.dengjingxu.utils;

/**
 * @author: dengjingxu
 * @date: 2020/4/29
 * @description: com.dengjingxu.utils
 * @version: 1.0
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * 和事务管理相关的工具类，它包含了，开启，提交，回滚事务和释放连接
 */
@Component("transactionManager")
public class TransactionManager {
    @Autowired
    private ConnectionUtils connectionUtils;
    /**
     * 开启事务
     */
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
    public void rollback(){
        try {
            System.out.println("异常通知。。。。");
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }/**
     * 释放连接
     */
    public void release(){
        try {
            System.out.println("最终通知。。。。");
            connectionUtils.getThreadConnection().close();
            connectionUtils.removeThreadConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
