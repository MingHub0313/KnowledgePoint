package com.zmm.design.mode.factory;

/**
 * @author 900045
 * @description:
 * @name Factory
 * @date By 2021-04-30 17:14:59
 */
public class Factory {

	public static Product Manufacture(String ProductName){
		//工厂类里用switch语句控制生产哪种商品;
		//使用者只需要调用工厂类的静态方法就可以实现产品类的实例化.
		switch (ProductName){
			case "A":
				return new ProductA();
			case "B":
				return new ProductB();
			case "C":
				return new ProductC();
			default:
				return null;
		}
	}
}
