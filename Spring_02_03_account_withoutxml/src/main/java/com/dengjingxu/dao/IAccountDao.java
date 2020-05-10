package com.dengjingxu.dao;

import com.dengjingxu.domint.Account;

import java.util.List;

/**
 * @author: com.dengjingxu
 * @date: 2020/4/25
 * @description: com.com.dengjingxu.dao
 * @version: 1.0
 */
public interface IAccountDao {
    /**
     * 获取所有账户
     * @return
     */
    List<Account> getAllAccount();

    /**
     * 获取特定用户
     * @param accountId
     * @return
     */
    Account getAccountById(int accountId);

    /**
     * 新增账户
     * @param account
     * @return
     */
    int saveAccount(Account account);

    /**
     * 更新账户
     * @param accountName
     * @param accountMoney
     * @param accountId
     * @return
     */
    int updateAccount(String accountName, double accountMoney, int accountId);

    /**
     * 删除账户
     * @param accountId
     * @return
     */
    int deleteAccount(int accountId);
}
