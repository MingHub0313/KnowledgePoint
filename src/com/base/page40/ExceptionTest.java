package com.base.page40;

import org.junit.Test;

/**
 * @Name ExceptionTest
 * @Author 18057
 * @Createed 17:16 2020/10/30
 * @Description
 * @Version
 */
public class ExceptionTest {

    /**
     * Question 1.Java 的异常处理机制
     * 答案 : 抛出异常、捕捉异常
     * 抛出异常 -- 当一个方法出现错误已发异常时 方法创建异常对象并交付运行时系统 异常对象中包含了 异常类型和异常出现时的程序状态
     *              运行时系统负责寻找处置异常的代码执行
     * 捕获异常 -- 在方法抛出异常之后,运行时系统转为寻找合适的异常处理器.潜在的异常处理是异常发生时依次存留在调用栈中的方法集合
     *              当异常处理期所能处理的异常类型与方法抛出的类型相符时,即为合适的异常处理器.
     *              运行时系统从发生异常的方法开始,依次回查调用栈中的方法,直至找到含有合适异常的处理器的方法并执行.
     *              当运行时系统遍历调用栈而未找到合适的异常处理器 则运行时系统终止 也意味着Java程序的终止.
     *
     */

    /**
     * Question 2.检查式异常 与 运行时异常(未受检查)的区别
     *
     * 检查式异常 -- java 编译器要求我们必须对出现的这些异常进行 catch 处理.
     *          比如 : ClassNotFoundException、FileNotFoundException、InstantiationException
     *
     *  运行时异常 -- 我们可以不处理.由虚拟机接管.
     *          比如: NullPointerException、NumberFormatException、IndexOutBoundsException
     *
     *
     */

    /**
     * Question 3 Java 异常体系描述一下
     *  Throwable 是由 错误(Error) 或者 异常的超类(Exception)
     *      Error 是由 VirtualMachineError 和 AWTError 组成
     *      Exception 是由 IOException 和 RuntimeException 组成
     *          IOException 是由 EOFException 和 FileNotFoundException 组成
     *          RuntimeException 是由 ClassCastException 、IndexOutBoundsException、NumberFormatException、NullPointerException、
     *                              ArrayStoreException(数据存储异常,操作数组时类型不一致)....
     *
     *
     */
    @Test
    public void test(){

    }
}
