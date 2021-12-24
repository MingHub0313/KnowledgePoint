package com.zmm.lock.read.write;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author 900045
 * @description:
 * @name MyCache
 * @date By 2021-05-12 17:11:54
 */
public class MyCache {

	private volatile Map<String,Object> map = new HashMap<>();
	final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	public void put(String key,Object value){
		readWriteLock.writeLock().lock();
		try{
			System.out.println(Thread.currentThread().getName() + "\t 开始写入:" + key);
			map.put(key,value);
			System.out.println(Thread.currentThread().getName() + "\t 写入完成");
		}finally {
			readWriteLock.writeLock().unlock();
		}
	}

	public void get(String key){
		readWriteLock.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName() + "\t 开始读取");
			Object result = map.get(key);
			System.out.println(Thread.currentThread().getName() + "\t 读物完成:" + result);
		}finally {
			readWriteLock.readLock().unlock();
		}
	}
}
