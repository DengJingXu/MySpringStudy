package com.dengjingxu.service.impl;

import com.dengjingxu.dao.IAccountDao;
import com.dengjingxu.domain.Account;
import com.dengjingxu.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: com.com.com.dengjingxu
 * @date: 2020/5/1
 * @description: com.com.com.com.dengjingxu.service.impl
 * @version: 1.0
 */

@Service("accountService")
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)//只读事务的配置
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    @Override
    public Account getAccountById(Integer accountId) {
        return accountDao.getAccountById(accountId);
    }

    @Transactional(propagation = Propagation.REQUIRED,readOnly =false )//只读事务的配置
    @Override
    public void transfer(String sourceName, String targetName, Double money) {
        Account account1=accountDao.getAccountByName(sourceName);
        Account account2=accountDao.getAccountByName(targetName);
        account1.setAccount_money(account1.getAccount_money()-money);
        account2.setAccount_money(account2.getAccount_money()+money);
        accountDao.updateAccount(account1);
        int i=1/0;
        accountDao.updateAccount(account2);
    }
}
