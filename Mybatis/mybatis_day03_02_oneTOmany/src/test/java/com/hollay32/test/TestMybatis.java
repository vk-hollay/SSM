package com.hollay32.test;

import com.hollay32.dao.AccountDao;
import com.hollay32.dao.UserDao;
import com.hollay32.domain.Account;
import com.hollay32.domain.AccountUser;
import com.hollay32.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hollay
 * @create 2021-02-03-0:01
 * @description
 */
public class TestMybatis {

    private InputStream in;
    private SqlSession sqlSession;
    private UserDao userDao;
    private AccountDao accountDao;

    @Before //用于在测试方法执行之前执行
    public void init() throws Exception {
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建构建者工厂对象 SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3.使用构建者创建工厂对象 SqlSessionFactory
        SqlSessionFactory factory = builder.build(in);
        //4.使用 SqlSessionFactory生产 SqlSession对象
        sqlSession = factory.openSession();
        //5.使用 SqlSession创建 dao接口的代理对象
        userDao = sqlSession.getMapper(UserDao.class);
        accountDao = sqlSession.getMapper(AccountDao.class);
    }

    @After //用于在测试方法执行之后执行
    public void destroy() throws Exception {
        //提交事务
        sqlSession.commit();
        //7.释放资源
        sqlSession.close();
        in.close();
    }

//    UserDao的测试
    @Test
    public void testUserFindAll() throws Exception {
        //6.使用代理对象执行查询所有方法
        List<User> users = userDao.findAll();
        for (User user: users) {
            System.out.println(user);
        }
    }


//    AccountDao的测试
    @Test
    public void testAccountFindAll() throws Exception {
        //6.使用代理对象执行查询所有方法
        List<Account> accounts = accountDao.findAll();
        for (Account account: accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindAllAccount() {
        List<AccountUser> accountUsers = accountDao.findAllAccount();
        for (AccountUser accountUser :accountUsers) {
            System.out.println(accountUser);
        }
    }
}
