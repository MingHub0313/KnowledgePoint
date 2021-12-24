package com.zmm.day0521.spring.ioc.pojo;

/**
 * 描述:  库存
 *
 * @Name Stock
 * @Author 900045
 * @Created by 2020/5/21 0021
 */
public class Stock {

    private Integer num = 1000;
    private String name;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }
}
