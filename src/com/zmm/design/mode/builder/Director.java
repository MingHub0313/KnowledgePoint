package com.zmm.design.mode.builder;

/**
 * @author 900045
 * @description:
 * @name Director
 * @date By 2021-05-11 10:57:01
 */
public class Director {

	/**
	 * 指挥装机人员组装电脑
	 * @author: 900045
	 * @date: 2021-05-11 10:57:16
	 * @throws 
	 * @param builder: 
	 * @return: void
	 **/
	public void Construct(Builder builder){
		builder. BuildCPU();
		builder.BuildMainBoard();
		builder.BuildHD();
	}
}
