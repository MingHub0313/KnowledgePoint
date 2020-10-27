package com.base.page29;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Name ReadFileTest
 * @Author 900045
 * @Created by 2020/10/27 0027
 */
public class ReadFileTest {

	private Logger log= LoggerFactory.getLogger(ReadFileTest.class);

	/**
	 * FileReader 		类是将文件按字符流的方式读取 char数组 或者 String
	 * FileInputStream 	类是将文件按字节流的方式读取文件byte组数
	 *
	 * 具体操作:
	 * 			1).首先获取一个文件句柄.  File file = new File(); file即为文件句柄.
	 * 			2).通过这条线路读取信息:  new FileInputStream(file); 目前这个信息已经读进内存中
	 * 			3).此时就需要 	InputStreamReader()这个方法进行解读刚才装进内存中的数据
	 * 			4).解读完,然后输出.要转换成IO可以识别的数据.需要调用字节码读取的方法 BufferedReader().
	 * 				获取该对象下的 readline()方法读取文件中的每一行数据.
	 */

	@Test
	public void test(){

	}
}
