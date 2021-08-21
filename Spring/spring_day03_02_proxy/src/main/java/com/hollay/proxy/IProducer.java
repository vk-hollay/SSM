package com.hollay.proxy;

/**
 * @author hollay
 * @create 2021-01-21-1:03
 * @description 对生产产家要求的接口
 */
public interface IProducer {

    /**
     * 销售
     * @param money
     */
    public void saleProduct(float money);

    /**
     * 售后
     * @param money
     */
    public void afterService(float money);
}
