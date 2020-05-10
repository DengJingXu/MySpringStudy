package com.dengjingxu.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: dengjingxu
 * @date: 2020/4/29
 * @description: com.dengjingxu.proxy
 * @version: 1.0
 */
public class Client {
    public static void main(String[] args) {
         final Producer producer=new Producer();
        /**
         * 动态代理：
         *      特点：字节码随用随机随创建，随用随加载
         *      作用：不修改源码的基础上对方法增强
         *      分类：
         *          基于接口的动态代理
         *          基于子类的动态代理
         *基于接口的动态代理：
         *          涉及的类：Proxy
         *          提供者：JDK官方
         * 如何创建代理对象：
         *          使用Proxy类中的newProxyInstance方法
         * 创建代理类的要求：
         *          被代理类最少实现一个接口，如果没有则不能使用
         * nweProxyInstance方法的参数：
         *          ClassLoader:
         *                  它是用于加载代理对象字节码的，和被代理对象使用相同的类加载器，固定写法
         *          Class[]:
         *                  它是用于让代理对象和被代理对象有相同方法，固定写法
         *         InvocationHandler：
         *                  它是让我们写如何代理，我们一般都是些一个该接口的实现类，通常情况下都是匿名内部类，但不是必须的，
         *                  此接口的实现类都是谁用谁写。
         */
        //基于接口的动态代理
        IProducer proxyProducer = (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 作用：执行被代理的对象的任何接口方法都会经过该方法
                     * 方法参数的含义：
                     * @param proxy   当前代理对象的引用
                     * @param method   当前执行的方法
                     * @param args      当前执行的方法所需要的参数
                     * @return      和被代理对象方法有相同的返回值
                     * @throws Throwable
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object returnValue=null;
                        Double money= (Double) args[0];
                        //增强方法
                        if("saleProduct".equals(method.getName())){
                             returnValue = method.invoke(producer, money * 0.8);
                        }
                        return returnValue;
                    }
                });
        proxyProducer.saleProduct(1000.0);
    }
}
