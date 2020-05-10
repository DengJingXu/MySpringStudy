package com.dengjingxu;

import com.dengjingxu.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: dengjingxu
 * @date: 2020/5/1
 * @description: com.dengjingxu
 * @version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class testTx {

    @Autowired
    IAccountService accountService;

    @Test
    public void testTransfer(){
        accountService.transfer("zhangsang","lisi",100.0);
    }
}
