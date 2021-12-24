package com.base.page31;

/**
 * @Name A1
 * @Author 18057
 * @Createed 15:10 2020/10/30
 * @Description A1类
 * @Version 1.0.0
 */
public class A1 {
    private static A1 a = new A1();

    static {
        System.out.print("static ");
    }

    {
        System.out.print("A1 ");
    }
}
