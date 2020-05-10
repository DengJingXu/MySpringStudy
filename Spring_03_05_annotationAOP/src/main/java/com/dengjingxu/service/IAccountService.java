package com.dengjingxu.service;

/**
 * @author: com.dengjingxu
 * @date: 2020/4/30
 * @description: com.com.dengjingxu.service
 * @version: 1.0
 */
public interface IAccountService {
    /**
     * 模拟保存账户
     */
    void saveAccount();

    /**
     * 模拟更新账户
     * @param i
     */
    void updateAccount(int i);

    /**
     * 模拟删除账户
     * @return
     */
    int deleteAccount();
}
