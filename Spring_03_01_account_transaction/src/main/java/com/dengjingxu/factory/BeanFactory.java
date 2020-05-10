package com.dengjingxu.factory;

import com.dengjingxu.service.IAccountService;
import com.dengjingxu.service.imp.AccountServiceImpl;
import com.dengjingxu.utils.TransactionManager;
import com.sun.deploy.net.proxy.ProxyHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: dengjingxu
 * @date: 2020/4/29
 * @description: com.dengjingxu.factory
 * @version: 1.0
 */
public class BeanFactory {

    private  IAccountService iAccountService;
    private TransactionManager txManager;
    public void setiAccountService(IAccountService iAccountService) {
        this.iAccountService = iAccountService;
    }

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }
    public IAccountService getIAccountService() {
        return (IAccountService) Proxy.newProxyInstance(iAccountService.getClass().getClassLoader(),
                iAccountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 添加事务的支持
                     * @param proxy
                     * @param method
                     * @param args
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rtValue=null;
                        try {
                            //1.开启事务
                            txManager.beginTransaction();
                            //2.执行操作
                            rtValue=method.invoke(iAccountService,args);
                            //3.提交事务
                            txManager.commit();
                            //4.返回结果
                            return  rtValue;
                        } catch (Exception e) {
                            //5.回滚事务
                            txManager.rollback();
                            throw new RuntimeException(e);
                        }  finally {
                            //6.释放连接
                            txManager.release();
                        }

                    }
                });
    }


}
