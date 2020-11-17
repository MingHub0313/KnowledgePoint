package com.zmm.day1117;

/**
 * @Name Test 局部内部类
 * @Author 900045
 * @Created by 2020/11/17 0017
 */
public class Test {

	/**
	 * 方法内部类不允许使用 访问权限修饰符; public private protected 均不允许
	 * 方法内部类对外部完全隐藏,除了创建这个类的方法可以访问它以外,其它地方法均不能访问
	 * 方法的访问区域范围就是方法内部类可以访问的区域范围
	 * @param args
	 */

	public static void main(String[] args){
		sayHello("shu");
	}

	static void sayHello(String hello){
		/**
		 * InnerClass 的访问范围 和 sayHello 访问范围一致
		 */
		class InnerClass{
			public void run(String name){
        		System.out.println(name);
        		System.out.println(hello);
			}
		}
		InnerClass innerClass = new InnerClass();
		innerClass.run("hello");

	}
}
