package com.hollay13.mybatis.sqlsession;

/**
 * @author hollay
 * @create 2021-02-01-18:31
 * @description 自定义 Mybatis中和数据库交互的核心类
 *                 它里面可以创建 dao接口的代理对象
 */
public interface SqlSession {

    /**
     * 根据参数创建一个代理对象
     * @param daoInterfaceClass dao的接口字节码
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> daoInterfaceClass);

    /**
     * 释放资源
     */
    void close();
}
