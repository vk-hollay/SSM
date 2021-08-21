package com.hollay.ssmcase.service.impl;

import com.hollay.ssmcase.dao.IProductDao;
import com.hollay.ssmcase.domain.Product;
import com.hollay.ssmcase.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author hollay
 * @create 2021-02-12-12:15
 * @description
 */

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }
}
