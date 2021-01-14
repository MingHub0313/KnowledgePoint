package com.alibaba.cautious01;

import java.util.ArrayList;
import java.util.List;

/**
 * @Name ArrayListIssue
 * [强制]
 * 		ArrayList 的 subList 结果不可强制转成 ArrayList,否则会抛出 ClassCastException异常.
 * 		即java.util.RandomAccessSubList cannot be cast to java.util.ArrayList.
 * 说明:	subList 返回的是 ArrayList的内部类 SubList,并不是 ArrayList,
 * 			而是ArrayList的一个视图,对于SubList子列表的所有操作最终会反映到原列表上.
 * 	小结:
 * 		List的 subList 方法并没有创建一个新的 List,而是使用了原List的视图,这个视图使用内部类SubList表示.
 * 		所以,我们不能把 subList方法返回的 List 强转换成 ArrayList等 类,因为他们之间没有继承关系.
 * 	
 * 	另外视图和原 List 的修改还需要注意几点,尤其是他们之间的相互影响:
 * 		1.对父(sourceList) 子(subList) List 做的非结构性修改,都会影响到彼此
 * 		2.对子 List 做的结构性修改,操作同样会映射到父 List 上
 * 		3.对父 List 做的结构性修改,会抛出异常	ConcurrentModificationException
 * 	
 * 	所以在 subList 场景中,高度注意对原集合元素的增加或删除,均会导致子列表的遍历、增加、删除 产生 ConcurrentModificationException 异常
 * 	
 * 	那么如何创建新的 List
 * 		如果需要对 subList 作出修改,又不改变原有的 List. 那么可以创建 subList的一个拷贝:
 * 		
 * 		subList = Lists.newArrayList(subList);
 * 		list.stream().skip(start).limit(end).collect(Collectors.toList());	
 * 		
 * @Author 900045
 * @Created by 2021/1/13 0013
 */
public class ArrayListIssue {
	public static void main(String[] args) {
		
		// 示例
		List<String> names = new ArrayList<String>() {{
			add("Hollis");
			add("ming");
			add("H");
		}};
		// Returns a view of the portion of this list between the specified inclusive, and exclusive
		// 返回此列表的部分的视图 
		//查看源码该方法返回一个 SubList ,这个类是 ArrayList中的一个内部类.该类单独定义了 set、get、size、add、remove等方法
		List subList1 = names.subList(0, 1);
		//调用SubList方法的时候,会通过调用 SubList的构造函数创建一个 SubList.
		//构造函数中把原来的List以及该List的部分属性直接赋值给自己的一些属性.
		//也就是说SubList并没有重新创建一个List ,
		// 而是直接引用了原有的List(返回了父类的视图),只是指定了一下他要使用的元素的范围而已(从fromIndex[包含]到toIndex[不包含]).
		//ArrayList subList = names.subList(0, 1) 
		System.out.println(subList1);

		// 非结构性改变 SubList
		List<String> sourceList1 = new ArrayList<String>() {{
			add("H");
			add("O");
			add("L");
			add("L");
			add("I");
			add("S");
		}};

		List subList2 = sourceList1.subList(2, 5);
		System.out.println("sourceList1 ： " + sourceList1);
		System.out.println("sourceList1.subList(2, 5) 得到 List ：");
		System.out.println("subList2 ： " + subList2);
		subList2.add("666");
		System.out.println("subList2.add(666) 得到 List ：");
		System.out.println("subList2 ： " + subList2);
		System.out.println("sourceList1 ： " + sourceList1);
		//我们尝试对 subList2 的结构进行改变,即向其追加元素,那么得到的结果是 sourceList的结构也同要发生了改变



		// 结构性改变 SubList
		List<String> sourceList2 = new ArrayList<String>() {{
			add("H");
			add("O");
			add("L");
			add("L");
			add("I");
			add("S");
		}};

		List subList3 = sourceList2.subList(2, 5);
		System.out.println("sourceList2 ： " + sourceList2);
		System.out.println("sourceList2.subList(2, 5) 得到 List ：");
		System.out.println("subList3 ： " + subList3);
		//结构性改变
		sourceList2.add("666");
		System.out.println("sourceList2.add(666) 得到 List ：");
		System.out.println("subList3 ： " + subList3);
		System.out.println("sourceList2 ： " + sourceList2);
		//当我们尝试对 sourceList2 的结构进行改变,即向其追加元素,结果发现抛出了 ConcurrentModificationException
		
	}
}
