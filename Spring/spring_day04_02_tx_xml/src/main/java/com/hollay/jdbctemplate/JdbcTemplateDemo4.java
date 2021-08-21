package com.hollay.jdbctemplate;

import com.hollay.dao.AccountDao;
import com.hollay.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author hollay
 * @create 2021-01-22-22:27
 * @description 调用dao层方法
 */
public class JdbcTemplateDemo4 {

    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.获取对象
        AccountDao accountDao = ac.getBean("accountDao", AccountDao.class);
//        AccountDao accountDao = ac.getBean("accountDao2", AccountDao.class);

        Account account = accountDao.findAccountById(3);
        System.out.println(account);

        account.setMoney(10000f);
        accountDao.updateAccount(account);
    }
}
