package com.zmm.lock.read.write;

/**
 * @author 900045
 * @description:
 * @name ReadWriteLockDemo
 * @date By 2021-05-12 17:12:59
 */
public class ReadWriteLockDemo {

	/**
	 * 多个线程同时读一个资源类没有任何问题，所以为了满足并发量，读取共享资源应该可以同时进行
	 * 但是 如果又一个线程想去写共享资源了，就不应该再有其它线程可以对该资源进行读或写
	 * 小总结：
	 * 		读-读可以共存
	 * 		读-写不能共存
	 * 		写-写不能共存
	 * 		写操作：原子+独占，中间过程必须一个完整的统一体，中间不许被分割	
	 * @param args
	 */
  public static void main(String[] args) {
	  MyCache myCache = new MyCache();

	  for(int i=0;i<5;i++){
		  int finalI = i;
		  new Thread(() -> {
			  myCache.put(finalI+"",finalI);
		  },"A"+String.valueOf(i)).start();
	  }

	  for(int i=0;i<5;i++){
		  int finalI = i;
		  new Thread(() -> {
			  myCache.get(finalI+"");
		  },"B"+String.valueOf(i)).start();
	  }
  }
}
