package com.zmm.day0618;

import org.junit.Test;

/**
 * @Name SearchTest
 * @Author 900045
 * @Created by 2020/6/18 0018
 */
public class SearchTest {

    private static int NUMBER = 0;

    public static void main(String[] args) {
        int[] array = {26, 32, 16, 46, 28, 68, 97, 75, 9};
        forArray(array);
    }

    @Test
    public void biSearch() {
        int[] array = {15, 26, 38, 46, 59, 68, 73, 86, 91};
        int search = biSearch(array, 91);
        System.out.println(search);
        System.out.println(array[search]);
    }

    @Test
    public void bubbleSort() {
        int[] array = {26, 32, 16, 46, 28, 68, 97, 75, 9};
        bubbleSort(array, array.length);
        foreach(array);
    }

    @Test
    public void insertSort() {
        int[] array = {26, 32, 16, 46, 28, 68, 97, 75, 9};

        insertSort(array);
        foreach(array);
    }

    private static void forArray(int[] array) {
        for (int i = 1; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


    public static void insertSort(int[] array) {
        // 从下标为1 开始遍历 每一个元素 [默认第一个元素的位置是正确的]
        for (int i = 1; i < array.length; i++) {
            // 1. 取出每一次遍历的元素
            int root = array[i];
            // 2. 获取遍历元素的前一个下标
            int index = i - 1;
            while (index >= 0 && root < array[index]) {
                // 如果 目标元素大于 遍历元素 则 将目标元素 赋值于后一个元素
                array[index + 1] = array[index];
                // 标志 --
                index--;
            }
            // 否则 再将遍历元素 赋值于 后一个元素   执行到这里 index 要么是 -1  要么就是 root> 遍历元素
            array[index + 1] = root;
        }
    }

    private static void foreach(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void bubbleSort(int[] array, int target) {
        // 外层控制循环次数
        for (int i = 0; i < target; i++) {
            // 从下一个元素开始比较 一共要比多少次   第一轮循环 i=0 ,j需要比 array.length - 0;  第二轮循环 i=1,j需要比 array.length - 1
            for (int j = 1; j < target - i; j++) {
                System.out.println("前一个:" + array[j - 1] + " <--->" + "后一个:" + array[j]);
                if (array[j - 1] > array[j]) {
                    int temp;
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
            NUMBER++;
            System.out.println("第" + NUMBER + "次查询!");
            foreach(array);

        }
    }

    public static int biSearch(int[] array, int target) {
        // 1.定义两个指针  高位 和 低位
        int high = array.length - 1, low = 0;
        // 2.定义临时变量
        int mid;
        while (low <= high) {
            NUMBER++;
            System.out.println("第" + NUMBER + "次查询!");
            mid = (low + high) / 2;
            System.out.println("---->中间位是多少" + mid);
            // 3.取出该下标对应的值
            int middle = array[mid];
            // 4.然后比较 大小
            if (middle == target) {
                return mid;
            } else if (middle > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
