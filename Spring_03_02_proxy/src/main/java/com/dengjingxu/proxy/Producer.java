package com.dengjingxu.proxy;

/**
 * @author: dengjingxu
 * @date: 2020/4/29
 * @description: com.dengjingxu.proxy
 * @version: 1.0
 */

/**
 * 一个生成者
 */
public class Producer implements  IProducer{

    public void saleProduct(double money){
        System.out.println("生成者销售获取金额："+money);
    }

    public void serviceAfterSafe(){
        System.out.println("生成者售后服务");
    }
}
