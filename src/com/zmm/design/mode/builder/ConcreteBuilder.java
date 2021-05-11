package com.zmm.design.mode.builder;

/**
 * @author 900045
 * @description:
 * @name ConcreteBuilder
 * @date By 2021-05-11 10:57:58
 */
public class ConcreteBuilder extends Builder {

	/**
	 * 创建产品实例
	 */
	Computer computer = new Computer();
	
	
	@Override
	public void BuildCPU() {
		computer.Add("组装CPU");
	}

	@Override
	public void BuildMainBoard() {
		computer.Add("组装主板");
	}

	@Override
	public void BuildHD() {
		computer.Add("组装硬盘");
	}

	@Override
	public Computer GetComputer() {
		return computer;
	}
}
