package com.dengjingxu.ui;

import com.dengjingxu.factory.BeansFactory;
import com.dengjingxu.service.SaveAccount;
import com.dengjingxu.service.impl.SaveAccountImpl;

/**
 * @author: dengjingxu
 * @date: 2020/4/24
 * @description: com.dengjingxu.ui
 * @version: 1.0
 */
public class Client {

    public static void main(String[] args) {
        /*  private  SaveAccount saveAccount=new SaveAccountImpl();*/
        /*多例：SaveAccount saveAccount= (SaveAccount) BeansFactory.getBean("saveAccount");*/
        //单例
        for(int i=0;i<5;i++){
            SaveAccount saveAccount= (SaveAccount) BeansFactory.getBean("saveAccount");
            System.out.println(saveAccount);
        }
    }
}
