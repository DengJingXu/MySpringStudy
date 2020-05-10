package com.dengjingxu.service.Impl;

import com.dengjingxu.service.IAccountService;
import org.springframework.stereotype.Service;

/**
 * @author: com.dengjingxu
 * @date: 2020/4/30
 * @description: com.com.dengjingxu.service.Impl
 * @version: 1.0
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    public void saveAccount() {
        System.out.println("执行了保存账户。。。。");
    }

    public void updateAccount(int i) {
        System.out.println("执行了更新账户："+i);
    }

    public int deleteAccount() {
        System.out.println("执行了删除账户。。。。");
        //int i=1/0;
        return 0;
    }
}
