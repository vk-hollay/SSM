package com.hollay32.dao;

import com.hollay32.domain.User;

import java.util.List;

/**
 * @author hollay
 * @create 2021-02-03-14:49
 * @description
 */
public interface UserDao {

    /**
     * 查询所有用户，同时获取到用户下所有账户的信息(一对多，一个用户可以有多个账户)
     * @return
     */
    List<User> findAll();

}
