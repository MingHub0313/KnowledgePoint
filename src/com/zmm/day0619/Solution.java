package com.zmm.day0619;

/**
 * @Name Solution
 * @Author 900045
 * @Created by 2020/6/19 0019
 */
public class Solution {

	/**
	 * 给定一个长度为 n 的整数数组 nums，数组中所有的数字都在 0∼n−1 的范围内。
	 *
	 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
	 *
	 * 请找出数组中任意一个重复的数字
	 *
	 * 注意：如果某些数字不在 0∼n−1 的范围内，或数组中不包含重复数字，则返回 -1;
	 * @param args
	 */

	public static void main(String[] args){
		int []array = {2, 3, 5, 4, 3, 2, 6, 7};
		int i = duplicateInArray(array);
    	System.out.println(i);
	}

	/**
	 * 解法:
	 *  由题可知 数组长度为 n，所有数字都在 0~n-1 范围内.如果元素不重复，那么数组应该就是 [0, 1, 2, ...n-1]（假设给数组排完了序）
	 *  也就是说，递增排序后，数组中的元素值与其对应的下标应该是相同的，即下标为 0 的元素值也是 0，以此类推。
	 *
	 *  1: 首先，我们可以遍历数组，若存在元素不在 0~n-1 的范围内，直接返回 -1
	 *  2: 接着，再次遍历数组，若下标 i 与对应元素 nums[i] 不同，即 nums[i] != i，我们应该把 nums[i] 这个元素交换到正确的位置 nums[i]上
	 *     交换前，先判断 nums[i] 与 nums[nums[i]] 这两个元素是否相同，相同说明存在重复元素，直接返回，否则进行 swap 交换
	 *     交换过后，我们需要再次判断 i 位置上的元素，因此，我们使用 while 循环
	 * @param nums
	 * @return
	 */

	public static int duplicateInArray(int[] nums) {
		// 获取长度
		int length = nums.length;

		// [1 2 3 4 5 6 7 8]  -->值
		// [0 1 2 3 4 5 6 7]  -->下标   0~n-1
		// 第一步 遍历 是否有不存在的值
		for (int num : nums){
			if (num<0 || num>=length){
				return -1;
			}
		}
		// 若存在数组元素不在[0, n-1] 的范围内，直接返回-1
		for (int i=0; i<length; i++){
			//每一个元素 与其 下标的值 都不一样
			while (nums[i] != i){

				if (nums[i] == nums[nums[i]]){
					// 说明位置i与位置nums[i]上的元素相同，直接返回该重复元素
					return nums[i];
				}
				swap(nums, i, nums[i]);
			}
		}
		return -1;
	}

	private static void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

}
