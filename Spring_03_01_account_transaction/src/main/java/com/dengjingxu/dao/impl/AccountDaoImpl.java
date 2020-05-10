package com.dengjingxu.dao.impl;

import com.dengjingxu.dao.IAccountDao;
import com.dengjingxu.domint.Account;
import com.dengjingxu.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author: com.dengjingxu
 * @date: 2020/4/25
 * @description: com.com.dengjingxu.dao.impl
 * @version: 1.0
 */
@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    private QueryRunner runner;
    @Autowired
    private ConnectionUtils connectionUtils;
    @Override
    public List<Account> getAllAccount() {
        try {
            Connection threadConnection = connectionUtils.getThreadConnection();
            System.out.println("当前线程："+Thread.currentThread().getName()+"  当前Connection连接："+threadConnection);
            return runner.query(threadConnection,"select * from account", new BeanListHandler<>(Account.class));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account getAccountById(int accountId) {
        try {
            Connection threadConnection = connectionUtils.getThreadConnection();
            System.out.println("当前线程："+Thread.currentThread().getName()+"  当前Connection连接："+threadConnection);
            return runner.query(threadConnection,"select * from account where account_id=?",new BeanHandler<Account>(Account.class),accountId);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public int saveAccount(Account account) {
        try {
            Connection threadConnection = connectionUtils.getThreadConnection();
            System.out.println("当前线程："+Thread.currentThread().getName()+"  当前Connection连接："+threadConnection);
            return runner.update(threadConnection,"insert into account(account_name,account_money) values(?,?)",account.getAccount_name(),account.getAccount_money());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int updateAccount(Account account) {
        try {
            Connection threadConnection = connectionUtils.getThreadConnection();
            System.out.println("当前线程："+Thread.currentThread().getName()+"  当前Connection连接："+threadConnection);
            return runner.update(threadConnection,"update account set account_name=?,account_money=? where account_id=?",account.getAccount_name(),account.getAccount_money(),account.getAccount_id());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteAccount(int accountId) {
        try {
            Connection threadConnection = connectionUtils.getThreadConnection();
            System.out.println("当前线程："+Thread.currentThread().getName()+"  当前Connection连接："+threadConnection);
            return runner.update(threadConnection,"delete from account where account_id=?",accountId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account getAccountByName(String sourceName) {
        try {
            Connection threadConnection = connectionUtils.getThreadConnection();
            System.out.println("当前线程："+Thread.currentThread().getName()+"  当前Connection连接："+threadConnection);
            List<Account> querys = runner.query(threadConnection,"select *from account where account_name=?", new BeanListHandler<Account>(Account.class), sourceName);
            if(null==querys||querys.size()==0){
                throw new RuntimeException("没有该账户");
            }
            return querys.get(0);
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
    }
}
