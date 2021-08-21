package com.hollay.ssmcase.dao;

import com.hollay.ssmcase.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hollay
 * @create 2021-02-12-12:05
 * @description
 */
@Repository
public interface IProductDao {

    /**
     * 查询所有的产品信息
     * @return
     */
    @Select("select * from product")
    List<Product> findAll() throws Exception;

    /**
     * 添加产品
     * @param product
     * @throws Exception
     */
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus)" +
            "values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product) throws Exception;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Select("select * from product where id=#{id}")
    Product findById(String id) throws Exception;
}
