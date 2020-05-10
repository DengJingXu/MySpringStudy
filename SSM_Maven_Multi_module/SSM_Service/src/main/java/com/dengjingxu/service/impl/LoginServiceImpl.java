package com.dengjingxu.service.impl;

import com.dengjingxu.dao.LoginMapper;
import com.dengjingxu.domain.Student;
import com.dengjingxu.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: dengjingxu
 * @date: 2020/5/6
 * @description: com.dengjingxu.service.impl
 * @version: 1.0
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;
    @Override
    public Student findStuentByNameByPassword(String name, String password) {
        return loginMapper.findStuentByNameByPassword(name,password);
    }
}
