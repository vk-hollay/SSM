package com.hollay43.test;

import com.hollay43.dao.AccountDao;
import com.hollay43.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author hollay
 * @create 2021-02-06-23:28
 * @description
 */
public class AnnoAccountTest {

    private InputStream in;
    private SqlSession sqlSession;
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

    @Test
    public void testFindAll() throws Exception {
        //6.使用代理对象执行查询所有方法
        List<Account> accounts = accountDao.findAll();
        for (Account account: accounts) {
            System.out.println("----------每个账户的信息---------");
            System.out.println(account);
        }
    }
/*
    @Test
    public void testSaveUser() {
        User user = new User(null, "mybatis anno SaveUser", new Date(), "女","东京市");
        System.out.println("保存之前：" + user);
        //6.使用代理对象执行保存用户方法
        userDao.saveUser(user);
        System.out.println("保存之后：" + user);
    }

    @Test
    public void testUpdateUser() {
        User user = new User(52, "mybatis anno UpdateUser", new Date(), "男","上海市");
        userDao.updateUser(user);
    }

    @Test
    public void testDeleteUser() {
        userDao.deleteUser(52);
    }

    @Test
    public void testFindById() {
        User user = userDao.findById(50);
        System.out.println(user);
    }

    @Test
    public void testFindByName1() {
        List<User> users = userDao.findByName1("%王%");
        for (User user: users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindByName2() {
        List<User> users = userDao.findByName2("王");
        for (User user: users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal() {
        int count = userDao.findTotal();
        System.out.println(count);
    }*/
}
