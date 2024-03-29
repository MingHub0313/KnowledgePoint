package com.zmm.day0619;

import java.util.Stack;

/**
 * @Name MyQueue
 * @Author 900045
 * @Created by 2020/6/19 0019
 */
public class MyQueue {

    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        int t = peek();
        s2.pop();
        return t;
    }

    public int peek() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
