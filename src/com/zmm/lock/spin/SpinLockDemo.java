package com.zmm.lock.spin;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author 900045
 * @description:
 * @name SpinLockDemo
 * @date By 2021-05-12 16:55:56
 */
public class SpinLockDemo {

	

	/**
	 * 原子引用
	 */
	AtomicReference<Thread> atomicReference = new AtomicReference<>();


	public void myLock(){
		Thread thread = Thread.currentThread();
		System.out.println(thread.getName() + "\t come in ");
		while (!atomicReference.compareAndSet(null,thread)){
		}
	}

	public void myUnLock(){
		Thread thread = Thread.currentThread();
		atomicReference.compareAndSet(thread,null);
		System.out.println(thread.getName() + "\t invoked myUnLock");
	}
	
}
