package com.hollay.ssmcase.service;

import com.hollay.ssmcase.domain.Permission;

import java.util.List;

/**
 * @author hollay
 * @create 2021-03-13-15:59
 * @description
 */
public interface IPermissionService {

    List<Permission> findAll() throws Exception;

    void save(Permission permission) throws Exception;

    Permission findById(String id) throws Exception;

    void deleteById(String id) throws Exception;
}
