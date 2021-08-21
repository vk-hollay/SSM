package com.hollay.ssmcase.service;

import com.hollay.ssmcase.domain.Product;

import java.util.List;

/**
 * @author hollay
 * @create 2021-02-12-12:13
 * @description
 */
public interface IProductService {

    List<Product> findAll() throws Exception;

    void save(Product product) throws Exception;
}
