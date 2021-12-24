package com.zmm.a;

import java.util.Arrays;

/**
 * @author 900045
 * @description:
 * @name MyArrayList01
 * @date By 2021-04-14 11:05:57
 */
public class MyArrayList01<E> {
	
	private E[] array;
	
	private int size;

	/**
	 * 数组的初始长度
	 */
	private int initialCapacity;
	
	private static final int DEFAULT_CAPACITY = 10;

	public MyArrayList01() {
		this.initialCapacity = DEFAULT_CAPACITY;
		this.array = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList01(int initialCapacity) {
		if (initialCapacity > 0){
			this.initialCapacity = initialCapacity;
			this.array = (E[]) new Object[initialCapacity];
		} else {
			throw new IllegalArgumentException("Illegal Capacity: "+ initialCapacity);
		}
	}
	
	/**
	 * 获取集合的大小
	 * @author: 900045
	 * @date: 2021-04-14 14:08:39
	 * @throws 
	
	 * @return: int
	 **/
	public int size(){
		return size;
	}
	
	// 1.存在的问题 当初始化(指定)数组的长度后,一直 add() 当超过数组的长度就会报错
	// 2.解决的方案 对数组进行扩容
	// 3.何时扩容呢	在集合的 size == 数组的长度
	// 4.如何扩容呢	可以将数组的的长度 * + 操作,对于计算机位运算效率是很高的 >> [右移一位相当于除2取余] 或者 << [左移一位相当于 *2]
	// 5.扩容的本质	创建新的数组,将旧数组中的数据拷贝到新数组中
	
	
	/**
	 * 添加元素
	 * @author: 900045
	 * @date: 2021-04-14 14:13:56
	 * @throws 
	 * @param e: 
	 * @return: boolean
	 **/
	public boolean add(E e){
		// 3.何时扩容呢
		if (size > initialCapacity){ 
			grow();
		}
		// 下标从 0开始存储array[0] array[1]...
		this.array[size] = e;
		size++;
		return true;
	}
	
	// 1.怎么删除元素	本质还是数组的拷贝 a b c d e f index ====> a b (c) d e f index + 1
	// 2.如何拷贝元素	从删除元素的那个下标位置+1开始移动
	// 3.array 原数组	index + 1	从哪里开始移动	newArray 新数组 index 新数组的下标开始移动的索引 elementMoved 移动多少 size - 1 - index
	// 4.数组中最后一个位置空了出来,需要移除,集合个数需要
	
	/**
	 * 指定某个元素删除
	 * @author: 900045
	 * @date: 2021-04-14 15:46:19
	 * @throws 
	 * @param e: 
	 * @return: void
	 **/
	public void remove(E e){
		if (e == null) {
			for (int i = 0; i< array.length; i++) {
				if (array[i] == null){
					remove(i);
				}
			}
		} else {
			for (int i = 0; i< array.length; i++) {
				if (e.equals(array[i])){
					remove(i);
				}
			}
		}
    	
	}

	/**
	 * 根据下标删除某个元素
	 * @author: 900045
	 * @date: 2021-04-14 15:42:41
	 * @throws 
	 * @param index: 
	 * @return: E
	 **/
	public E remove(int index) {
		checkRange(index);
		// 删除元素 --> 数组拷贝
		// a b c d e f index
		// a b d e f index + 1
		// 5 - 2(index)
		final int newSize = size - 1;
		E oldValue = array[index];
		System.arraycopy(array, index + 1, array, index, newSize - index);
		// 将最后的位置 置空
		array[size = newSize] = null;
		return oldValue;
	}

	/**
	 * 通过下标获取元素
	 * @author: 900045
	 * @date: 2021-04-14 15:08:12
	 * @throws 
	 * @param index: 
	 * @return: E
	 **/
	public E get(int index){
		// 10 index 0|0-9
		checkRange(index);
		return array[index];
	}
	
	/**
	 * 指定位置插入元素
	 * @author: 900045
	 * @date: 2021-04-14 15:17:25
	 * @throws 
	 * @param index: 
	 * @param e: 
	 * @return: E
	 **/
	public E set(int index,E e){
		checkRange(index);
		E oldValue = array[index];
		array[index] = e;
		return oldValue;
	}

	private boolean checkRange(int index){
		if (index < 0 || index > size -1){
			throw new IndexOutOfBoundsException();
		}
		return true;
	}
	
	private E[] grow(){
		return grow(size+1);
	}
	
	private E[] grow(int minCapacity){
		// 4.如何扩容呢
		return this.array = Arrays.copyOf(array,size+(size>>1));
	}
	
	
	public boolean contains(E e){
		return indexOf(e) >=0;
		
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public int indexOf(E e){
		return indexOfRange(e,0,size);
	}
	
	int indexOfRange(E e,int start,int end){
		if (e == null) {
			for (int i = start; i< end; i++) {
				if (array[i] == null){
					return i;
				}
			}
		} else {
			for (int i = start; i< end; i++) {
				if (e.equals(array[i])){
					return i;
				}
			}
		}
		return -1;
	}
	
}
