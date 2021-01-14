package com.zmm.day0615;

import java.util.HashMap;

/**
 * @Name Maps
 * @Author 900045
 * @Created by 2021/1/13 0013
 */
public class Maps {

	static final int NUMBER = 3;

	static final int MAXIMUM_CAPACITY = 1 << 30;

	static final int CAPACITY_MAXIMUM_CAPACITY = 1 << 31;

	public static <K, V> HashMap<K, V> newHashMapWithExpectedSize(int expectedSize) {
		int capacity = capacity(expectedSize);
    	System.out.println(capacity);
		return new HashMap(capacity);
	}

  	static int capacity(int expectedSize) {
		if (expectedSize < NUMBER) {
			return expectedSize + 1;
		} else {
			return expectedSize < MAXIMUM_CAPACITY ? (int) ((float) expectedSize / 0.75F + 1.0F) : CAPACITY_MAXIMUM_CAPACITY - 1;
		}
	}
}
