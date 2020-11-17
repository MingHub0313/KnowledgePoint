package com.zmm.day1117;

/**
 * @Name OutClass
 * @Author 900045
 * @Created by 2020/11/17 0017
 */
public class OutClass {

	String name = "OutClass";

	static String nickName = "out";

	void hello(){
    	System.out.println("执行成员方法 hello");
	}

	static void hi(){
		System.out.println("执行静态方法 hi");
	}

	/**
	 * 内部类需要外部类的外部使用 通过普通方法 返回的 new对象.
	 * @return
	 */
	public InnerClass getInnerClass(){
		return new InnerClass();
	}

	/**
	 * InnerClass 就像 OutClass内部成员一样可以访问name nickName属性 / helli hi 等方法
	 *
	 * 说明 :
	 * 	1.成员内部类就像外部类的普通方法一样 可以访问外部类的属性及方法;
	 * 	2.成员内部类内部不允许 存在任何静态变量或静态方法;
	 * 		因为成员内部类是属于对象的 而静态变量、静态方法会优先于类的对象存在 因此不允许成员内部类存在静态属性和方法
	 * 	3.成员内部类如果需要外部类的外部使用 则需要通过调用外部类的普通方法创建.
	 *
	 * 	OutClass outClass = new OutClass();
	 * 	OutClass.InnerClass innerClass = outClass.getInnerClass();
	 *
	 * 	访问范围详解:
	 * 	编译器在进行编译的时候,会将成员内部类单独编译成一个字节码文件 通过 javap -v OutClass$InnerClass 反编译 OutClass$InnerClass.class
	 * 	OutClass$InnerClass.class
	 * 	final *.OutClass this$0; // InnerClass 存在一个指向外部类对象的引用
	 * 	descriptor: Lcom/OutClass;
	 * 	flags: (0x1010) ACC_FINAL , ACC_SYNTHETIC
	 *
	 * 	可以看出成员内部类对象的创建依赖外部类的实例对象,在没有外部类实例之前是无法创建内部类.
	 * 	【因为非静态内部类对象存在一个指向外部类对象的引用;也因此内部类可以随意访问外部类的成员】
	 */
	class InnerClass{
		String innerName = "InnerClass";

		void test(){
      		System.out.println(innerName);
			System.out.println(name);
			System.out.println(nickName);
			hello();
			hi();
		}
	}

	/**
	 * 用 static 修饰的内部类称之为静态内部类 , 静态内部类和非静态内部类之间存在一个最大的区别:
	 * 	【非静态内部类在编译完成之后隐含的保存着一个引用,该引用是指向创建它的外围类,但是静态类没有】
	 * 	静态内部类的创建不需要依赖外部类可以直接创建
	 * 	静态内部类不可以使用任何外部类的非static 属性和方法
	 * 	静态内部类可以存在自己的成员变量包括非静态和静态属性和方法
	 */
	static class StaticInnerClass{
		String innerName = "staticInnerClass";
		static String staticName = "staticName";

		/**
		 * 无法使用 OutClass 的普通属性 和 普通方法,静态的可以属性 和 方法可以 使用
		 * 普通的 属性 和 方法  : name 和 hello()
		 * 静态的 属性 和 方法 : innerName nickName staticName 和 hi()
		 */
		void test(){
			System.out.println(innerName);
			System.out.println(nickName);
			System.out.println(staticName);
			hi();
		}
	}
}
