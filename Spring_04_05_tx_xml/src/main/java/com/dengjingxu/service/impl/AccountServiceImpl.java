package com.dengjingxu.service.impl;

import com.dengjingxu.dao.IAccountDao;
import com.dengjingxu.domain.Account;
import com.dengjingxu.service.IAccountService;

/**
 * @author: com.dengjingxu
 * @date: 2020/5/1
 * @description: com.com.dengjingxu.service.impl
 * @version: 1.0
 */

public class AccountServiceImpl implements IAccountService {


    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Account getAccountById(Integer accountId) {
        return accountDao.getAccountById(accountId);
    }

    @Override
    public void transfer(String sourceName, String targetName, Double money) {
        Account account1=accountDao.getAccountByName(sourceName);
        Account account2=accountDao.getAccountByName(targetName);
        account1.setAccount_money(account1.getAccount_money()-money);
        account2.setAccount_money(account2.getAccount_money()+money);
        accountDao.updateAccount(account1);
  //      int i=1/0;
        accountDao.updateAccount(account2);
    }
}
