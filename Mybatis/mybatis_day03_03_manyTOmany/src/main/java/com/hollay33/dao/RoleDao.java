package com.hollay33.dao;

import com.hollay33.domain.Role;

import java.util.List;

/**
 * @author hollay
 * @create 2021-02-05-21:18
 * @description
 */
public interface RoleDao {

    /**
     * 查询所有角色(查询角色时，可以同时得到角色的所赋予的用户信息)
     * @return
     */
    List<Role> findAll();
}
