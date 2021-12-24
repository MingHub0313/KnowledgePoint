package com.base.page45;

/**
 * @Name Person
 * @Author 18057
 * @Createed 11:22 2020/11/5
 * @Description 基础类
 * @Version 1.0.0
 */
public abstract class Person {

    public  Person(){
        System.out.println("调用的是父类的无参构造函数");
    }

    public   Person(int i) {
        System.out.println("调用的是父类的有参构造函数");
    }


}
