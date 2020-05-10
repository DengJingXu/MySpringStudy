package com.dengjingxu.domint;

import java.io.Serializable;

/**
 * @author: com.dengjingxu
 * @date: 2020/4/25
 * @description: com.com.dengjingxu.domint
 * @version: 1.0
 */
public class Account implements Serializable {
    private Integer account_id;
    private String account_name;
    private Double account_money;

    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public Double getAccount_money() {
        return account_money;
    }

    public void setAccount_money(Double account_money) {
        this.account_money = account_money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + account_id +
                ", accountName='" + account_name + '\'' +
                ", accountMoney=" + account_money +
                '}';
    }
}
