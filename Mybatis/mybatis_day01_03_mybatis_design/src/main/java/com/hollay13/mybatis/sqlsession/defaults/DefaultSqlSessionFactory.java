package com.hollay13.mybatis.sqlsession.defaults;

import com.hollay13.mybatis.cfg.Configuration;
import com.hollay13.mybatis.sqlsession.SqlSession;
import com.hollay13.mybatis.sqlsession.SqlSessionFactory;

/**
 * @author hollay
 * @create 2021-02-01-21:09
 * @description SqlSessionFactory接口的实现类
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg) {
        this.cfg = cfg;
    }


    /**
     * 用于创建一个新的操作数据库对象
     * @return
     */
    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
