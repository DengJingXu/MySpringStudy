package com.dengjingxu.dao.impl;

import com.dengjingxu.dao.IAccountDao;
import com.dengjingxu.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: com.com.com.com.dengjingxu
 * @date: 2020/4/30
 * @description: com.com.com.com.com.dengjingxu.dao.impl
 * @version: 1.0
 */
@Repository("accountDao")
public class AccountDaoImpl  implements IAccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Account getAccountById(int accountId) {
        List<Account> accounts = jdbcTemplate.query("select * from account where account_id=?", new BeanPropertyRowMapper<Account>(Account.class), accountId);
        return accounts.isEmpty()?null:accounts.get(0);
    }

    @Override
    public Account getAccountByName(String accountName) {
        List<Account> accounts = jdbcTemplate.query("select * from account where account_name=?", new BeanPropertyRowMapper<Account>(Account.class), accountName);
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
