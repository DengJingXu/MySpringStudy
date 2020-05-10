package com.dengjingxu.service.imp;

import com.dengjingxu.dao.IAccountDao;
import com.dengjingxu.domint.Account;
import com.dengjingxu.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: com.dengjingxu
 * @date: 2020/4/25
 * @description: com.com.dengjingxu.service.imp
 * @version: 1.0
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao iAccountDao;

   /* public void setiAccountDao(IAccountDao iAccountDao) {
        this.iAccountDao = iAccountDao;
    }*/

    @Override
    public List<Account> getAllAccount() {
        return iAccountDao.getAllAccount();
    }

    @Override
    public Account getAccountById(int accountId) {
        return iAccountDao.getAccountById(accountId);
    }

    @Override
    public int saveAccount(Account account) {
        return iAccountDao.saveAccount(account);
    }

    @Override
    public int updateAccount(String accountName, double accountMoney, int accountId) {
        return iAccountDao.updateAccount(accountName,accountMoney,accountId);
    }

    @Override
    public int deleteAccount(int accountId) {
        return iAccountDao.deleteAccount(accountId);
    }
}
