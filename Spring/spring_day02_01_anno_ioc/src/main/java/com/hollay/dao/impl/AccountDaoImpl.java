package com.hollay.dao.impl;

import com.hollay.dao.AccountDao;
import org.springframework.stereotype.Repository;

/**
 * @author hollay
 * @create 2021-01-17-14:50
 * @description 账户的持久层实现类
 */
@Repository("accountDao1")
public class AccountDaoImpl implements AccountDao {
    @Override
    public void saveAccount() {
        System.out.println("保存了账户1111111111");
    }
}
