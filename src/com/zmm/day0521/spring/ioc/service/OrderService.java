package com.zmm.day0521.spring.ioc.service;

import com.zmm.day0521.spring.ioc.pojo.Order;

/**
 * @Name OrderService
 * @Author 900045
 * @Created by 2020/5/21 0021
 */
public interface OrderService {

    /**
     * 下单
     *
     * @param order
     */
    void order(Order order);

}
