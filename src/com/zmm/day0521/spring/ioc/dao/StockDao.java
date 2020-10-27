package com.zmm.day0521.spring.ioc.dao;

/**
 * @Name StockDao
 * @Author 900045
 * @Created by 2020/5/21 0021
 */
public interface StockDao {

	/**
	 * 减库存
	 * @param name
	 * @return
	 */
	void subStock(String name);
}
