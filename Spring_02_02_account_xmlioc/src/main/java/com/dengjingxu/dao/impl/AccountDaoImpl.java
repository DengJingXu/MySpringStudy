package com.dengjingxu.dao.impl;

import com.dengjingxu.dao.IAccountDao;
import com.dengjingxu.domint.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: dengjingxu
 * @date: 2020/4/25
 * @description: com.dengjingxu.dao.impl
 * @version: 1.0
 */
@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    private QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    @Override
    public List<Account> getAllAccount() {
        try {
            return runner.query("select * from account", new BeanListHandler<>(Account.class));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account getAccountById(int accountId) {
        try {
            return runner.query("select * from account where account_id=?",new BeanHandler<Account>(Account.class),accountId);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public int saveAccount(Account account) {
        try {
            return runner.update("insert into account(account_name,account_money) values(?,?)",account.getAccount_name(),account.getAccount_money());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int updateAccount(String accountName, double accountMoney, int accountId) {
        try {
            return runner.update("update account set account_name=?,account_money=? where account_id=?",accountName,accountMoney,accountId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteAccount(int accountId) {
        try {
            return runner.update("delete from account where account_id=?",accountId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
