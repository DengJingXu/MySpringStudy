package com.dengjingxu.domain;

import java.io.Serializable;

/**
 * @author: dengjingxu
 * @date: 2020/5/2
 * @description: com.dengjingxu.domain
 * @version: 1.0
 */
public class User implements Serializable {
    private String userName;
    private Integer userAge;

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userAge=" + userAge +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

   /* public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }*/
}
