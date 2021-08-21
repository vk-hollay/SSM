package com.hollay.service.impl;

import com.hollay.dao.AccountDao;
import com.hollay.factory.BeanFactory;
import com.hollay.service.AccountService;

/**
 * @author hollay
 * @create 2021-01-17-14:44
 * @description 账户业务层实现类
 */
public class AccountServiceImpl implements AccountService {

//    private AccountDao accountDao = new AccountDaoImpl();
    private AccountDao accountDao = (AccountDao) BeanFactory.getBean("accountDao");

//    private int i = 1;

    @Override
    public void saveAccount() {
        int i = 1;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
