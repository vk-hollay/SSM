package com.hollay.service.impl;

import com.hollay.service.AccountService;

/**
 * @author hollay
 * @create 2021-01-22-1:10
 * @description
 */
public class AccountServiceImpl implements AccountService {
    @Override
    public void saveAccount() {
        System.out.println("执行了保存");
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("执行了更新" + i);
    }

    @Override
    public int deleteAccount() {
        System.out.println("执行了删除");
        return 0;
    }
}
