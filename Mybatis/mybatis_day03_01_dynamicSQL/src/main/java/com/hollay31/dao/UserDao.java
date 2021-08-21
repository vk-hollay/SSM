package com.hollay31.dao;

import com.hollay31.domain.QueryVo;
import com.hollay31.domain.User;

import java.util.List;

/**
 * @author hollay
 * @create 2021-02-03-14:49
 * @description
 */
public interface UserDao {

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 根据名称模糊查询用户信息
     * @param username
     * @return
     */
    List<User> findByName1(String username);


    /**
     * 根据QueryVo中的条件查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);

    /**
     * 根据传入的参数条件
     * @param user 查询的条件，有可能有用户名，有可能有性别，也有可能有地址，还有可能都有或都没有
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据 queryvo中提供的 id集合，查询用户信息
     * @param vo
     * @return
     */
    List<User> findUserInIds(QueryVo vo);
}
