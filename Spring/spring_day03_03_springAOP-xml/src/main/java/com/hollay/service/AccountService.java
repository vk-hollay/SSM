package com.hollay.service;

/**
 * @author hollay
 * @create 2021-01-22-1:08
 * @description 账户的业务层接口
 */
public interface AccountService {

    /**
     * 模拟保存账户
     */
    void saveAccount();

    /**
     * 模拟更新账户
     * @param i
     */
    void updateAccount(int i);

    /**
     * 删除账户
     */
    int deleteAccount();
}
