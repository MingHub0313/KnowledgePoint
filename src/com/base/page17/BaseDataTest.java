package com.base.page17;



import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @Name BaseDataTest
 * @Author 900045
 * @Created by 2020/10/27 0027
 */
public class BaseDataTest {

	private Logger log= LoggerFactory.getLogger(BaseDataTest.class);

	@Test
	public void test(){
		byte byte1 = -128;
		log.info("> byte 上限值:{}",byte1);
		byte byte2 = 127;
		log.info("> byte 下限值:{}",byte2);

		byte byte3 = 0;
		log.info("> byte 默认值:{}",byte3);

		//自动装箱:Java编译器在 基本数据类型 和 对应的对象包装类型 之间做一个【转化】

		/**
		 * 	基础数据	包装		占用字节	取值范围			默认值
		 *  byte		Byte		1			-128 ~ 128-1		0
		 *  boolean		Boolean		1			true false			false
		 *  short		Short		2			-2^15 ~ 2^15-1		0
		 *  char		Char		2			0 ~ 2^16-1			'\u0000'
		 *  int			Integer		4			-2^31 ~ 2^31-1		0
		 *  float		Float		4								0.0F
		 *  long		Long		8								0
		 *  double		Double		8								0.0D
		 *
		 */
	}

	/**
	 *  Question 1.String 转出 int 类型 , 判断能不能转? 如果转?
	 */
	@Test
	public void questionOne(){
		String s = "2147483648";
		int i = 0;
		try {
			i = Integer.parseInt(s);
		}catch (NumberFormatException n){
			log.error("{}不是数字类型",s);
		}
		log.info("转出的结果 {}",i);
		/**
		 * 答案 : 可以转 但是需要异常处理 ---> NumberFormatException
		 * 1).当要转的是 字母 内容不是数字时  	如 : String s = "mmm";
		 * 2).当要转的是 null 					如 : String s = null;
		 * 3).当要转的超过 int 上限(下限)时		如 : String s = "12326544451545"; 2^31 = 2 147 483 648
		 */
	}

	/**
	 *  Question 2.short s1 = 1; s1 = s1 + 1 ;有什么错? short s1 = 1 ; s1 += 1; 有什么错?
	 */
	@Test
	public void questionTwo(){
		short s1 = 1;
		// int s4 = 1;
		// s1 = s1 + 1;
		// s1 = s1 + (short)1;
		// s4 = s1 + s4;
		log.info("short 类型 + int 类型 = int 类型  值为 : {}",s1 + 1);
		// 编译出错 在 s1 + 1 运算时 会自动提升表达式的类型为 int ,那么将 int 赋予给short 类型的变量 s1 就会出现类型转换错误.

		short s2 = 1;
		// s2 += 1;
		log.info("s2 的值 : {}",s2 + 1);
		// += 是 java 语言规定的运算符 java 编译器会对它进行特殊处理【运算符后面的操作数强制装换为前面变量的类型】.因此可以正确编译

		short s3 = 1;
		int i = 1;
		i += s3;
		log.info("i 的值 : {}",i);
	}

	/**
	 *  Java中 = 和 += 的区别
	 *  1). + :	在编译器将右边的表达式结果计算出来后 和左边的变量类型比较精度
	 *  		如果左边的变量精度低于右边的结果的精度 编译器会显式的报错.
	 *  		最后将表达式的结果复制到变量所在的内存区.
	 *  2). += :编译器 自动隐式 直接将+=运算符后面的操作数强制装换为前面变量的类型
	 *  		然后在变量所在的内存区上直接根据右边的操作数修改左边变量内存存储的二进制数值
	 *  		最后达到和赋值运算符相同的目的.
	 *  		与前者相比 由于后者是位操作 效率也较前者高.
	 */

