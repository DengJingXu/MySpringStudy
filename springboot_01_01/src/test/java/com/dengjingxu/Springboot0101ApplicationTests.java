package com.dengjingxu;

import com.dengjingxu.domain.Account;
import com.dengjingxu.service.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Springboot0101Application.class)
class Springboot0101ApplicationTests {

    @Autowired
    private AccountService accountService;

    @Test
    void contextLoads() {
        Account lisi = accountService.findAccountByName("lisi");
        System.out.println(lisi);
    }

}
