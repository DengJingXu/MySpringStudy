package com.dengjingxu.domain;

import java.io.Serializable;

/**
 * @author: dengjingxu
 * @date: 2020/5/2
 * @description: com.dengjingxu.domain
 * @version: 1.0
 */
public class Account implements Serializable {
    private String accountNam;
    private String accountPassword;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountName='" + accountNam + '\'' +
                ", accountPassword='" + accountPassword + '\'' +
                ", user=" + user +
                '}';
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public String getAccountName() {
        return accountNam;
    }

    public void setAccountName(String accountNam) {
        this.accountNam = accountNam;
    }


}
