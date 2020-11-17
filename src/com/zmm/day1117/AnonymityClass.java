package com.zmm.day1117;

/**
 * @Name AnonymityClass
 * @Author 900045
 * @Created by 2020/11/17 0017
 */
public class AnonymityClass {

	/**
	 *匿名内部类就是一个没有名字的方法内部类,因此特点和方法与方法内部类完全一致
	 * 匿名内部类必须继承一个抽象或者实现接口
	 * 匿名内部类没有类名,因此没有构造方法
	 * 匿名内部类使得编码更加简洁
	 * @param args
	 */

	public static void main(String[] args){
		Outer outer = new Outer();
    outer.hello(
        new Interface() {
          @Override
          public void test() {
            System.out.println("test Interface");
          }
        });
	}

	interface Interface{
		/**
		 * 测试方法
		 */
		void test();
	}
}
