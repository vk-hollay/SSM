package com.hollay13.test;


import com.hollay13.dao.UserDao;
import com.hollay13.domain.User;
import com.hollay13.mybatis.io.Resources;
import com.hollay13.mybatis.sqlsession.SqlSession;
import com.hollay13.mybatis.sqlsession.SqlSessionFactory;
import com.hollay13.mybatis.sqlsession.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @author hollay
 * @create 2021-01-31-22:52
 * @description mybatis的入门案例
 */
public class MybatisTest {

    /**
     * 入门案例
     * @param args
     */
    public static void main(String[] args) throws Exception {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建 SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂生产 SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //4.使用 SqlSession创建 Dao接口的代理对象（动态代理）
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        //5.使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user: users) {
            System.out.println(user);
        }
        //6.释放资源
        sqlSession.close();
        in.close();
    }
}
