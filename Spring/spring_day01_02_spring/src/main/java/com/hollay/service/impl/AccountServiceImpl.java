package com.hollay.service.impl;

import com.hollay.dao.AccountDao;
import com.hollay.dao.impl.AccountDaoImpl;
import com.hollay.service.AccountService;

/**
 * @author hollay
 * @create 2021-01-17-14:44
 * @description 账户业务层实现类
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao = new AccountDaoImpl();

    public AccountServiceImpl(){
        System.out.println("对象创建了");
    }

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
