package com.base.page31;

import org.junit.Test;

/**
 * @Name FinallyTest
 * @Author 18057
 * @Createed 16:33 2020/10/30
 * @Description
 * @Version
 */
public class FinallyTest {

    /**
     * finally 一定会被执行 如果 finally 里面有 return 语句则覆盖 try/catch 里的 return.
     *
     * 考点: finally 里没有 return 语句 这时虽然 finally 里有对 数值改变的操作 但真正 return 的值并不会改变.
     */

    /**
     * Question 1. finally 代码块 和 finalize() 方法有什么区别?
     * 答案 : 无论是否抛出异常 finally 代码块都会执行 它主要是用来 释放应用占用的资源
     *  finalize() 方法是 Object类中的一个 protected方法 它是在对象被垃圾回收之前由Java 虚拟机来调用的.
     */

    @Test
    public void test(){

        Integer a = execute1();
        System.out.println("a="+a);
        // a = 40

        Integer b = execute2();
        System.out.println("b="+b);
        // 方法中的b:40
        // b =26

    }

    /**
     * 如果 finally 中有 return 则 返回的是 finally中修改过后的
     * @return
     */
    private Integer execute1() {
        Integer a = 23;
        try{
            a += 3;
            return a;
        }finally {
            a = 40;
            return a;
        }
    }

    /**
     * 如果 finally 没有 return 则 执行 try 中的 return 值任然是try 中的
     * @return
     */
    private Integer execute2() {
        Integer b = 23;
        try{
            b += 3;
            return b;
        }finally {
            b = 40;
            System.out.println("方法中的b:"+b);
        }
    }
}
