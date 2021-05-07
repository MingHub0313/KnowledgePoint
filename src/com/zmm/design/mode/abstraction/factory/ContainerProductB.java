package com.zmm.design.mode.abstraction.factory;

/**
 * 具体产品类(继承抽象产品类)
 * @author 900045
 * @description:
 * @name ContainerProductB
 * @date By 2021-05-07 16:43:01
 */
public class ContainerProductB extends ContainerProduct {

	@Override
	public void method1() {
		System.out.println("生产出了容器产品B");
	}
}
