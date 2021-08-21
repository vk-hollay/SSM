package com.hollay.ssmcase.service.impl;

import com.github.pagehelper.PageHelper;
import com.hollay.ssmcase.dao.IOrdersDao;
import com.hollay.ssmcase.domain.Orders;
import com.hollay.ssmcase.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hollay
 * @create 2021-02-17-16:04
 * @description
 */
@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao ordersDao;

    @Override
    public List<Orders> findAll(int page, int size) throws Exception {
        PageHelper.startPage(page, size);//第一个参数pageNum代表页码值，第二个参数pageSize代表每页显示条数
        return ordersDao.findAll();
    }

    @Override
    public Orders findById(String ordersId) throws Exception {
        return ordersDao.findById(ordersId);
    }
}
