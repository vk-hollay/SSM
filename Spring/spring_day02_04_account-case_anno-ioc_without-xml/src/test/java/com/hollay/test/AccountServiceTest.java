package com.hollay.test;

import com.hollay.domain.Account;
import com.hollay.service.AccountService;
import config.SpringConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author hollay
 * @create 2021-01-19-16:58
 * @description 使用Junit单元测试，测试我们的配置
 */

/**
 * 使用Junit单元测试：测试我们的配置
 *
 * Spring整合junit分析：
 *      1、应用程序的入口
 * 	        main方法
 *      2、junit单元测试中，没有main方法也能执行
 * 	        junit集成了一个main方法
 * 	        该方法就会判断当前测试类中哪些方法有 @Test注解
 * 	        junit就让有Test注解的方法执行
 *      3、junit不会管我们是否采用spring框架
 * 	        在执行测试方法时，junit根本不知道我们是不是使用了spring框架
 * 	        所以也就不会为我们读取配置文件/配置类创建spring核心容器
 *      4、由以上三点可知
 * 	            当测试方法执行时，没有Ioc容器，就算写了Autowired注解，也无法实现注入
 *
 * 解决方法：Spring整合junit的配置
 *      1、导入spring整合junit的jar(坐标)
 *      2、使用Junit提供的一个注解把原有的main方法替换了，替换成spring提供的
 *             @Runwith
 *      3、告知spring的运行器，spring和ioc创建是基于xml还是注解的，并且说明位置
 *             @ContextConfiguration
 *                  locations：指定xml文件的位置，加上classpath关键字，表示在类路径下
 *                  classes：指定注解类所在地位置
 *
 *   当我们使用spring 5.x版本的时候，要求junit的jar必须是4.12及以上
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes =  SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    private AccountService as = null;

    @Test
    public void testFindAll() {
        //执行方法
        List<Account> accounts = as.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account.toString());
        }
    }

    @Test
    public void testFindOne() {
        //执行方法
        Account account = as.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {
        //执行方法
        as.saveAccount(new Account(null, "qwer", 2234.6f));
    }

    @Test
    public void testUpdate() {
        //执行方法
        as.updateAccount(new Account(1, "www",  555.2f));
    }

    @Test
    public void testDelete() {
        //执行方法
        as.deleteAccount(8);
    }

}
