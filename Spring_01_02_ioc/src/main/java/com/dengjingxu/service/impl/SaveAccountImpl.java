package com.dengjingxu.service.impl;


import com.dengjingxu.service.SaveAccount;

/**
 * @author: dengjingxu
 * @date: 2020/4/24
 * @description: com.dengjingxu.service.impl
 * @version: 1.0
 */
public class SaveAccountImpl implements SaveAccount {

    public void saveAccount(String account) {
        System.out.println("saveAccount");
    }

    public void init(){
        System.out.println("对象初始化....");
    }
    public void dest(){
        System.out.println("对象被销毁....");
    }
}
