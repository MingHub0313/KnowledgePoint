package com.base.page31;

/**
 * @Name Person
 * @Author 18057
 * @Createed 14:12 2020/10/30
 * @Description 人类
 * @Version 1.0.0
 */
public class Person {

    //将 Book 当作成员变量

    Book book1 = new Book("book1成员变量初始化");
    static Book book2;

    /**
     * 将此 static 代码块拆开 即是该Person类的 成员变量
     */
    static {
        book2 = new Book("static成员book2成员变量初始化");
        book4 = new Book("static成员book4成员变量初始化");
    }

    public Person(String msg) {
        System.out.println(msg);
    }

    Book book3 = new Book("book3成员变量初始化");
    static Book book4;

    public static void funStatic() {
        System.out.println("static修饰的funStatic方法");
    }
}
