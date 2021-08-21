package com.hollay11.dao;

import com.hollay11.domain.User;

import java.util.List;

/**
 * @author hollay
 * @create 2021-01-31-18:43
 * @description
 */
public interface UserDao {

    /**
     * 查询所有操作
     * @return
     */
    List<User> findAll();

}
