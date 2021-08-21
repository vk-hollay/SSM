package com.hollay.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author hollay
 * @create 2021-01-22-17:51
 * @description
 */

@Configuration
@ComponentScan(basePackages = "com.hollay")
@EnableAspectJAutoProxy
public class SpringConfiguration {
}
