package com.dengjingxu.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author: dengjingxu
 * @date: 2020/4/30
 * @description: com.dengjingxu.jdbctemplate
 * @version: 1.0
 */
public class JdbcTemplateDemo2 {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");

        JdbcTemplate jdbcTemplate=context.getBean("jdbcTemplate",JdbcTemplate.class);

        jdbcTemplate.execute("insert into account(account_name,account_money) values ('zhaoliu2',1000.0)");
    }
}
