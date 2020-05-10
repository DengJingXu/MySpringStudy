package com.dengjingxu.ui;

import com.dengjingxu.dao.Impl.SaceAccountDaoImpl;
import com.dengjingxu.dao.SaveAccountDao;
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

    /**
     * 获取spsring的Ioc核心容器，并根据id获取对象
     * ApplicationContext的三个常用实现类
     *          ClassPathXmlApplicationContext： 它可以加载类路径下的配置文件，要求配置文件必须在类路径下
     *          FileSystemApplicationContext：   它可以加载磁盘任意路径下的配置文件（有访问权限)
     *
     *          AnnotationConfigApplicationContext：    用于读取注解创建容器
     *
     * 核心接口容器的两个接口
     * ApplicationContext：   单例适用
     *          它在构建核心容器时，创建对象采取的策略是立即加载，一读取配置文件完就创建配置文件中的配置对象
     * BeanFactory：         多例适用
     *          它采用的策略是延迟加载，即什么时候根据id获取对象，什么时候才创建对象
     * @param args
     */

    public static void main(String[] args) {
        //获取核心容器对象
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
        /*ApplicationContext applicationContext1=new FileSystemXmlApplicationContext(".....");*/
        SaveAccount saveAccount = (SaveAccount) applicationContext.getBean("saveAccount");
        SaveAccountDao saveAccountDao=applicationContext.getBean("saveAccountDao", SaceAccountDaoImpl.class);
        System.out.println(saveAccount);
        System.out.println(saveAccountDao);
        System.out.println(saveAccountDao);

        Resource resource=new ClassPathResource("beans.xml");
        BeanFactory beanFactory=new XmlBeanFactory(resource);
        SaveAccount saveAccount1 = (SaveAccount) beanFactory.getBean("saveAccount");
        System.out.println(saveAccount);
    }
}
