package com.hollay13.mybatis.sqlsession;


import com.hollay13.mybatis.cfg.Configuration;
import com.hollay13.mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import com.hollay13.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * @author hollay
 * @create 2021-02-01-18:27
 * @description 用于创建一个 SqlSessionFactory对象
 */
public class SqlSessionFactoryBuilder {

    /**
     * 根据参数的字节输入流来构建一个 SqlSessionFactory工厂
     * @param config
     * @return
     */
    public SqlSessionFactory build(InputStream config) {
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSqlSessionFactory(cfg);
    }
}
