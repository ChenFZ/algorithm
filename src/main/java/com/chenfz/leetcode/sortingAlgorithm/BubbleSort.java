/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: BubbleSort
 * Author:   Chen FZ
 * Date:     2021/2/14 11:22
 * Description: 冒泡排序（Bubble Sort）
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.sortingAlgorithm;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br>
 * 〈冒泡排序（Bubble Sort）〉
 *
 * @author Chen FZ
 * @create 2021/2/14
 * @since 1.0.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        bubble_sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void bubble_sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    QuickSort.swap(nums, i, j);
                }
            }
        }
    }
}
