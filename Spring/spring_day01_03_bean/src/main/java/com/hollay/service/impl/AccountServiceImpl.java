package com.hollay.service.impl;

import com.hollay.service.AccountService;

/**
 * @author hollay
 * @create 2021-01-17-14:44
 * @description 账户业务层实现类
 */
public class AccountServiceImpl implements AccountService {


    public AccountServiceImpl(){
        System.out.println("对象创建了");
    }

    @Override
    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了。。。");
    }

    @Override
    public void init() {
        System.out.println("对象初始化了。。。");
    }

    @Override
    public void destroy() {
        System.out.println("对象销毁了。。。");
    }

}
