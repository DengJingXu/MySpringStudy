package com.dengjingxu.service.impl;

import com.dengjingxu.domain.Account;
import com.dengjingxu.mapper.AccountMapper;
import com.dengjingxu.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: dengjingxu
 * @date: 2020/5/6
 * @description: com.dengjingxu.service.impl
 * @version: 1.0
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Account findAccountByName(String name) {
        List<Account> accountByName = accountMapper.findAccountByName(name);
        if(null==accountByName||accountByName.size()==0){
            throw new RuntimeException("不存在名为"+name+"的用户");
        }
        if(accountByName.size()>1){
            throw new RuntimeException("存在多个名为"+name+"的用户");
        }
        return accountByName.get(0);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveAccount(Account account) {
        accountMapper.saveAccount(account);
    }

    @Transactional(rollbackFor ={Exception.class} )
    @Override
    public void transfer(String sourceName, String targetName, double money) {
        Account accountSource = findAccountByName(sourceName);
        Account accountTarget = findAccountByName(targetName);
        accountSource.setAccountMoney(accountSource.getAccountMoney()-money);
        accountTarget.setAccountMoney(accountTarget.getAccountMoney()+money);
        saveAccount(accountSource);
        int i=1/0;
        saveAccount(accountTarget);
    }
}
