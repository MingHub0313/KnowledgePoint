package com.base.page31;

/**
 * @Name A3
 * @Author 18057
 * @Createed 15:20 2020/10/30
 * @Description A3类
 * @Version 1.0.0
 */
public class A3 {

    public A3() {
        System.out.print("(A3) ");
    }

    private static A3 a = new A3();

    static {
        System.out.print("static ");
    }

    {
        System.out.print("A3 ");
    }
}
