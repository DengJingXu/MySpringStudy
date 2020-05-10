package com.dengjingxu.dao;

import com.dengjingxu.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: dengjingxu
 * @date: 2020/5/6
 * @description: com.dengjingxu.dao
 * @version: 1.0
 */
public interface AccountMapper {

    List<Account> findAccountByName(String name);

    void saveAccount(Account account);
}
