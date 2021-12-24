package com.zmm.design.mode.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义具体产品类 (Product):电脑
 * @author 900045
 * @description:
 * @name Computer
 * @date By 2021-05-11 10:52:26
 */
public class Computer {

	/**
	 * 电脑组件的集合
	 */
	private List<String> parts = new ArrayList<String>();

	/**
	 * 用于将组件组装到电脑里
	 * @author: 900045
	 * @date: 2021-05-11 10:53:11
	 * @throws 
	 * @param part: 
	 * @return: void
	 **/
	public void Add(String part){
		parts.add(part);
	}

	/**
	 * 展示
	 * @author: 900045
	 * @date: 2021-05-11 10:53:25
	 * @throws 
	
	 * @return: void
	 **/
	public void Show(){
		for (int i = 0;i<parts.size();i++){
			System.out.println("组件" + parts.get(i) + "装好了");
		}
		System.out.println("电脑组装完成，请验收");
	}
}
