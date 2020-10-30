package com.base.page30;

/**
 * @Name Student2
 * @Author 18057
 * @Createed 16:37 2020/10/29
 * @Description 学生类
 * @Version 2.0.0
 */
public class Student2 {

    public Student2(){

    }
    //**********字段*************//
    public String name;
    protected int age;
    char sex;
    private String phoneNum;



    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", sex=" + sex
                + ", phoneNum=" + phoneNum + "]";
    }
}
