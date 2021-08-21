package com.hollay.test;

import com.hollay.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hollay
 * @create 2021-02-08-16:24
 * @description
 */
public class TestSpring {

    @Test
    public void run1() {
        //加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //获取对象
        AccountService accountService = ac.getBean("accountService", AccountService.class);
        //调用方法
        accountService.findAll();

    }
}
