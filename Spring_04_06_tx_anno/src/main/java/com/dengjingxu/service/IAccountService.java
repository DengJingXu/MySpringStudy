package com.dengjingxu.service;

/**
 * @author: com.com.dengjingxu
 * @date: 2020/5/1
 * @description: com.com.com.dengjingxu.service
 * @version: 1.0
 */

import com.dengjingxu.domain.Account;

/**
 * 账户业务层接口
 */
public interface IAccountService {

    Account getAccountById(Integer accountId);
    void transfer(String sourceName, String targetName, Double money);
}
