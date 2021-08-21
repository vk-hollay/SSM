package com.hollay.ui;

import com.hollay.dao.AccountDao;
import com.hollay.service.AccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


/**
 * @author hollay
 * @create 2021-01-17-14:53
 * @description 模拟一个表现层，用于调用业务层
 */
public class Client {

    /**
     * @param args
     */
    public static void main(String[] args) {

        //1.获取核心容器对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据 id获取 Bean对象
        AccountService as = (AccountService) ac.getBean("accountService");
        AccountService as2 = (AccountService) ac.getBean("accountService");
//        System.out.println(as);
//
//        AccountDao adao = ac.getBean("accountDao", AccountDao.class);
//        System.out.println(adao);

//        System.out.println(as == as2);
        as.saveAccount();
        ac.close(); //close()是ClassPathXmlApplicationContext中的方法



    }
}
