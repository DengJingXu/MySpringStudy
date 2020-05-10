package com.dengjingxu.service;

import com.dengjingxu.domain.Account;

/**
 * @author: dengjingxu
 * @date: 2020/5/6
 * @description: com.dengjingxu.service
 * @version: 1.0
 */
public interface AccountService {

    Account findAccountByName(String name);

    void saveAccount(Account account);

    void transfer(String sourceName,String targetName,double money);
}
