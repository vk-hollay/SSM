package com.hollay.ssmcase.dao;

import com.hollay.ssmcase.domain.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hollay
 * @create 2021-03-11-14:56
 * @description
 */
public interface IPermissionDao {

    //根据角色查询出所有角色所对应的权限
    @Select("select * from permission where id in (select permissionId from role_permission where roleId = #{id})")
    List<Permission> findPermissionByRoleId(String id) throws Exception;

    @Select("select * from permission")
    List<Permission> findAll() throws Exception;

    @Insert("insert into permission(permissionName, url) values(#{permissionName}, #{url})")
    void save(Permission permission) throws Exception;

    @Select("select * from permission where id = #{id}")
    Permission findById(String id) throws Exception;

    @Delete("delete from permission where id=#{id}")
    void deleteById(String id) throws Exception;

    @Delete("delete from role_permission where permissionId = #{id}")
    void deleteFromRole_Permission(String id) throws Exception;
}
