package com.zmm.day0619;

import org.junit.Test;

/**
 * @Name Solution03Test
 * @Author 900045
 * @Created by 2020/6/19 0019
 */
public class Solution03Test {

    @Test
    public void fibonacci() {
        int number = fibonacci(8);
        System.out.println(number);
    }

    /**
     * 求斐波那契数列的第n项，n从0开始
     *
     * @param n 第n项
     * @return 第n项的值
     */
    public int fibonacci(int n) {
        int m = 2;
        if (n < m) {
            return n;
        }

        int a = 1, b = 1;
        // 1 + 1 + 2 + 3 + 5 + 8 + 13 ...
        for (int i = 2; i < n; ++i) {
            b = a + b;
            a = b - a;
        }
        return b;
    }

    /**
     * 题目描述 :
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）.
     * 解法 :
     * 跳上 n 级台阶，可以从 n-1 级跳 1 级上去，也可以从 n-2 级跳 2 级上去。所以 --> f(n) = f(n-1) + f(n-2)
     * f(5) = f(4) + f(3) ;  ===> f(5) = 3 + 2 + 3 ;
     * f(4) = f(3) + f(2) ;  ===> f(4) = 3 + 2 ;
     * a = 1, b = 2;
     * b = a + b , a = b - a ;  ===> b = 1 + 2 = 3 , a = 3 - 1 = 2 ;
     * ===> b = 3 + 2 = 5 , a = 5 - 2 = 3 ;
     * ===> b = 5 + 3 = 8 , a = 8 - 3 = 5 ;
     */

    @Test
    public void jumpFloor() {
        int number = jumpFloor(5);
        System.out.println(number);
    }

    /**
     * @param target 跳上的那一级台阶
     * @return 多少种跳法
     */
    public int jumpFloor(int target) {
        int m = 3;
        if (target < m) {
            // 如果台阶小于三级 则是几阶就有几种跳法
            return target;
        }
        // a : 跳一阶  b : 跳二阶
        int a = 1, b = 2;
        // 循环
        for (int i = 2; i < target; ++i) {
            b = a + b;
            // 此时的 b = a + b ;     即将 a + b 的值赋值给 b
            // 此时的 a = a + b - a ; 即将 b 的值赋值给 a
            a = b - a;
        }
        return b;
    }
}
