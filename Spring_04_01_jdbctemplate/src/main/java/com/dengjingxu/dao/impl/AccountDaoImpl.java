package com.dengjingxu.dao.impl;

import com.dengjingxu.dao.IAccountDao;
import com.dengjingxu.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author: dengjingxu
 * @date: 2020/4/30
 * @description: com.dengjingxu.dao.impl
 * @version: 1.0
 */
public class AccountDaoImpl implements IAccountDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Account getAccountById(int accountId) {
        List<Account> accounts = jdbcTemplate.query("select * from account where account_id=?", new BeanPropertyRowMapper<>(Account.class), 7);
        return accounts.isEmpty()?null:accounts.get(0);
    }

    @Override
    public Account getAccountByName(String accountName) {
        List<Account> accounts = jdbcTemplate.query("select * from account where account_name=?", new BeanPropertyRowMapper<>(Account.class), "lisi");
        if(accounts.isEmpty()){
            return null;
        }
        if(accounts.size()>1){
            throw new RuntimeException("结果集大于1个");
        }
        return accounts.get(0);
    }

    @Override
    public void updateAccount(Account account) {
         jdbcTemplate.update("update account set account_name=?,account_money=? where account_id=?",account.getAccount_name(),account.getAccount_money(),account.getAccount_id());
    }
}
