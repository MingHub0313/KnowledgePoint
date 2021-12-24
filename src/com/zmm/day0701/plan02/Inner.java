package com.zmm.day0701.plan02;

/**
 * @Name Inner
 * @Author 900045
 * @Created by 2020/7/1 0001
 */
public class Inner {

    private String inStr = "Inner中的字符串";
    private Outer out;

    /**
     * 构造注入
     *
     * @param out
     */
    public Inner(Outer out) {    /** 3 */
        /** 4.为Inner中的out变量初始化 */
        this.out = out;
    }

    public void print() {    /** 6 */
        /** 7 */
        System.out.println(out.getOutStr());
    }
}
