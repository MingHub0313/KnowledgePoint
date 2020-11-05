package com.base.page44;

/**
 * @Name B
 * @Author 18057
 * @Createed 16:48 2020/11/3
 * @Description B类
 * @Version 1.0.0
 */
public class B {

    private String name;

    private Integer age;

    public B(String name, Integer age) {
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
    public String toString() {
        return "B{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
