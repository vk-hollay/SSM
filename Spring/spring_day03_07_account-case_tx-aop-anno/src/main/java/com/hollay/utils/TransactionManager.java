package com.hollay.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * @author hollay
 * @create 2021-01-20-23:43
 * @description 和事务管理相关的工具类，它包含了：开启事务，提交事务，回滚事务，释放连接
 */
@Component("txManager")
@Aspect
public class TransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* com.hollay.service.impl.*.*(..))")
    private void pt(){};

    /**
     * 开启事务
     */
//    @Before("pt()")
    public void beginTransaction() {
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
//    @AfterReturning("pt()")
    public void commit() {
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
//    @AfterThrowing("pt()")
    public void rollback() {
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放连接
     */
//    @After("pt()")
    public void release() {
        try {
            connectionUtils.getThreadConnection().close();//close是将连接返回连接池中
            //此时线程和连接仍绑定在一块，但连接已被close用不了了，所以需要将连接和线程解绑
            connectionUtils.removeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Around("pt()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) {
        Object rtValue = null;
        try {
            Object[] args= pjp.getArgs();//得到方法执行所需的参数
            this.beginTransaction();//开启事务
            rtValue = pjp.proceed(args);//明确调用业务层方法（即切入点方法）
            this.commit();//提交事务
            return rtValue;
        } catch (Throwable throwable) {
            this.rollback();//回滚事务
            throw new RuntimeException(throwable);
        } finally {
            this.release();//释放资源
        }
    }
}
