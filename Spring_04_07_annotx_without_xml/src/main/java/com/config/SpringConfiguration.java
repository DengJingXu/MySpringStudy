package com.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author: dengjingxu
 * @date: 2020/5/1
 * @description: com.config
 * @version: 1.0
 */
@Configuration
@ComponentScan("com.dengjingxu")
@Import({JdbcConfiguration.class,TransactionManagerConfiguration.class})
@PropertySource("jdbc.properties")
@EnableTransactionManagement
public class SpringConfiguration {

}
