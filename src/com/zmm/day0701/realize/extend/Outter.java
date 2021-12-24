package com.zmm.day0701.realize.extend;

/**
 * @Name Outter
 * @Author 900045
 * @Created by 2020/7/1 0001
 */
public class Outter {

    private class InnerClassA extends A {
        public String name() {
            return super.getName();
        }
    }

    private class InnerClassB extends B {
        public int age() {
            return super.getAge();
        }
    }


    public String name() {
        return new InnerClassA().name();
    }

    public int age() {
        return new InnerClassB().age();
    }


}
