package com.base.page20;

import java.io.FileNotFoundException;

/**
 * 子类
 */
public class SubClass extends SuperClass {

    /**
     * 子类的检查异常类型要小于等于父类的检查异常
     *
     * @throws FileNotFoundException
     */
    public void method() throws FileNotFoundException {
        System.out.println(" 子类 --> hello");
    }
}
