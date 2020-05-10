package com.dengjingxu.factory;

import com.dengjingxu.service.SaveAccount;
import com.dengjingxu.service.impl.SaveAccountImpl;

/**
 * @author: dengjingxu
 * @date: 2020/4/25
 * @description: com.dengjingxu.factory
 * @version: 1.0
 */
public class InstanceFactory {
    /**
     * 模拟一个工厂类（该类可能是存在于jar包中的，我们无法通过修改源码的方式来提供默认构造函数）
     */

    public SaveAccount getSaveAccount(){
        return new SaveAccountImpl();
    }
}
