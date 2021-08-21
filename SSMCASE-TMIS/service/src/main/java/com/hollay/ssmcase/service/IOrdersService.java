package com.hollay.ssmcase.service;

import com.hollay.ssmcase.domain.Orders;

import java.util.List;

/**
 * @author hollay
 * @create 2021-02-17-16:02
 * @description
 */
public interface IOrdersService {

    List<Orders> findAll(int page, int size) throws Exception;

    Orders findById(String ordersId) throws Exception;
}
