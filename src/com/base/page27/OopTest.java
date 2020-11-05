package com.base.page27;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Name OopTest
 * @Author 900045
 * @Created by 2020/10/27 0027
 */
public class OopTest {

	/**
	 * 面向对象开发的六个基本原则:
	 * 单一职责:类的功能要单一(高内聚),不能包罗万象,在oop中 如果只让一个类完成它该做的事,而不涉及与它无关的领域就是践行了高内聚的原则.
	 * 开放封闭:一个模块对于拓展是开放的,对于修改是封闭的.
	 * 		两个要点:
	 * 				1).抽象是关键: 一个系统中如果没有抽象类或接口系统就没有有扩展点;
	 * 				2).封装可变形: 将系统中的各种可变因素封装到一个继承结构中,如果多个可变因素混杂在一起,系统将变的复杂而混乱.
	 * 里氏替换:任何时候都可以用子类型替换父类型,子类一定是增加父类的能力而不是减少父类的能力,因为子类比父类的能力更多.
	 * 依赖倒置:面向接口编程 -- 声明方法的参数类型、方法的返回类型、变量的引用类型时,尽可能使用抽象类型而不用具体类型.
	 * 			因为抽象类型可以被它的任何一个子类所替代
	 * 合成聚合复用:优先使用聚合或合成关系复用代码.
	 * 接口隔离:接口要小而专 , 绝不能大而全.臃肿的接口是对接口的污染,既然接口表示能力,那么一个接口只应该描述一种能力,接口也应该高内聚.
	 *
	 * 迪米特法则: 最少知识原则,一个对象应当对其他对象有尽可能少的了解
	 * 项目中用到的原则 : 单一职责、开放封闭、合成聚合复用(String 类)、接口隔离
	 *
	 * Java 创建对象的四种方法:
	 * 1.使用 new 关键字
	 * 2.使用 Class 类的 newInstance 方法 ---- 该方法调用无参的构造器创建对象(反射) Class.forName.newInstance
	 * 3.使用 clone 方法
	 * 4.反序列化
	 *
	 * 使用构造器的三种 : new 反射的两种 newInstance
	 * 没有构造器的两种 : clone 和 反序列化
	 */


	/**
	 * String StringBuffer StringBuilder hashCode equals
	 *
	 * 一、String StringBuffer StringBuilder的区别:
	 * 	1.都是final类,都不允许被继承;
	 * 	2.String 长度是不可变的 ; StringBuffer 、StringBuilder;
	 * 	3.StringBuffer 是线程安全的;StringBuilder 是线程不安全的.但它们两个所有的方法都是相同的,只是 StringBuffer的类在方法上添加 synchronized
	 * 	4.StringBuilder 比 StringBuffer 拥有更好的性能.
	 * 	5.如果一个String 类型的字符串,在编译时就可以确定是一个字符串常量,则编译完成之后,字符串会自动拼接成一个常量.
	 * 		此时的 String 速度 比 StringBuilder 和 StringBuffer 的性能好的多.
	 *
	 * 	1、运算速度比较 StringBuilder > StringBuffer > String
	 * 	2. 线程安全性 StringBuilder(非线程安全)  StringBuffer(线程安全的)
	 */

