package com.config;

/**
 * @author: dengjingxu
 * @date: 2020/4/26
 * @description: com.config
 * @version: 1.0
 */

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import sun.net.idn.StringPrep;

import javax.sql.DataSource;

/**
 * 和spring连接数据库相关的配置类
 */
/*@Configuration*/
public class JdbcConfig {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Bean("runner")
    @Scope("prototype")
    public QueryRunner createQueryRunner(@Qualifier("ds1") DataSource dataSource){
        return new QueryRunner(dataSource);
    }

    @Bean("ds1")
    public DataSource createDataSource(){
        ComboPooledDataSource comboPooledDataSource=null;
        try {
            comboPooledDataSource=new ComboPooledDataSource();
            comboPooledDataSource.setDriverClass(driver);
            comboPooledDataSource.setJdbcUrl(url);
            comboPooledDataSource.setUser(username);
            comboPooledDataSource.setPassword(password);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        return comboPooledDataSource;
    }

    @Bean("ds2")
    public DataSource createDataSource2(){
        ComboPooledDataSource comboPooledDataSource=null;
        try {
            comboPooledDataSource=new ComboPooledDataSource();
            comboPooledDataSource.setDriverClass(driver);
            comboPooledDataSource.setJdbcUrl(url);
            comboPooledDataSource.setUser(username);
            comboPooledDataSource.setPassword(password);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        return comboPooledDataSource;
    }
}