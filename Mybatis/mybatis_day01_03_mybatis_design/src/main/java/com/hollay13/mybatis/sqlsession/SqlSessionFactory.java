package com.hollay13.mybatis.sqlsession;

/**
 * @author hollay
 * @create 2021-02-01-18:29
 * @description
 */
public interface SqlSessionFactory {

    /**
     * 用于打开一个新的 SqlSession对象
     * @return
     */
    SqlSession openSession();
}
