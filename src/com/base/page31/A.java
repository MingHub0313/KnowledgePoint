package com.base.page31;

/**
 * @Name A
 * @Author 18057
 * @Createed 14:39 2020/10/30
 * @Description A类
 * @Version 1.0.0
 */
public class A {
    private static A a = new A();

    static {
        System.out.print("static ");
    }

    public A() {
        System.out.print("A ");
    }
}
