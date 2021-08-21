package com.hollay.test;

import com.hollay.dao.AccountDao;
import com.hollay.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;

import java.io.InputStream;
import java.util.List;

/**
 * @author hollay
 * @create 2021-02-08-18:12
 * @description
 */
public class TestMybatis {

    @Test
    public void testFindAll() throws Exception {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //通过SqlSessionFactoryBuilder创建SqlSessionFactory对象，再通过SqlSessionFactory创建 SqlSession对象
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(in).openSession();
        //获取到代理对象
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        List<Account> accounts = accountDao.findAll();
        for (Account account: accounts) {
            System.out.println(account);
        }
        //关闭资源
        sqlSession.close();
        in.close();
    }

    @Test
    public void testSaveAccount() throws Exception {
        //加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //通过SqlSessionFactoryBuilder创建SqlSessionFactory对象，再通过SqlSessionFactory创建 SqlSession对象
        SqlSession sqlSession = new SqlSessionFactoryBuilder().build(in).openSession();
        //获取到代理对象
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        accountDao.saveAccount(new Account(null, "呼呼呼", 251.5));
        //提交事务
        sqlSession.commit();
        //关闭资源
        sqlSession.close();
        in.close();
    }
}
