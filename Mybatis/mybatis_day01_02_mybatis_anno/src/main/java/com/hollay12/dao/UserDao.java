package com.hollay12.dao;

import com.hollay12.domain.User;
import org.apache.ibatis.annotations.Select;

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
