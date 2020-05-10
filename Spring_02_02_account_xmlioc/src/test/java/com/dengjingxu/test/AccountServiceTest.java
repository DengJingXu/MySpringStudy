package com.dengjingxu.test;

import com.dengjingxu.domint.Account;
import com.dengjingxu.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author: dengjingxu
 * @date: 2020/4/25
 * @description: com.dengjingxu.test
 * @version: 1.0
 */
public class AccountServiceTest {

    @Test
    public void testGetAllAccount(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
        IAccountService iAccountService= (IAccountService) applicationContext.getBean("accountService");
        List<Account> allAccount = iAccountService.getAllAccount();
        allAccount.stream().forEach(account->{
            System.out.println(account);
        });

    }
    @Test
    public void testGetAccountById(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
        IAccountService iAccountService= (IAccountService) applicationContext.getBean("accountService");
        Account accountById = iAccountService.getAccountById(3);
        System.out.println(accountById);
    }
    @Test
    public void testSaveAccount(){
        Account account=new Account();
        account.setAccount_name("xiaohuan");
        account.setAccount_money(4444.1);
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
        IAccountService iAccountService= (IAccountService) applicationContext.getBean("accountService");
        iAccountService.saveAccount(account);
    }
    @Test
    public void testUpdateAccount(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
        IAccountService iAccountService= (IAccountService) applicationContext.getBean("accountService");
        iAccountService.updateAccount("xiaohuan222",3333.3,5);
    }
    @Test
    public void testDeleteAccount(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
        IAccountService iAccountService= (IAccountService) applicationContext.getBean("accountService");
        iAccountService.deleteAccount(5);
    }

}
