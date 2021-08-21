package com.hollay.factory;

/**
 * @author hollay
 * @create 2021-01-17-16:24
 * @description 一个创建 Bean对象的工厂
 */

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 一个创建 Bean对象的工厂（工厂模式解耦）
 *
 * Bean：在计算机英语中，有可重用组件的含义。
 * JavaBean：用java语言编写的可重用组件。
 *      javabean >  实体类
 *
 *   它就是创建我们的service和dao对象的。
 *
 *   第一个：需要一个配置文件来配置我们的service和dao
 *           配置的内容：唯一标识=全限定类名（key=value)
 *   第二个：通过读取配置文件中配置的内容，反射创建对象
 *
 *   我的配置文件可以是xml也可以是properties
 */
public class BeanFactory {

    //定义一个Properties对象
    private static Properties properties;

    //定义一个 Map，用于存放我们要i创建的对象，我们把它称之为容器
    private static Map<String, Object> beans;

   //使用静态代码块(静态代码块只执行一次)，为Properties对象赋值，加载配置文件，
   //并一次性创建所有 bean对象（单例模式-饿汉式，在类加载的时候就完成了所有 bean对象的实例化），存储到 Map容器中
    static {
        try {
            //实例化对象
            properties = new Properties();
            //获取 properties文件的流对象
            InputStream is = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            properties.load(is);
            //实例化容器
            beans = new HashMap<String, Object>();
            //取出配置文件中所有的 Key
            Enumeration<Object> keys = properties.keys();
            //遍历枚举
            while (keys.hasMoreElements()) {
                //取出每个 Key
                String key = keys.nextElement().toString();
                //根据 key获取 value
                String beanPath = properties.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).getDeclaredConstructor().newInstance();
                //把 key和 value存入容器中
                beans.put(key, value);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties失败！");
        }
    }

    /**
     * 根据 bean的名称获取 bean对象（单例）
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName) {
        return beans.get(beanName);
    }

    /**
     * 根据 bean的名称获取 bean对象（多例）
     * @param beanName
     * @return
     */
/*    public static Object getBean(String beanName) {
        Object bean = null;
        try {
            //每次调用都通过反射去创建一个新的对象，这样创建的对象是多例的
            String beanPath = properties.getProperty(beanName);
            bean = Class.forName(beanPath).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }*/
}
