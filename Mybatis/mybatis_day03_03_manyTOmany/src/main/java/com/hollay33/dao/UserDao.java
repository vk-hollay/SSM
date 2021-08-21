package com.hollay33.dao;

import com.hollay33.domain.User;

import java.util.List;

/**
 * @author hollay
 * @create 2021-02-03-14:49
 * @description
 */
public interface UserDao {

    /**
     * 查询所有用户（查询用户时，可以同时得到用户所包含的角色信息）
     * @return
     */
    List<User> findAll();

}
