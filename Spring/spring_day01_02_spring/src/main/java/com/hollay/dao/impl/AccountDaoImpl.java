package com.hollay.dao.impl;

import com.hollay.dao.AccountDao;

/**
 * @author hollay
 * @create 2021-01-17-14:50
 * @description 账户的持久层实现类
 */
public class AccountDaoImpl implements AccountDao {
    @Override
    public void saveAccount() {
        System.out.println("保存了账户！");
    }
}
