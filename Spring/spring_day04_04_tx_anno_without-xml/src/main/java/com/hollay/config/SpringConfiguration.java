package com.hollay.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author hollay
 * @create 2021-01-25-0:32
 * @description spring的配置类，相当于bean.xml
 */

@Configuration
@ComponentScan("com.hollay")
@Import({JdbcConfig.class, TransactionConfig.class})
@PropertySource("jdbcConfig.properties") //加载配置文件
@EnableTransactionManagement //开启spring对注解事务的支持
public class SpringConfiguration {
}
