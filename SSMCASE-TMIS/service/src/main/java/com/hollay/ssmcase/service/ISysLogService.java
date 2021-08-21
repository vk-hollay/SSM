package com.hollay.ssmcase.service;

import com.hollay.ssmcase.domain.SysLog;

import java.util.List;

/**
 * @author hollay
 * @create 2021-03-15-15:44
 * @description
 */
public interface ISysLogService {

    void save(SysLog sysLog) throws Exception;

    List<SysLog> findAll() throws Exception;
}
