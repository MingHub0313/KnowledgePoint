package com.zmm.lock;

import com.zmm.lock.spin.SpinLockDemo;

import java.util.concurrent.TimeUnit;

/**
 * @author 900045
 * @description:
 * @name LockMain
 * @date By 2021-05-12 16:56:47
 */
public class LockMain {

  public static void main(String[] args) throws InterruptedException {
	  SpinLockDemo spinLockDemo = new SpinLockDemo();

	  // 自旋锁
	  spinLock(spinLockDemo);
  }

	/**
	 * 
	 * 自旋锁好处：循环比较获取直到成功为止，没有类似wait的阻塞
	 * 通过cas操作完成自旋锁，A线程先进来调用myLock方法自己持有锁5秒钟
	 * B随后进来后发现当前又线程持有锁，不是null，所以只能通过自旋等待，直到A释放锁后B随后抢到
	 * 
	 *
	 *
	 *
	 *
	 * @param spinLockDemo
	 * @throws InterruptedException
	 */
	private static void spinLock(SpinLockDemo spinLockDemo) throws InterruptedException {
		new Thread(() -> {
			spinLockDemo.myLock();
  
			try {
				TimeUnit.SECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			spinLockDemo.myUnLock();
  
		},"A").start();

		TimeUnit.SECONDS.sleep(1);

		new Thread(() -> {
			spinLockDemo.myLock();
  
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			spinLockDemo.myUnLock();
		},"B").start();
	}
}
