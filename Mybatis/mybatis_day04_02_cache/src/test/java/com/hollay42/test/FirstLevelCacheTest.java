package com.hollay42.test;

import com.hollay42.dao.UserDao;
import com.hollay42.domain.User;
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
 * @create 2021-02-03-0:01
 * @description
 */
public class FirstLevelCacheTest {

    private InputStream in;
    private SqlSession sqlSession;
    private SqlSessionFactory factory;
    private UserDao userDao;

    @Before //用于在测试方法执行之前执行
    public void init() throws Exception {
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建构建者工厂对象 SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3.使用构建者创建工厂对象 SqlSessionFactory
        factory = builder.build(in);
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

    /**
     * 测试一级缓存（SqlSession范围的缓存即一级缓存）
     */
    @Test
    public void testFirstLevelCache() {
        System.out.println("--------");
        User user1 = userDao.findById(41);
        System.out.println(user1);

/*      //sqlSession关闭，缓存消失
        sqlSession.close();
        //再次获取 sqlSession对象
        sqlSession = factory.openSession();*/
        sqlSession.clearCache();//此方法也可以清空缓存
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        System.out.println("--------");
        User user2 = userDao.findById(41);
        System.out.println(user2);

        System.out.println(user1 == user2);
    }


    /**
     * 测试缓存的同步（当 SqlSession调用了修改、添加、删除、commit、close等方法时，就会清空一级缓存）
     */
    @Test
    public void testClearCache() {
        //1.查询
        System.out.println("--------");
        User user1 = userDao.findById(41);
        System.out.println(user1);
        //2.更新信息
        user1.setUsername("update user clear cache");
        user1.setAddress("西安市");
        userDao.updateUser(user1);
        //3.再次查询
        System.out.println("--------");
        User user2 = userDao.findById(41);
        System.out.println(user2);

        System.out.println(user1 == user2);
    }
}
