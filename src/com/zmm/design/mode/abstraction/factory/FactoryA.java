package com.zmm.design.mode.abstraction.factory;

/**
 * 具体工厂类（继承抽象工厂类） 生产模具+容器产品
 * @author 900045
 * @description:
 * @name FactoryA
 * @date By 2021-05-07 16:45:06
 */
public class FactoryA extends Factory {

	@Override
	public AbstractProduct manufactureContainer() {
		return new ContainerProductA();
	}

	@Override
	public AbstractProduct manufactureMould() {
		return new MouldProductA();
	}
}
