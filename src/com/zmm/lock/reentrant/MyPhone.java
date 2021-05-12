package com.zmm.lock.reentrant;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 900045
 * @description:
 * @name MyPhone
 * @date By 2021-05-12 17:03:56
 */
public class MyPhone implements Runnable {

	Lock lock = new ReentrantLock();

	public synchronized void sendMsg(){
		System.out.println(Thread.currentThread().getName() + "\t invoked sendMsg");
		sendEmail();
	}

	public synchronized void sendEmail(){
		System.out.println(Thread.currentThread().getName() + "\t##### invoked sendEmail");
	}

	@Override
	public void run() {
		get();
	}

	public void get(){
		lock.lock();
		try{
			System.out.println(Thread.currentThread().getName() + "\t invoked get");
			set();
		}finally {
			lock.unlock();
		}
	}

	public void set(){
		lock.lock();
		try{
			System.out.println(Thread.currentThread().getName() + "\t###### invoked set");
		}finally {
			lock.unlock();
		}
	}
}
