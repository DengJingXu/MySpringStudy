package com.dengjingxu.service.imp;

import com.dengjingxu.dao.IAccountDao;
import com.dengjingxu.domint.Account;
import com.dengjingxu.service.IAccountService;
import com.dengjingxu.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: com.dengjingxu
 * @date: 2020/4/25
 * @description: com.com.dengjingxu.service.imp
 * @version: 1.0
 */

/**
 * 事务都是在业务层
 */
//@Service("accountService")
public class AccountServiceImpl_old implements IAccountService {

    @Autowired
    private IAccountDao iAccountDao;
    @Autowired
    private TransactionManager transactionManager;

    @Override
    public List<Account> getAllAccount() {
        try{
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            List<Account> allAccount = iAccountDao.getAllAccount();
            //3.提交事务
            transactionManager.commit();
            //4返回结果
            return allAccount;
        }catch (Exception e){
            //5.事务回滚
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //6.释放连接
            transactionManager.release();
        }

    }

    @Override
    public Account getAccountById(int accountId) {
        try{
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            Account accountById = iAccountDao.getAccountById(accountId);
            //3.提交事务
            transactionManager.commit();
            //4返回结果
            return accountById;
        }catch (Exception e){
            //5.事务回滚
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //6.释放连接
            transactionManager.release();
        }
    }

    @Override
    public int saveAccount(Account account) {
        try{
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            int i = iAccountDao.saveAccount(account);
            //3.提交事务
            transactionManager.commit();
            //4返回结果
            return i;
        }catch (Exception e){
            //5.事务回滚
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //6.释放连接
            transactionManager.release();
        }
    }

    @Override
    public int updateAccount(Account account) {
        try{
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            int i = iAccountDao.updateAccount(account);
            //3.提交事务
            transactionManager.commit();
            //4返回结果
            return i;
        }catch (Exception e){
            //5.事务回滚
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //6.释放连接
            transactionManager.release();
        }

    }

    @Override
    public int deleteAccount(int accountId) {
        try{
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            int i = iAccountDao.deleteAccount(accountId);
            //3.提交事务
            transactionManager.commit();
            //4返回结果
            return i;
        }catch (Exception e){
            //5.事务回滚
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //6.释放连接
            transactionManager.release();
        }
    }

    @Override
    public void transacteMoney(String sourceName, String targetName, double money) {
        try{
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
                    //查找转出账户
                    Account account1 = iAccountDao.getAccountByName(sourceName);
                    //查找转入账户
                    Account account2 = iAccountDao.getAccountByName(targetName);
                    //转出账户减钱
                    account1.setAccount_money(account1.getAccount_money()-money);
                    //转入账户加钱
                    account2.setAccount_money(account2.getAccount_money()+money);
                    //更新转出账户
                    iAccountDao.updateAccount(account1);
                    System.out.println(1/0);
                    //更新转入账户
                    iAccountDao.updateAccount(account2);
            //3.提交事务
            transactionManager.commit();
            //4返回结果
        }catch (Exception e){
            //5.事务回滚
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //6.释放连接
            transactionManager.release();
        }

    }
}
