package com.dengjingxu.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author: dengjingxu
 * @date: 2020/4/29
 * @description: com.dengjingxu.utils
 * @version: 1.0
 */

/**
 * 当前线程和Connection对象绑定和解绑
 */
@Component("connectionUtils")
public class ConnectionUtils {
    private ThreadLocal<Connection> tl=new ThreadLocal<>();

    @Autowired
    private DataSource dataSource;

    /**
     * 当前线程于一个连接绑定
     * @return
     */
    public Connection getThreadConnection(){
        try {
                //从ThreadLocal上获取
                Connection con=tl.get();
                //判断是否当前线程有连接
                if(null==con){
                    //从数据源获取一个连接并存入ThreadLocal
                    con=dataSource.getConnection();
                    tl.set(con);
                }
                //返回当前线程上的连接
                return con;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 当前线程与连接解绑
     */
    public void removeThreadConnection(){
        tl.remove();
    }
}
