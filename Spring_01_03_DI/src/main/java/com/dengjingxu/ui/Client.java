package com.dengjingxu.ui;

import com.dengjingxu.service.SaveAccount;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: com.dengjingxu
 * @date: 2020/4/24
 * @description: com.com.dengjingxu.ui
 * @version: 1.0
 */
public class Client {

    public static void main(String[] args) {
        //获取核心容器对象
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
        SaveAccount saveAccount = (SaveAccount) applicationContext.getBean("saveAccount");
        System.out.println(saveAccount);
        saveAccount.saveAccount("001");

    }
}
