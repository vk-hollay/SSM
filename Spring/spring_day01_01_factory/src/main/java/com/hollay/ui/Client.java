package com.hollay.ui;

import com.hollay.factory.BeanFactory;
import com.hollay.service.AccountService;

/**
 * @author hollay
 * @create 2021-01-17-14:53
 * @description 模拟一个表现层，用于调用业务层
 */
public class Client {

    public static void main(String[] args) {
        //AccountService as = new AccountServiceImpl();
        for (int i = 0; i < 5; i++) {
            AccountService as = (AccountService) BeanFactory.getBean("accountService");
            System.out.println(as);
            as.saveAccount();
        }
    }
}
