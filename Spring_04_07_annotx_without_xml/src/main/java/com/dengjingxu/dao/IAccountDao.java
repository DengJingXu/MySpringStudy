package com.dengjingxu.dao;

import com.dengjingxu.domain.Account;

/**
 * @author: com.com.com.com.dengjingxu
 * @date: 2020/4/30
 * @description: com.com.com.com.com.dengjingxu.dao
 * @version: 1.0
 */
public interface IAccountDao {

     Account getAccountById(int accountId);
     Account getAccountByName(String accountName);
     void updateAccount(Account account);
}
