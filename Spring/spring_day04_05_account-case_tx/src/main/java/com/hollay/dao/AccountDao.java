package com.hollay.dao;

import com.hollay.domain.Account;

/**
 * @author hollay
 * @create 2021-01-23-0:34
 * @description 账户的持久层接口
 */
public interface AccountDao {

    /**
     * 根据Id查询账户
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 根据名称查询账户
     * @param accountName
     * @return
     */
    Account findAccountByName(String accountName);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);
}
