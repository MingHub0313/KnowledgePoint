package com.zmm.lock.reentrant;

import java.util.concurrent.TimeUnit;

/**
 * @author 900045
 * @description:
 * @name ReentrantLockDemo
 * @date By 2021-05-12 17:06:28
 */
public class ReentrantLockDemo {

	/**
	 * 指的是同一线程外层函数获得锁之后，内层递归函数仍然能获取该锁的代码，
	 * 在同一个线程在外层方法获取锁的时候，在进入内层方法会自动获取锁。
	 * 也就是说，线程可以进入任何一个它已经拥有的锁所同步着的代码快。
	 * 
	 * t1 invoked sendMsg()        t1线程在外层方法获取锁的时候
	 * t1 ##### invoked sendEmail  t1在进入内层方法会自动获取锁
	 * 
	 * 
	 * t2 invoked sendMsg()
	 * t2 ##### invoked sendEmail
	 * @param args
	 * @throws InterruptedException
	 */
  public static void main(String[] args) throws InterruptedException {
	  MyPhone myPhone = new MyPhone();

	  new Thread(() -> {
		  myPhone.sendMsg();
	  },"t1").start();

	  new Thread(() -> {
		  myPhone.sendMsg();
	  },"t2").start();


	  TimeUnit.SECONDS.sleep(1);
	  System.out.println("\n\n\n\n");

	  Thread t3 = new Thread(myPhone,"t3");
	  t3.start();

	  Thread t4 = new Thread(myPhone,"t4");
	  t4.start();
  }
}
