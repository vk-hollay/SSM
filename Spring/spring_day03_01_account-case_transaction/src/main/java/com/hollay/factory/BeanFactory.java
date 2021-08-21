package com.hollay.factory;

import com.hollay.domain.Account;
import com.hollay.service.AccountService;
import com.hollay.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author hollay
 * @create 2021-01-21-23:06
 * @description 用于创建Service的代理对象的工厂
 */
public class BeanFactory {

    private AccountService accountService;

    private TransactionManager txManager;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public final void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public AccountService getAccountService() {
        return (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 添加事务的支持
                     * @param proxy
                     * @param method
                     * @param args
                     * @return
                     * @throws Throwable
                     */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object rtValue = null;
                try {
                    //1.开启事务
                    txManager.beginTransaction();
                    //2.执行操作
                    rtValue = method.invoke(accountService, args);
                    //3.提交事务
                    txManager.commit();
                    //4.返回结果
                    return rtValue;
                } catch (Exception e) {
                    //4.回滚事务
                    txManager.rollback();
                    throw new RuntimeException(e);
                } finally {
                    //5.释放连接
                    txManager.release();
                }
            }
        });
    }
}
