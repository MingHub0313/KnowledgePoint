package com.zmm.design.mode.abstraction.factory;

/**
 * 具体产品类(继承抽象产品类)
 * @author 900045
 * @description:
 * @name MouldProductA
 * @date By 2021-05-07 16:43:37
 */
public class MouldProductA extends MouldProduct {

	@Override
	public void method1() {
		System.out.println("生产出了模具产品A");
	}
}
