package com.dengjingxu.test;

import com.dengjingxu.factory.BeanFactory;
import com.dengjingxu.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: dengjingxu
 * @date: 2020/4/25
 * @description: com.dengjingxu.test
 * @version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")
public class AccountServiceTest {

    @Autowired
    @Qualifier("proxyAccountService")
    private IAccountService accountService1;

    @Test
    public void testTransfer(){
        accountService1.transacteMoney("zhangsang","lisi",200.0);
    }

}
