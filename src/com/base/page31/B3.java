package com.base.page31;

/**
 * @Name B3
 * @Author 18057
 * @Createed 15:22 2020/10/30
 * @Description B3类
 * @Version 1.0.0
 */
public class B3 extends A3 {

    public B3() {
        System.out.println("B3 ");
    }

    public static void main(String[] args) {
        // 只是加载 A3.class 初始化
        System.out.print("00000 ");
        B3 b = new B3();

        //打印结果 :   A3           (A3)        static          00000       A3              (A3)        B3
        //          匿名构造器       构造器     静态代码块               匿名构造器       构造器        B类

        //静态变量 静态代码块 优先于 System.out.print("00000 ") 执行.
        //对象初始化的顺序:
        //【静态成员变量 > 静态代码块 > 成员变量 > 构造代码块 > 构造方法】
    }
}
