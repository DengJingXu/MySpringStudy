package com.dengjingxu.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author: dengjingxu
 * @date: 2020/4/30
 * @description: com.dengjingxu.jdbctemplate
 * @version: 1.0
 */
public class JdbcTemplateDemo1 {
    public static void main(String[] args) {
        //spring内置数据源DriverManagerDataSource
        DriverManagerDataSource source=new DriverManagerDataSource();
        source.setDriverClassName("com.mysql.cj.jdbc.Driver");
        source.setUrl("jdbc:mysql://localhost:3306/my_study?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true ");
        source.setUsername("root");
        source.setPassword("root");

        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(source);
        jdbcTemplate.execute("insert into account(account_name,account_money) values ('zhaoliu',1000.0)");
    }
}
