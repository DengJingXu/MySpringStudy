package com.dengjingxu.service.impl;


import com.dengjingxu.service.SaveAccount;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: com.dengjingxu
 * @date: 2020/4/24
 * @description: com.com.dengjingxu.service.impl
 * @version: 1.0
 */
public class SaveAccountImpl implements SaveAccount {

    //经常变化的数据不适合用注入方式

    private String name;
    private int age;
    private Date date;
    private List list;
    private String []array;
    private Map<String,String > map;

    public void setList(List list) {
        this.list = list;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDate(Date date) {
        this.date = date;
    }

   /* public SaveAccountImpl(String name, int age, Date date) {
        this.name = name;
        this.age = age;
        this.date = date;
    }*/

    @Override
    public void saveAccount(String account) {
        System.out.println("saveAccount"+":"+name+":"+age+":"+date);
    }


}
