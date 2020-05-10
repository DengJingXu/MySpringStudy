package com.dengjingxu.dao;

import com.dengjingxu.domain.Student;
import org.springframework.stereotype.Repository;

/**
 * @author: dengjingxu
 * @date: 2020/5/6
 * @description: com.dengjingxu.dao
 * @version: 1.0
 */
public interface LoginMapper {
    Student findStuentByNameByPassword(String name, String password);
}
