package com.hollay.test;

import com.hollay.config.SpringConfiguration;
import com.hollay.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hollay
 * @create 2021-01-22-1:50
 * @description 测试AOP的配置
 */

public class AOPTest {

    public static void main(String[] args) {
        //1.获取容器
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.获取对象
        AccountService as = ac.getBean("accountService", AccountService.class);

        //3.执行方法
        as.saveAccount();

    }
}
