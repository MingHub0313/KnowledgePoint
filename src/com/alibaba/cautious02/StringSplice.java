package com.alibaba.cautious02;

/**
 * @Name StringSplice
 * @Author 900045
 * @Created by 2021/1/14 0014
 */
public class StringSplice {

	/**
	 * String 是 Java 中一个不可变的类,所以他一旦被实例化就无法被修改.
	 * 不可变类的实例一旦被创建,其成员变量的值就不能被修改.这样设计有很多的好处,比如可以缓存 hashCode、使用更加便利以及更加安全
	 * 
	 * 字符串不变性与字符串拼接
	 * 		所有的字符串拼接,都是重新生成了一个新的字符串
	 * 	
	 * CASE1:	使用 + 拼接字符串
	 * 		在 java中,拼接字符串最简单的方式就是直接使用符号 + 来拼接. 如:
	 * 		
	 * 		String weChat = "Ming";
	 * 		String introduce = "每日更新 Java 相关技术文章";
	 * 		String hollis = weChat + "," + introduce;
	 * 		说明:有人把 Java 中使用的 + 拼接字符串的功能理解为运算符重载.其实并不是,Java 是不支持运算符重载的.--- Java提供的一个语法糖.
	 * 		语法糖: 糖衣语法,是由英国计算机科学家彼得·兰丁发明的一个术语，指计算机语言中添加的某种语法,
	 * 				这种语法对语言的功能没有影响，但是更方便程序员使用。语法糖让程序更加简洁，有更高的可读性。
	 * 			
	 * 		反编译(jad)后的内容 如下:
	 * 		String weChat = "Ming";
	 * 		String introduce = "\u6BCF\u65E5\u66F4\u65B0Java\u76F8\u5173\u6280\u672F\u6587\u7AE0"; //每日更新 Java 相关技术文章
	 * 		String hollis = (new StringBuilder()).append(weChat).append(",").append(introduce).toString();
	 * 		可以看见,字符串常量在拼接过程中,是将 String 转成了 StringBuilder 后	,使用其 append 方法进行处理.
	 * 		即 Java 中的 + 对字符串的拼接,其实现原理是使用 StringBuilder.append	
	 * 			
	 * 	CASE2:	concat
	 * 		除了使用 + 拼接字符串,还可以使用 String类中的 concat 方法来拼接字符串. 如:
	 * 		
	 * 		String weChat = "Ming";
	 * 		String introduce = "每日更新 Java 相关技术文章";
	 * 		String hollis = weChat.concat(",").concat(introduce);
	 * 	
	 * 		查看源码:
	 * 		public String concat(String str) {
	 * 			int otherLen = str.length();
	 * 			if (otherLen == 0) {
	 * 				return this;	
	 * 			}
	 * 			int len = value.length;
	 * 			char buf[] = Arrays.copyOf(value, len + otherLen);
	 * 			str.getChars(buf, len);
	 * 			return new String(buf, true);	
	 * 		}
	 * 		
	 * 		1.创建一个字符串数组, 长度是已有字符串和待拼接字符串长度之和
	 * 		2.再把两个字符串的值复制到新的字符数组中
	 * 		3.最后使用这个字符数组创建一个新的 String 对象并返回	【经过concat方法,其实是new 了一个新的String 这也说明了字符串的不变性】
	 * 	
	 * 	CASE3:	StringBuffer
	 * 		Java 还提供了用于定义可变字符串变量的 StringBuffer 类,它的对象是可以扩充和修改的. 如:
	 * 	
	 * 		String weChat = "Ming";
	 * 		String introduce = "每日更新 Java 相关技术文章";
	 * 		StringBuffer hollis = weChat.append(",").append(introduce);
	 * 	
	 * 	CASE4:	StringBuilder
	 * 		
	 * 		除了 StringBuffer 以外,还有一个类 StringBuilder 也可以使用,其用法和 StringBuilder 类似.
	 * 	
	 * 		StringBuffer 和 StringBuilder 的实现原理:
	 * 		和 String 类 类似,StringBuilder 类也封装了一个字符数组 定义如下: char[] value;
	 * 		与 String 不同的是,它并不是 final的,所以它是可以修改的.另外,
	 * 		与 String 不同,字符数组中不一定所有位置都已经被使用,它是一个实例变量,表示数组中已经使用的字符个数 定义如下: int count;
	 * 	
	 * 		查看源码:
	 * 		public StringBuilder append(String str) {
	 * 		 	super.append(str);
	 * 		 	return this;	
	 * 		}
	 * 		该类继承了 AbstractStringBuilder 类,看下其 	append 方法:
	 * 		public AbstractStringBuilder append(String str) {
	 * 			if (str == null)
	 * 				return appendNull();
	 * 			int len = str.length();
	 * 			ensureCapacityInternal(count + len);
	 * 			str.getChars(0, len, value, count);
	 * 			count += len;
	 * 			return this;	
	 * 		}
	 * 		append 会直接拷贝字符到内部的字符数组中,如果字符数组长度不够,会进行扩展.
	 * 		
	 * 		StringBuffer 和 StringBuilder 类似,最大的区别就是 StringBuffer是线程安全的.
	 * 		public synchronized StringBuffer append(String str) {
	 * 			toStringCache = null;
	 * 			super.append(str);
	 * 			return this;
	 * 		}	
	 * 	
	 * 	CASE5:	StringUtils.join
	 * 		除了 JDK 中内置的字符串拼接方法,还可以使用一些开源类库中提供的字符串拼接方法名
	 * 		如 apache.commons 中提供的 StringUtils类. 如:
	 * 	
	 * 		String weChat = "Ming";
	 * 		String introduce = "每日更新 Java 相关技术文章";
	 * 		System.out.println(StringUtils.join(weChat, ",", introduce));
	 * 		
	 * 		说明: StringUtils 中提供的 join 方法,最主要的功能是: 将数组或集合以某拼接字符拼接到一起形成新的字符串,如:
	 * 	
	 * 		String []list ={"Ming"," 每日更新 Java 相关技术文章 "};
	 * 		String result= StringUtils.join(list,",");
	 * 		System.out.println(result);
	 * 		//输出: Ming, 每日更新 Java 相关技术文章
	 * 	
	 * 		查看 StringUtils.join 的源代码可知,其实它也是通过 StringBuilder 来实现的.
	 * 	
	 * 	测试:
	 * 		long t1 = System.currentTimeMillis();
	 * 		String str = "Ming";
	 * 		for (int i = 0; i < 50000; i++) {
	 * 		 	String s = String.valueOf(i);
	 * 		 	str += s;	
	 * 		}
	 * 		long t2 = System.currentTimeMillis();
	 * 		System.out.println("+ cost:" + (t2 - t1));	
	 * 	
	 * 	效率比较:
	 * 		+ cost:5119
	 * 		StringBuilder cost:3
	 * 		StringBuffer cost:4
	 * 		concat cost:3623
	 * 		StringUtils.join cost:25726	
	 * 		用时从短到长的对比是: StringBuilder < StringBuffer < concat < + < StringUtils.join
	 * 		StringBuffer 在 StringBuilder 的基础上,做了同步处理,所以在耗时上相对多一些.
	 * 	
	 * 		从结果上看 + 拼接字符串的耗时与 StringBuilder 相差 1000多倍?
	 * 		分析可知 + 	拼接字符串实现原理也是使用的 StringBuilder 那为什么还差这么高呢?
	 * 	
	 * 		反编译代码:
	 * 		long t1 = System.currentTimeMillis();
	 * 		String str = "Ming";
	 * 		for (int i = 0; i < 50000; i++) {
	 * 			String s = String.valueOf(i);
	 * 			str = (new StringBuilder()).append(str).append(s).toString();	
	 * 		}
	 * 		long t2 = System.currentTimeMillis();
	 * 		System.out.println((new StringBuilder()).append("+ cost:").append(t2 - t1).toString());	
	 * 		
	 * 		我们可以看到,反编译后的代码,在 for 循环中,每次都是 new 了一个 StringBuilder
	 * 		然后再把 String 转成 StringBuilder , 再进行 append.
	 * 		而频繁的创建对象当然要消耗很多时间了,不仅仅会消耗时间,频繁的创建对象,还会造成内存资源的浪费.
	 * 	
	 * 		所以《阿里巴巴Java开发手册》建议:循环体内,字符串的连接方式 应该使用 StringBuilder 的 append方式进行扩展.
	 *
	 * 		
	 */


	/**
	 * 总结:
	 * 		本文介绍了什么是字符串拼接，虽然字符串是不可变的，但是还是可以通过新建字符串的方式来进行字符串的拼接.
	 * 		常用的字符串拼接方式有五种，分别是使用 +、 concat、 StringBuilder、StringBuffer以及StringUtils.join
	 * 		
	 * 		由于字符串拼接过程中会创建新的对象,所以如果要在一个循环体中进行字符串拼接，就要考虑内存问题和效率问题
	 * 		因此,进过对比,我们发现,直接使用 StringBuilder 的方式是效率最高的.
	 * 		因为 StringBuilder 天生就是设计来定义可变字符串和字符串的变化操作的.
	 * 	但是,还要强调的是:
	 * 		1.如果不是在循环体中进行字符串拼接的话，直接使用 + 就好了
	 * 		2.如果在并发场景中进行字符串拼接的话，要使用 StringBuffer(线程安全) 来代替 StringBuilder(线程不安全)
	 */
}
