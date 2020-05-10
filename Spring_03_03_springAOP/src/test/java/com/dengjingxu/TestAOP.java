package com.dengjingxu;

import com.dengjingxu.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: dengjingxu
 * @date: 2020/4/30
 * @description: com.dengjingxu
 * @version: 1.0
 */
public class TestAOP {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService= (IAccountService) applicationContext.getBean("accountService");
        accountService.saveAccount();
        accountService.updateAccount(3);
        accountService.deleteAccount();
    }
}
