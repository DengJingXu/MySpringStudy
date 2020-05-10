package com.dengjingxu.domain;

import java.io.Serializable;

/**
 * @author: dengjingxu
 * @date: 2020/5/4
 * @description: com.dengjingxu.domain
 * @version: 1.0
 */
public class User implements Serializable {
    private String userName;
    private String password;
    private Integer age;

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
