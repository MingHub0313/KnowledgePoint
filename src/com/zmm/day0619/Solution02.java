package com.zmm.day0619;

import java.util.Stack;

/**
 * @Name Solution02
 * @Author 900045
 * @Created by 2020/6/19 0019
 */
public class Solution02 {

	public static void main(String[] args){
		ListNode listNode = new ListNode(3);
		ListNode listNode2 = new ListNode(4);
		ListNode listNode3 = new ListNode(2);
		ListNode listNode4 = new ListNode(7);
		listNode3.setNext(listNode4);
		listNode2.setNext(listNode3);
		listNode.setNext(listNode2);
		int[] ints = printListReversing(listNode);
		forArray(ints);
	}

	private static void forArray(int []array){
		for (int i=0;i<array.length;i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static int[] printListReversing(ListNode head) {
		if (head == null) {
			return null;
		}
		Stack<Integer> stack = new Stack<>();
		// 获取参数值  ListNode  3  -> 4 -> 2
		ListNode cur = head;
		// 定义记录长度的数
		int cnt = 0;
		while (cur  != null) {
			// 将 ListNode 得 值 push 到 队列中 stack
			stack.push(cur.val);
			// 将参数改变为下一个元素
			cur = cur.next;
			// 长度加一
			++cnt;
		}
		// 定义数组 cnt
		int[] res = new int[cnt];
		int i = 0;
		while (!stack.isEmpty()) {
			// 将 队列中的值 取出
			res[i++] = stack.pop();
		}
		return res;
	}
}
