package com.zmm.a;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @author 900045
 * @description:
 * @name ArrayList
 * @date By 2021-04-13 16:18:42
 */
public class ArrayList<E> implements Iterable<E> {

	/**
	 * 存储元素的数组
	 */
	private E[] array;

	/**
	 * 默认容量大小
	 */
	private static final int DEFAULT_CAPACITY = 10;

	/**
	 * 数组的初始长度
	 */
	private int initialCapacity;
	
	/**
	 * 容量大小
	 */
	private int size;
	
	
	// =======================构造函数=================
	
	public ArrayList(){
		this.initialCapacity = DEFAULT_CAPACITY;
		this.array = (E[] )new Object[DEFAULT_CAPACITY];
	}
	
	public ArrayList (int initialCapacity){
		if (initialCapacity > 0){
			this.initialCapacity = initialCapacity;
			this.array = (E[] )new Object[initialCapacity];
		} else {
			throw new IllegalArgumentException("Illegal Capacity: "+ initialCapacity);
		}
	}
	
	
	// ====================获取 size ========
	
	
	/**
	 * 返回array中所含元素的个数
	 * @author: 900045
	 * @date: 2021-04-14 10:55:45
	 * @throws 
	 * @return: int
	 **/
	public int size(){
		return size;
	}
	/**
	 * 判断数组是否装满
	 * @author: 900045
	 * @date: 2021-04-13 16:23:14
	 * @throws 
	 * @return: boolean
	 **/
	public boolean isFull(){
		// 当前的size [指的是array中元素的个数] 小于 数组的长度
		// 这里从下标0~size-1表示的是size个元素 那么新添加进去的元素应该处于下标为size的位置上
		if (size < initialCapacity){
			return false;
		}
		return true;
	}
	
	/**
	 * 私有方法 扩容 1.5倍
	 * @author: 900045
	 * @date: 2021-04-13 16:24:45
	 * @throws 
	 * @return: void
	 **/
	private void grow(){
		this.array = Arrays.copyOf(array,size+(size>>1));
	}
	
	/**
	 * 添加元素
	 * @author: 900045
	 * @date: 2021-04-13 16:26:20
	 * @throws 
	 * @param e: 
	 * @return: boolean
	 **/
	public boolean add(E e){
		if (isFull()){
			grow();
		}
		this.array[size++] = e;
		return true;
	}
	
	/**
	 * 自定义更改下标为index的元素值的方法
	 * @author: 900045
	 * @date: 2021-04-14 10:58:33
	 * @throws 
	 * @param index: 
	 * @param e: 
	 * @return: E 原来该下标对应的数据
	 **/
	public E set(int index,E e){
		E oldValue = array[index];
		checkRange(index);
		array[index] = e;
		return oldValue;
	}
	
	/**
	 * 下标检查
	 * @author: 900045
	 * @date: 2021-04-13 16:27:44
	 * @throws 
	 * @param i: 
	 * @return: boolean
	 **/
	private boolean checkRange(int i){
		if ( 0<i && i>= size){
			throw new IndexOutOfBoundsException();
		}
		return true;
	}
	
	/**
	 * 获取当前下标的元素(前提是该下标在合法范围内)
	 * @author: 900045
	 * @date: 2021-04-13 16:28:46
	 * @throws 
	 * @param index: 
	 * @return: E
	 **/
	public E get(int index){
		checkRange(index);
		return (E) array[index];
	}
	
	/**
	 * 判断是否为空集合
	 * @author: 900045
	 * @date: 2021-04-13 16:30:01
	 * @throws 
	 * @return: boolean
	 **/
	public boolean isEmpty(){
		if (size == 0){
			return true;
		}
		return false;
	}
	
	/**
	 * //将 index 后面的元素向前移一位
	 * @author: 900045
	 * @date: 2021-04-13 16:31:28
	 * @throws 
	 * @param index: 
	 * @return: void
	 **/
	private void moveLast(int index){
		while (index + 1 < size){
			array[index] = array[index + 1];
		}
		size--;
	}
	
	/**
	 * 删除一个元素
	 * @author: 900045
	 * @date: 2021-04-13 16:33:52
	 * @throws 
	 * @param o: 
	 * @return: boolean
	 **/
	public boolean remove(Object o){
		if (isEmpty()){
			return false;
		}
		E num = (E) o;
		for(int i = 0; i < size; i++) {
			if (array[i].equals(num)){
				////后面元素向前移动
				moveLast(i);
				return true;
			}
		}
		return false;
	}

	@NotNull
	@Override
	public Iterator<E> iterator() {
		return new Itr(0);
	}


	private  class Itr implements Iterator<E>{
		private int ind;
		
		protected Itr(int start){
			this.ind=start;
		}
		
		@Override
		public boolean hasNext() {
			if (ind < size){
				return true;
			}
			return false;
		}

		@Override
		public E next() {
			if (hasNext()){
				return get(ind++);
			}
			throw new IndexOutOfBoundsException();
		}

		@Override
		public void remove() {
			if(hasNext()) {
				ArrayList.this.remove(ind);
			}
			throw new IndexOutOfBoundsException();
		}
	}
}
