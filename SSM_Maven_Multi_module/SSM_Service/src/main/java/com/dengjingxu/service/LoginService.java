package com.dengjingxu.service;

import com.dengjingxu.domain.Student;

/**
 * @author: dengjingxu
 * @date: 2020/5/6
 * @description: com.dengjingxu.service
 * @version: 1.0
 */
public interface LoginService {
    Student findStuentByNameByPassword(String name,String password);
}