	/**
	 * String 中的 hashCode 以及 toString
	 * Question 1.String 有重写 Object 的 hashCode 和 toString吗? 如果重写 equals 不重写 hashCode会出现什么问题?
	 * 		答案: 	String 重写了 Object 的 hashCode 和 toString.
	 * 				当equals方法被重写时,通常有必要重写hashCode方法,以维护hashCode方法的常规协定,该协定声明相对等的两个对象必须有相同的hashCode
	 * 			总结: 	两个对象的 equals 为 true 时,两个对象的 hashCode 为 true
	 * 					两个对象的 hashCode 为 false 时 , 两个对象的 equals 必定为 false
	 * 					两个对象的 hashCode 为 true 时,两个对象的 equals 不一定为 true
	 * 				在存储散列集合(Set集合),如果原对象 equals(新对象),但是没有对hashCode重写,即两个对象拥有不同的hashCode,
	 * 				则在集合中将会存储两个值相同的对象,从而导致混淆.因此在重写 equals 方法时,必须重写hashCode方法.
	 * Question 2.大家都知道源码怎么实现的.故意构造相同的 hash的字符串进行攻击,怎么处理?那jdk7怎么办?
	 * 		怎么处理构造相同hash的字符串进行攻击?
	 * 		分析:	当客户端提交一个请求并附带参数的时候,web应用服务器会把我们的参数转化成一个HashMap存储(key,value)
	 * 				但是物理存储结构是不同的,key值会被转化为 hashCode,这个hashCode有会被转成数组的下标: 0-->value
	 * 				不同的String 就会产生相同的hashCode而导致的碰撞,碰撞后的物理存储结构可能如下: 0-->value1-->value2
	 *
	 * 		解决方案:	1.限制 post 和 get 的参数个数 越少越好
	 * 					2.限制 post 数据包的大小
	 * 					3.WAF
	 *
	 * 		jdk7如何处理hashCode字符串攻击?
	 * 			HashMap会动态的使用一个专门的 TreeMap实现来替换它.
	 *
	 */


	/**
	 *  Question 3.String 不可变?  --final 修饰
	 *  首先 因为 String 不可变,如果 String 不是 final,那么就可以有子类继承String类 ,然后子类覆盖其方法,使得这些方法可以修改字符串
	 *  这样就违背了 String 的不可变性.
	 *
	 *  不可变原因:
	 *  			1).提高效率: 比如一个字符串 String s1 = "abc" , "abc"被放到常量池里面去了, 然后再 String s2 = "abc"
	 *  			并不会复制字符串"abc",只会多个引用指向原来那个常量,这样就提高了效率,而这一前提是 String 不可变.
	 *  			如果可变,那么多个引用指向同一个字符串常量,我们就可以通过一个引用改变字符串,然后其他引用就被影响了
	 *  			2).安全: String 常被用来表示 url,文件路径
	 *  			3).String不可变,那么他的 hashCode 就一样,不用每次重新计算了.
	 *  注意:
	 *  	1.String 类是被 final 进行修饰的 ,不能被继承
	 *  	2.在用'+'链接字符串的时候会创建新的字符串(对象)
	 *  	3.String s = new String("Hello World"); 可能创建两个对象 也可能创建一个对象.
	 *  		如果静态区中有 "Hello World"字符串常量,则仅仅在堆中创建一个对象.
	 *  		如果静态区中没有 则堆上和静态区中都需要创建对象.
	 *  	4.在java 中,通过使用 '+' 符号串联字符串的时候,实际上底层会转成 StringBuild 实例的 append()方法来实现的.
	 *
	 */



	private Logger log= LoggerFactory.getLogger(OopTest.class);

	@Test
	public void test(){
		// 1.创建一个String对象str 并赋值abc给str
		String str = "abc";
		System.out.println(str);
		// 2.JVM会再创建一个新的str对象 并将原有str的值和de加起来再赋值给新的str;
		// 而第一个创建的str对象被JVM的垃圾回收机制（GC）回收掉.所以str实际上并没有被更改,而是重新创建一个新的对象.
		str = str + "de";
		System.out.println(str);
		// 3.Java中对String对象进行的操作实际上是一个【不断创建并回收对象的过程】 因此在运行速度上很慢.
	}

	@Test
	public void test2(){

		String str = "obj" + "etc";
		StringBuilder stringBuilder = new StringBuilder().append("obj").append("etc");
		System.out.println(str);
		System.out.println(stringBuilder.toString());

		//上述代码中String的操作速度反而要比StringBuilder快
		// 这是因为在JVM眼里 第1行的代码操作和 String str = "object"代码是完全一样的 所以很快


		String str1 = "obj";
		String str2 = "etc";
		String str3 = str1 + str2;
		// 这一操作就没有 StringBuilder快了 这是因为有创建新对象和销毁对象
    	System.out.println(str3);
	}
}
