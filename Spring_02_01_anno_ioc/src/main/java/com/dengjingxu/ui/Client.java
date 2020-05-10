package com.dengjingxu.ui;

import com.dengjingxu.dao.ISaveAccountDao;
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
        ISaveAccountDao iSaveAccountDao = (ISaveAccountDao) applicationContext.getBean("iSaveAccountDao");
        SaveAccount saveAccount= (SaveAccount) applicationContext.getBean("saveAccount");
        System.out.println(iSaveAccountDao);
        System.out.println(saveAccount);
        iSaveAccountDao.saveAccountDao();

    }
}
