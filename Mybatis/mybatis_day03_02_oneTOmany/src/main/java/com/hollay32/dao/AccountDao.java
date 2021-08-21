package com.hollay32.dao;

import com.hollay32.domain.Account;
import com.hollay32.domain.AccountUser;

import java.util.List;

/**
 * @author hollay
 * @create 2021-02-05-11:44
 * @description
 */
public interface AccountDao {

    /**
     * 查询所有账户，同时还要获取到当前账户的所属用户信息（一对一，一个账户只能属于一个用户；多对一，多个账户也可以属于一个用户）
     * @return
     */
    List<Account> findAll();

    /**
     * 查询所有账户，并且带有用户名称和地址信息
     * @return
     */
    List<AccountUser> findAllAccount();
}
