package com.hollay.service.impl;

import com.hollay.dao.AccountDao;
import com.hollay.domain.Account;
import com.hollay.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hollay
 * @create 2021-01-24-21:29
 * @description
 */
@Service("accountService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)//只读型事务的配置
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }


    //需要的是读写型事务配置
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)//只读型事务的配置
    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("transfer....");
        //2.1根据名称查询转出账户
        Account source = accountDao.findAccountByName(sourceName);
        //2.2根据名称查询转入账户
        Account target = accountDao.findAccountByName(targetName);
        //2.3转出账户减钱
        source.setMoney(source.getMoney()-money);
        //2.4转入账户加钱
        target.setMoney(target.getMoney()+money);
        //2.5更新转出账户
        accountDao.updateAccount(source);

//        int i=1/0;

        //2.6更新转入账户
        accountDao.updateAccount(target);
    }
}
