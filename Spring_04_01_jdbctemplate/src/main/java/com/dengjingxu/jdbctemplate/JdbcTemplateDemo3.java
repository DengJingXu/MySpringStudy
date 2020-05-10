package com.dengjingxu.jdbctemplate;

import com.dengjingxu.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author: dengjingxu
 * @date: 2020/4/30
 * @description: com.dengjingxu.jdbctemplate
 * @version: 1.0
 */
public class JdbcTemplateDemo3 {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");

        JdbcTemplate jdbcTemplate=context.getBean("jdbcTemplate",JdbcTemplate.class);

        //增
//        jdbcTemplate.update("insert into account (account_name,account_money) values (?,?)","ddd",1200.0);
        //删
//        jdbcTemplate.update("delete from account where account_id=?",8);
        //改
//        jdbcTemplate.update("update account set account_money=? where account_id=?",2000.0,7);
        //查所有
//        List<Account> accouts = jdbcTemplate.query("select *from account where account_money>?", new AccountRowMapper(), 1000);
//        accouts.stream().forEach(account -> {
 //           System.out.println(account);
//        });
 //       List<Account> accouts = jdbcTemplate.query("select *from account where account_money>?", new BeanPropertyRowMapper<Account>(Account.class), 1000);
 //       accouts.stream().forEach(account -> {
 //           System.out.println(account);
//        });
        //查询返回一行或一列或（聚合函数但不加group by 子句）
        Long n = jdbcTemplate.queryForObject("select count(*) from account where account_money>?", Long.class, 1000);
        System.out.println(n);

    }
}

class AccountRowMapper implements RowMapper<Account> {

    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account=new Account();
        account.setAccount_id(resultSet.getInt("account_id"));
        account.setAccount_name(resultSet.getString("account_name"));
        account.setAccount_money(resultSet.getDouble("account_money"));
        return account;
    }
}