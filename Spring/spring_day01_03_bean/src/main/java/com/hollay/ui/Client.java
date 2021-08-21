package com.hollay.ui;

import com.hollay.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author hollay
 * @create 2021-01-17-14:53
 * @description 模拟一个表现层，用于调用业务层
 */
public class Client {

    /**
     * 获取 spring的 Ioc核心容器，并根据 id获取对象
     * @param args
     */
    public static void main(String[] args) {

        //1.获取核心容器对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据 id获取 Bean对象
        AccountService as1 = (AccountService) ac.getBean("accountService");
        AccountService as2 = (AccountService) ac.getBean("accountService");

        System.out.println(as1 == as2);
        as1.saveAccount();

        //手动关闭容器
        ac.close();

    }
}
