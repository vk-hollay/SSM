package com.hollay.service;

import com.hollay.domain.Account;

/**
 * @author hollay
 * @create 2021-01-24-21:26
 * @description 账户的业务层接口
 */
public interface AccountService {

    /**
     * 根据id查询账户信息
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 转账
     * @param sourceName 转出账户名称
     * @param targetName 转入账户名称
     * @param money 转账金额
     */
    void transfer(String sourceName, String targetName, Float money);
}
