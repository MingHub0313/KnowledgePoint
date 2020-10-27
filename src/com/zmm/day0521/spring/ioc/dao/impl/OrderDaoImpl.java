package com.zmm.day0521.spring.ioc.dao.impl;

import com.zmm.day0521.spring.ioc.dao.OrderDao;
import com.zmm.day0521.spring.ioc.pojo.Order;

/**
 * @Name OrderDaoImpl
 * @Author 900045
 * @Created by 2020/5/21 0021
 */
public class OrderDaoImpl implements OrderDao {

	@Override
	public void save(Order order) {
		System.out.println("订单Id:" + order.getOrderId() + "保存成功");
	}
}
