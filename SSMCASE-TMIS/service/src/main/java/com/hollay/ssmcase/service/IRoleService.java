package com.hollay.ssmcase.service;

import com.hollay.ssmcase.domain.Permission;
import com.hollay.ssmcase.domain.Role;

import java.util.List;

/**
 * @author hollay
 * @create 2021-03-13-15:06
 * @description
 */
public interface IRoleService {

    List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;

    Role findById(String roleId) throws Exception;

    List<Permission> findOtherPermissions(String roleId) throws Exception;

    void addPermissionToRole(String roleId, String[] permissionIds) throws Exception;

    void deleteRoleById(String roleId) throws Exception;
}
