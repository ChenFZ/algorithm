/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: SelectionSort
 * Author:   Chen FZ
 * Date:     2021/2/14 11:26
 * Description: 选择排序（Selection Sort）
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.sortingAlgorithm;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br>
 * 〈选择排序（Selection Sort）〉
 *
 * @author Chen FZ
 * @create 2021/2/14
 * @since 1.0.0
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        selection_sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /*
    * 简单选择排序是最简单直观的一种算法，基本思想为每一趟从待排序的数据元素中选择最小（或最大）的一个元素作为首元素，
    * 直到所有元素排完为止，简单选择排序是不稳定排序。

    　在算法实现时，每一趟确定最小元素的时候会通过不断地比较交换来使得首位置为当前最小，交换是个比较耗时的操作。
    * 其实我们很容易发现，在还未完全确定当前最小元素之前，这些交换都是无意义的。我们可以通过设置一个变量min，
    * 每一次比较仅存储较小元素的数组下标，当轮循环结束之后，那这个变量存储的就是当前最小元素的下标，此时再执行交换操作即可。代码实现很简单，一起来看下。
    * */
    public static void selection_sort(int[] nums) {
        //1. 简单快排
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            if (min != i) {
                QuickSort.swap(nums, i, min);
            }
        }
    }
}
