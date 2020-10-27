package com.zmm.day0701.plan01;

/**
 * 内部类： 所谓内部类就是在一个类内部进行其他类结构的嵌套操作
 * @Name Outer
 * @Author 900045
 * @Created by 2020/7/1 0001
 */
public class Outer {

	/**
	 * 内部类的优点:
	 * 				1.部类与外部类可以方便的访问彼此的私有域 (包括私有方法、私有属性)
	 * 				2.内部类是另外一种封装，对外部的其他类隐藏
	 * 				3.内部类可以实现java的单继承局限
	 * 内部类的缺点:
	 * 				1.结构复杂
	 */

	private String str ="外部类中的字符串";

	/**
	 * 在外部类中定义一个方法，该方法负责产生内部类对象并调用print()方法
	 */
	public void fun(){
		//内部类对象
		Inner in = new Inner();
		//内部类对象提供的print
		in.print();
		// 运行结果：外部类中的字符串
	}


	/**
	 * 定义一个内部类
	 */
	class Inner{
		private String inStr= "内部类中的字符串";

		/**
		 * 定义一个普通方法
		 */
		public void print(){
			//调用外部类的str属性
			System.out.println(str);
		}
	}
}
