package com.base.page45;

/**
 * @Name Student
 * @Author 18057
 * @Createed 11:36 2020/11/5
 * @Description 学生类
 * @Version 1.0.0
 */
public class Student extends Person {

    /**
     * 默认调用父类的无参构造函数,同样必须显式声明
     */

    Student(){
        System.out.println("子类的无参构造函数");
    }

    /**
     * 想调用父类抽象类的有参构造函数必须先显式声明,然后通过super函数调用
     * @param i
     */
    Student(int i) {
        super(i);
        //必须显示的调用父类构造方法,super代表父类对象
        System.out.println("子类的有参构造函数\n");
    }
}
