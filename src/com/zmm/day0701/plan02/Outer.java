package com.zmm.day0701.plan02;

/**
 * @Name Outer
 * @Author 900045
 * @Created by 2020/7/1 0001
 */
public class Outer {

	private String outStr ="Outer中的字符串";
	public String getOutStr() {
		return outStr;
	}


	public void fun(){  /** 2 */
		//this表示当前对象
		/** 3 */
		Inner in = new Inner(this);
		in.print();                /** 5 */
	}
}
