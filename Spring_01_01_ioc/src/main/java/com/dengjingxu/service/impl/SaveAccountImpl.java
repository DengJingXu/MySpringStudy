package com.dengjingxu.service.impl;

import com.dengjingxu.dao.Impl.SaceAccountDaoImpl;
import com.dengjingxu.dao.SaveAccountDao;
import com.dengjingxu.service.SaveAccount;

/**
 * @author: dengjingxu
 * @date: 2020/4/24
 * @description: com.dengjingxu.service.impl
 * @version: 1.0
 */
public class SaveAccountImpl implements SaveAccount {
    private SaveAccountDao saveAccountDao=new SaceAccountDaoImpl();
    /*private SaveAccountDao saveAccountDao= (SaveAccountDao) BeansFactory.getBean("saveAccountDao");*/
    public void saveAccount(String account) {
        saveAccountDao.saveAccountDao(account);
    }
}
