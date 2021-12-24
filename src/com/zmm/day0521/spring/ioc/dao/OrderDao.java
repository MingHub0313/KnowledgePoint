package com.zmm.day0521.spring.ioc.dao;

import com.zmm.day0521.spring.ioc.pojo.Order;

/**
 * @Name OrderDao
 * @Author 900045
 * @Created by 2020/5/21 0021
 */
public interface OrderDao {

    /**
     * 保存订单详情
     *
     * @param order
     * @return
     */
    void save(Order order);
}
