package com.dengjingxu.domain;

import java.io.Serializable;

/**
 * @author: dengjingxu
 * @date: 2020/5/6
 * @description: com.dengjingxu.domain
 * @version: 1.0
 */
public class Account implements Serializable {

    private String accountId;
    private String accountName;
    private Double accountMoney;

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", accountName='" + accountName + '\'' +
                ", accountMoney=" + accountMoney +
                '}';
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Double getAccountMoney() {
        return accountMoney;
    }

    public void setAccountMoney(Double accountMoney) {
        this.accountMoney = accountMoney;
    }
}
