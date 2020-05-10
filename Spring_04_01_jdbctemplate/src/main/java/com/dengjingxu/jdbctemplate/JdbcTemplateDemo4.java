package com.dengjingxu.jdbctemplate;

import com.dengjingxu.dao.IAccountDao;
import com.dengjingxu.dao.impl.AccountDaoImpl;
import com.dengjingxu.dao.impl.AccountDaoImpl2;
import com.dengjingxu.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author: dengjingxu
 * @date: 2020/4/30
 * @description: com.dengjingxu.jdbctemplate
 * @version: 1.0
 */
public class JdbcTemplateDemo4 {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("bean.xml");

        IAccountDao accountDao=context.getBean("accountDao", AccountDaoImpl2.class);
        Account accountById = accountDao.getAccountById(7);
        System.out.println(accountById);
        Account lisi = accountDao.getAccountByName("lisi");
        System.out.println(lisi);
        Account account=new Account();
        account.setAccount_id(7);
        account.setAccount_name("aaa");
        account.setAccount_money(2000.0);
        accountDao.updateAccount(account);

    }
}
