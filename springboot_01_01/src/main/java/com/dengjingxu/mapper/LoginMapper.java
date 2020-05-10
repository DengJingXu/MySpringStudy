package com.dengjingxu.mapper;

import com.dengjingxu.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author: dengjingxu
 * @date: 2020/5/6
 * @description: com.dengjingxu.dao
 * @version: 1.0
 */
@Mapper
public interface LoginMapper {
    Student findStuentByNameByPassword(String name, String password);
}
