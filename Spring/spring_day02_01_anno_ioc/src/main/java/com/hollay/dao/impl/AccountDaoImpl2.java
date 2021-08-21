package com.hollay.dao.impl;

import com.hollay.dao.AccountDao;
import org.springframework.stereotype.Repository;

/**
 * @author hollay
 * @create 2021-01-19-12:11
 * @description
 */

@Repository("accountDao2")
public class AccountDaoImpl2 implements AccountDao {
    @Override
    public void saveAccount() {
        System.out.println("保存了账户222222222222");
    }
}
