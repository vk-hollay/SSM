package com.hollay.service;

import com.hollay.domain.Account;

import java.util.List;

/**
 * @author hollay
 * @create 2021-02-08-15:36
 * @description 账户业务层接口
 */
public interface AccountService {

    /**
     * 查询所有账户
     * @return
     */
    public List<Account> findAll();

    /**
     * 保存账户信息
     * @param account
     */
    public void saveAccount(Account account);
}
