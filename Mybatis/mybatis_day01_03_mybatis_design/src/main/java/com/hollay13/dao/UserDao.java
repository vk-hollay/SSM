package com.hollay13.dao;


import com.hollay13.domain.User;
import com.hollay13.mybatis.annotations.Select;

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
    @Select("select * from user")
    List<User> findAll();

}
