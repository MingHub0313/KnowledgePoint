package com.zmm.day0701.realize.extend;

/**
 * @Name Test
 * @Author 900045
 * @Created by 2020/7/1 0001
 */
public class Test {

    public static void main(String[] args) {
        Outter outter = new Outter();
        System.out.println(outter.name());
        System.out.println(outter.age());

        //执行结果:
        // A类的私有域
        // 20
    }


    /**
     * 一、创建内部类:
     * 			1.在外部类的外部 创建非静态内部类    [非静态的类 需要通过 new 来调用]
     * 				语法 : 外部类.内部类 内部类对象 = new 外部类().new 内部类();
     * 				举例 ： Outer.Inner in = new Outer().new Inner();
     * 			2.在外部类的外部 创建静态内部类		[静态的类直接通过类 . 来调用]
     * 				语法 ： 外部类.内部类 内部类对象 = new 外部类.内部类();
     * 				Outer.Inner in = new Outer.Inner();
     * 			3.在外部类的内部 创建内部类 [在外部类内部创建内部类，就像普通对象一样直接创建]
     * 				语法 ：Inner in = new Inner();
     *
     * 	二、内部类的分类
     * 		在Java中内部类主要分为 成员内部类、静态内部类、方法内部类、匿名内部类
     *
     * 	1.成员内部类
     * 		1). 成员内部类的内部不允许存在任何static变量或方法 正如成员方法中不能有任何静态属性 （成员方法与对象相关、静态属性与类有关）
     */
}
