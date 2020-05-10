package com.dengjingxu.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author: dengjingxu
 * @date: 2020/4/24
 * @description: com.dengjingxu.factory
 * @version: 1.0
 */
public class BeansFactory {
    private static Properties properties;
    private static Map<String,Object>beanMap;
    static {
       /* try {
            properties=new Properties();
            InputStream resourceAsStream = BeansFactory.class.getClassLoader().getResourceAsStream("beans.properties");
            properties.load(resourceAsStream);
        } catch (IOException e) {
            throw new ExceptionInInitializerError("初始化失败");
        }*/
        try {
            beanMap=new HashMap<String, Object>();
            properties=new Properties();
            InputStream resourceAsStream = BeansFactory.class.getClassLoader().getResourceAsStream("beans.properties");
            properties.load(resourceAsStream);
            Enumeration<Object> keys = properties.keys();
            while(keys.hasMoreElements()){
                String key = keys.nextElement().toString();
                String beanPath=properties.getProperty(key);
                Object obj = Class.forName(beanPath).newInstance();
                beanMap.put(key,obj);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化失败");
        }

    }
    public static Object getBean(String beanName){
        return beanMap.get(beanName);
    }
/*
    public static Object getBean(String beanName){
        Object bean=null;
        try {
            String beanPath = (String) properties.get(beanName);
            System.out.println(beanPath);
           bean= Class.forName(beanPath).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }*/
}
