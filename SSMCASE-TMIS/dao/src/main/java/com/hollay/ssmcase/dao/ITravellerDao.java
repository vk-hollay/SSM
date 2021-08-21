package com.hollay.ssmcase.dao;

import com.hollay.ssmcase.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hollay
 * @create 2021-02-25-18:46
 * @description
 */
public interface ITravellerDao {

    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId})")
    List<Traveller> findByOrdersId(String ordersId) throws Exception;
}
