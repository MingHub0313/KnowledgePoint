package com.zmm.a;

import java.util.Iterator;

/**
 * @author 900045
 * @description:
 * @name TestArrayList
 * @date By 2021-04-13 16:40:07
 */
public class TestArrayList {

  public static void main(String[] args) {
	  //testArrayList();
	  testMyArrayList01();
	  
  }


	private static void testMyArrayList01() {
		MyArrayList01<Integer> myArrayList01 = new MyArrayList01<>(6);
    	System.out.println("初始化集合的size:===========>"+myArrayList01.size());
		myArrayList01.add(2);
		myArrayList01.add(5);
		myArrayList01.add(8);
		myArrayList01.add(12);
		System.out.println("使用 [add] 方法后的size:===========>"+myArrayList01.size());

		System.out.println("使用 [get] 方法得到的元素:===========>"+myArrayList01.get(2));
		myArrayList01.set(2,10);
		System.out.println("使用 [set] 方法后的size:===========>"+myArrayList01.size());
		System.out.println("第二次使用 [get] 方法得到的元素:===========>"+myArrayList01.get(2));
		System.out.println("使用 [remove] 方法后的size:===========>"+myArrayList01.size());
		myArrayList01.remove(2);
		myArrayList01.add(26);
		myArrayList01.add(27);
		myArrayList01.add(34);
		
		
	}
	private static void testArrayList() {
		ArrayList<Integer> arrayList2 = new ArrayList<>(2);
		ArrayList<Integer> arrayList1 = new ArrayList<>();
		//添加元素 boolean add(E e)
		arrayList1.add(30);
		arrayList1.add(12);
		arrayList1.add(12);
		arrayList2.add(12);
		arrayList2.add(34);
		arrayList2.add(12);

		Iterator<Integer> iterator1 = arrayList1.iterator();
		while (iterator1.hasNext()){
			System.out.println(iterator1.next());
		}

		Iterator<Integer> iterator2 = arrayList2.iterator();
		while (iterator2.hasNext()){
			System.out.println(iterator2.next());
		}
	}
}
