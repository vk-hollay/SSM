package com.hollay43.dao;

import com.hollay43.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author hollay
 * @create 2021-02-06-22:21
 * @description
 */
public interface UserDao {

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    @Results(id="userMap", value={
            @Result(id=true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "birthday", property = "birthday"),
            @Result(column = "address", property = "address"),
            @Result(property = "accounts", column = "id",
                    many = @Many(select = "com.hollay43.dao.AccountDao.findAccountByUid", fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    @Insert("insert into user(username,address,sex,birthday) values(#{username},#{address},#{sex},#{birthday})")
    @ResultMap(value={"userMap"})
    void saveUser(User user);

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id}")
    @ResultMap("userMap")
    User findById(Integer id);

    /**
     * 更新用户
     * @param user
     */
    @Update("update user set username=#{username},address=#{address},sex=#{sex} where id=#{id}")
    void updateUser(User user);

    /**
     * 删除用户
     * @param userId
     */
    @Delete("delete from user where id=#{userId}")
    void deleteUser(Integer userId);

    /**
     * 根据名称模糊查询用户信息
     * @param username
     * @return
     */
    @Select("select * from user where username like #{username}")
    List<User> findByName1(String username);

    @Select("select * from user where username like '%${value}%'")
    List<User> findByName2(String username);

    /**
     * 查询总用户数
     * @return
     */
    @Select("select count(id) from user")
    int findTotal();

}
