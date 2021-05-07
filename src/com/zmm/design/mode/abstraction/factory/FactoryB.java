package com.zmm.design.mode.abstraction.factory;

/**
 * 具体工厂类（继承抽象工厂类） 生产模具+容器产品
 * @author 900045
 * @description:
 * @name FactoryB
 * @date By 2021-05-07 16:45:52
 */
public class FactoryB extends Factory {

	@Override
	public AbstractProduct manufactureContainer() {
		return new ContainerProductB();
	}

	@Override
	public AbstractProduct manufactureMould() {
		return new MouldProductB();
	}
}
