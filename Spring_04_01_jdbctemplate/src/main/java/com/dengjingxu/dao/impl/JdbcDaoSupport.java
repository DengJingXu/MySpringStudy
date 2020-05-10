package com.dengjingxu.dao.impl;

/**
 * @author: dengjingxu
 * @date: 2020/4/30
 * @description: com.dengjingxu.dao.impl
 * @version: 1.0
 */

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * 此类抽取dao中的重复代码，
 * spring-jdbc也有这样的类，所以dao实现类只要继承spring-jdbc中的JdbcDaoSupport，就不需要在daoimpl层写这部分代码
 *如果使用注解适合用直接注入，而不用继承
 * 如果使用xml配置适合用继承，而不用注解注入JdbcTemplate
public class JdbcDaoSupport {

    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setDataSource(DataSource dataSource) {
        if(null==jdbcTemplate){
            jdbcTemplate= createDataSource(dataSource);
        }
    }

    public JdbcTemplate createDataSource(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
 */