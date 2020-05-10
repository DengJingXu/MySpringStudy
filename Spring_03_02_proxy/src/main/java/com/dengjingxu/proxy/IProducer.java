package com.dengjingxu.proxy;

/**
 * @author: dengjingxu
 * @date: 2020/4/29
 * @description: com.dengjingxu.proxy
 * @version: 1.0
 */
public interface IProducer {
    /**
     * 销售产品
     * @param money
     */
    void saleProduct(double money);

    /**
     * 售后服务
     */
    void serviceAfterSafe();
}
