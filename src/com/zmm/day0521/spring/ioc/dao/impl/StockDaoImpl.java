package com.zmm.day0521.spring.ioc.dao.impl;

import com.zmm.day0521.spring.ioc.dao.StockDao;

/**
 * @Name StockDaoImpl
 * @Author 900045
 * @Created by 2020/5/21 0021
 */
public class StockDaoImpl implements StockDao {

    @Override
    public void subStock(String name) {
        System.out.println("商品:" + name + " 库存扣减成功");
    }
}
