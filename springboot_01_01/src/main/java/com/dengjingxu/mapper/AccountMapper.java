package com.dengjingxu.mapper;

import com.dengjingxu.domain.Account;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: dengjingxu
 * @date: 2020/5/6
 * @description: com.dengjingxu.dao
 * @version: 1.0
 */

@Mapper
public interface AccountMapper {

    List<Account> findAccountByName(String name);

    void saveAccount(Account account);
}