	/**
	 * Question 3. int 和 Integer 的区别
	 * Question 4. equals 和 == 的区别
	 */
	@Test
	public void questionThere(){
		Integer i = new Integer(39);
		Integer j = new Integer(39);

		log.info("二者比较的结果是:-->{} ,使用 equals 比较:  {}",i == j , i.equals(j));

		// 二者比较的结果是:-->false ,使用 equals 比较:  true [包装类型的相等判断应该使用 equals]
		//由于 Integer 变量实际上是对一个 Integer 对象的引用 所以两个通过 new 生成的 Integer 变量永远不相等
		// 因为【new 生成的是两个对象 内存地址不同】

		Integer k = new Integer(39);
		int m = 39;
		log.info("二者比较的结果是:-->{} , 使用 equals 比较:  {}",m == k,k.equals(m));

		// 二者比较的结果是:-->true
		// Integer 和 int 相比较时 只要两个变量的值相等 则结果为 true
		// 因为 【包装类 Integer 和基本数据类型int 比较时 java 会自动拆包装为 int 然后进行比较 实际上就是比较两个 int 变量的值】

		Integer o = new Integer(39);
		Integer p = 39;
		log.info("二者比较的结果是:-->{} ,使用 equals 比较:  {}",o == p,o.equals(p));
		// 二者比较的结果是:-->false,使用 equals 比较:  true
		// 非 new 生成的 Integer 变量 和 new Integer 生成的变量比较时 结果 为false.
		// 因为 【非 new 生成的 Integer 变量指向的是 java 常量池中的对象 而 new Integer 生成的变量指向堆中新建的对象, 两者内存中的地址不同】

		Integer v = 39;
		Integer w = 39;
		log.info("二者比较的结果是:-->{} , 使用 equals 比较:  {}",v == w,v.equals(w));
		//二者比较的结果是:-->true , 使用 equals 比较:  true

		Integer q = 128;
		Integer u = 128;
		log.info("二者比较的结果是:-->{} ,使用 equals 比较:  {}",q == u,q.equals(u));
    // 者比较的结果是:-->false ,使用 equals 比较:  true

    // 两个 非 new 生成的 Integer 对象 进行比较时
    // 如果两个变量的值在区间 -128 ~ 127 之间 	则 比较结果为 true
    // 如果两个变量的值不在此区间 				则 比较结果为 false

    // java 在编译 Integer w = 39 时 会翻译成为 Integer w = Integer.valueOf(39);
    /**
     * public static Integer valueOf(int i) {
	 * 		if (i >= IntegerCache.low && i <= IntegerCache.high)
     * 			return IntegerCache.cache[i + (-IntegerCache.low)];
	 * 		return new Integer(i);
	 * 	}
     */
    // java 对于 -128 ~ 127 之间的数 会进行缓存 , Integer i = 127 时,会将127进行缓存 下次再写 Integer j = 127 时 就会直接从缓存中取 就不会 new
  }

	/**
	 * 1.Integer 是 int 的包装类 int 是 java 的一种基本数据类型
	 * 2.Integer 变量必须实例化后才能使用  而int 变量不需要
	 * 3.Integer实际是对象的引用 当 new 一个 Integer 时 实际上是生成一个指针指向此对象 而 int 是 直接存储数据值
	 * 4.Integer 的默认值是null int 的默认值是 0
	 *
	 * 基本数据类型 使用 == 进行比较的时候  --->比较的是实际值
	 * 引用数据类型 使用 == 进行比较的时候  --->比较的是内存中的存放地址
	 * 引用数据类型 使用 equals (String Integer date) 等重写了 equals 比较的是内容 没有重写 equals 比较的还是内存地址
	 * 注意: StringBuffer 和 StringBuilder 特殊 , == 和 equals 都是比较地址
	 *
	 * 实际值 (内容)  --- (1).基本数据类型比较时  (2).引用数据类型比较时 且 重写了 equals 方法
	 * 地址			  --- (1).引用数据类型比较时  (2).自定义对象 没有重写 equals 方法
	 */
}
