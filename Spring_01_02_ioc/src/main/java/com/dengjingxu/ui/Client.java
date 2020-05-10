package com.dengjingxu.ui;

import com.dengjingxu.service.SaveAccount;
import com.dengjingxu.service.impl.SaveAccountImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author: dengjingxu
 * @date: 2020/4/24
 * @description: com.dengjingxu.ui
 * @version: 1.0
 */
public class Client {

    public static void main(String[] args) {
        //获取核心容器对象
       /* ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");*/
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
        SaveAccount saveAccount = (SaveAccount) classPathXmlApplicationContext.getBean("saveAccount");
        System.out.println(saveAccount);
        classPathXmlApplicationContext.close();
    }
}
