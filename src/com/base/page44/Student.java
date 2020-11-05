package com.base.page44;

import org.jetbrains.annotations.NotNull;

/**
 * @Name Student
 * @Author 18057
 * @Createed 16:27 2020/11/3
 * @Description 学生类
 * @Version 1.0.0
 */
public class Student implements Comparable<Student>{

    private String name;

    private Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int compareTo(@NotNull Student stu) {
        // this.name - stu.name 与 compareTo 等同
        return age.compareTo(stu.age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
