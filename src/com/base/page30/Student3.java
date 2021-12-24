package com.base.page30;

/**
 * @Name Student3
 * @Author 18057
 * @Createed 16:44 2020/10/29
 * @Description 学生类
 * @Version 3.0.0
 */
public class Student3 {

    //**************成员方法***************//
    public void show1(String s) {
        System.out.println("调用了：公有的，String参数的show1(): s = " + s);
    }

    protected void show2() {
        System.out.println("调用了：受保护的，无参的show2()");
    }

    void show3() {
        System.out.println("调用了：默认的，无参的show3()");
    }

    private String show4(int age) {
        System.out.println("调用了，私有的，并且有返回值的，int参数的show4(): age = " + age);
        return "abcd";
    }
}
