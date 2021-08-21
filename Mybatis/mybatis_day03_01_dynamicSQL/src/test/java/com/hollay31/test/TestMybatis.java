package com.hollay31.test;

import com.hollay31.dao.UserDao;
import com.hollay31.domain.QueryVo;
import com.hollay31.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
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
        List<User> users = userDao.findAll();
        for (User user: users) {
            System.out.println(user);
        }
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
    public void testFindUserByVo() {
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        vo.setUser(user);
        List<User> users = userDao.findUserByVo(vo);
        for (User u: users) {
            System.out.println(u);
        }
    }

    @Test
    public void testFindUserByCondition() {
        User user = new User(null, "老王", null, "男", null);
        List<User> users = userDao.findUserByCondition(user);
        for (User u: users) {
            System.out.println(u);
        }
    }

    @Test
    public void testFindUserInIds() {
        QueryVo vo = new QueryVo();
        List<Integer> list = new ArrayList<Integer>();
        list.add(41);
        list.add(42);
        list.add(46);
        vo.setIds(list);

        List<User> users = userDao.findUserInIds(vo);
        for (User u: users) {
            System.out.println(u);
        }
    }
}
