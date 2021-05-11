package com.zmm.design.mode.builder;

/**
 * 定义组装的过程 (Builder):组装电脑的过程
 * @author 900045
 * @description:
 * @name Builder
 * @date By 2021-05-11 10:54:34
 */
public abstract class Builder {

	/**
	 * 第一步：装CPU 声明为抽象方法，具体由子类实现
	 * @author: 900045
	 * @date: 2021-05-11 10:55:02
	 * @throws 
	 * @return: void
	 **/
	public abstract void  BuildCPU();
	
	/**
	 * 第二步：装主板 声明为抽象方法，具体由子类实现
	 * @author: 900045
	 * @date: 2021-05-11 10:55:15
	 * @throws 
	 * @return: void
	 **/
	public abstract void BuildMainBoard();

	/**
	 * 第三步：装硬盘 声明为抽象方法，具体由子类实现
	 * @author: 900045
	 * @date: 2021-05-11 10:55:28
	 * @throws 
	 * @return: void
	 **/
	public abstract void BuildHD();

	/**
	 * 返回产品的方法：获得组装好的电脑
	 * @author: 900045
	 * @date: 2021-05-11 10:55:39
	 * @throws 
	 * @return: com.zmm.design.mode.builder.Computer
	 **/
	public abstract Computer GetComputer();
}
