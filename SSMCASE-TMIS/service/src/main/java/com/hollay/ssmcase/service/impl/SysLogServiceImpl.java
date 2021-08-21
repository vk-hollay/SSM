package com.hollay.ssmcase.service.impl;

import com.hollay.ssmcase.dao.ISysLogDao;
import com.hollay.ssmcase.domain.SysLog;
import com.hollay.ssmcase.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hollay
 * @create 2021-03-15-15:45
 * @description
 */

@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private ISysLogDao sysLogDao;

    @Override
    public void save(SysLog sysLog) throws Exception {
        sysLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll() throws Exception {
        return sysLogDao.findAll();
    }
}
