package com.zmm.day0521.spring.ioc.service.impl;

import com.zmm.day0521.spring.ioc.dao.OrderDao;
import com.zmm.day0521.spring.ioc.dao.StockDao;
import com.zmm.day0521.spring.ioc.pojo.Order;
import com.zmm.day0521.spring.ioc.service.OrderService;

/**
 * @Name OrderServiceImpl
 * @Author 900045
 * @Created by 2020/5/21 0021
 */
public class OrderServiceImpl implements OrderService {

	private OrderDao orderDao;
	private StockDao stockDao;

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public void setStockDao(StockDao stockDao) {
		this.stockDao = stockDao;
	}


	@Override
	public void order(Order order) {
		// 没有IOC容器的情况下
		// OrderDao orderDao = new OrderDaoImpl();
		// 保存订单
		// orderDao.save(order);
		// 扣除库存
		// StockDao stockDao = new StockDaoImpl();
		// stockDao.subStock(order.getName());

		// 有IOC容器的基础上
		orderDao.save(order);

		//扣除库存
		stockDao.subStock(order.getName());
		System.out.println("下单成功");

	}
}
