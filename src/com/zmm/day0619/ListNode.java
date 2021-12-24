package com.zmm.day0619;

/**
 * @Name ListNode
 * @Author 900045
 * @Created by 2020/6/19 0019
 */
public class ListNode {

    int val;

    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
