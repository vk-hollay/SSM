package com.hollay.factory;

import com.hollay.service.AccountService;
import com.hollay.service.impl.AccountServiceImpl;

/**
 * @author hollay
 * @create 2021-01-18-17:12
 * @description 模拟一个工厂类（该类可能是存在于jar中的，我们无法通过修改源码的方式来提供默认构造函数）
 */
public class StaticFactory {

    public static AccountService getAccountService() {
        return new AccountServiceImpl();
    }
}
