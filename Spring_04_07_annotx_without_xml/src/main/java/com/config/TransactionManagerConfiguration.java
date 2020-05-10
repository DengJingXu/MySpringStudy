package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @author: dengjingxu
 * @date: 2020/5/1
 * @description: com.config
 * @version: 1.0
 */
public class TransactionManagerConfiguration {

    @Bean("txManager")
    public PlatformTransactionManager createTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

}
