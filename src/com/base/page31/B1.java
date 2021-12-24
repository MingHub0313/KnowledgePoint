package com.base.page31;

/**
 * @Name B1
 * @Author 18057
 * @Createed 15:11 2020/10/30
 * @Description B1类
 * @Version 1.0.0
 */
public class B1 extends A1 {

    public B1() {
        System.out.println("B1 ");
    }

    public static void main(String[] args) {
        B1 b = new B1();
        // 打印结果 : A1 static A1 B1

        /**
         * 匿名构造器 构造器 优先于 静态代码块执行 静态代码块只执行一次
         */
    }
}
