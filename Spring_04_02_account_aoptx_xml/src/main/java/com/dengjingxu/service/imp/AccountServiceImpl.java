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
public class AccountServiceImpl implements IAccountService {


    private IAccountDao iAccountDao;

    public void setiAccountDao(IAccountDao iAccountDao) {
        this.iAccountDao = iAccountDao;
    }

    @Override
    public List<Account> getAllAccount() {
            List<Account> allAccount = iAccountDao.getAllAccount();
            return allAccount;
    }

    @Override
    public Account getAccountById(int accountId) {
            Account accountById = iAccountDao.getAccountById(accountId);
            return accountById;
    }

    @Override
    public int saveAccount(Account account) {
            int i = iAccountDao.saveAccount(account);
            return i;
    }

    @Override
    public int updateAccount(Account account) {
            int i = iAccountDao.updateAccount(account);
            return i;
    }

    @Override
    public int deleteAccount(int accountId) {
            int i = iAccountDao.deleteAccount(accountId);
            return i;
    }

    @Override
    public void transacteMoney(String sourceName, String targetName, double money) {
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
                   // System.out.println(1/0);
                    //更新转入账户
                    iAccountDao.updateAccount(account2);

    }
}
