package com.zmm.design.mode.abstraction.factory;

/**
 * 抽象工厂类
 * @author 900045
 * @description:
 * @name Factory
 * @date By 2021-05-07 16:39:07
 */
public abstract class Factory {

	/**
	 * 定义具体工厂的公共接口
	 * @return
	 */
	
	public abstract AbstractProduct manufactureContainer();

	/**
	 * 模具的
	 * @return
	 */
	public abstract AbstractProduct manufactureMould();
	
}
