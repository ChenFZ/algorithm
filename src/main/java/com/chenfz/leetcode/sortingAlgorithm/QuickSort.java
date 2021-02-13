/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: QuickSort
 * Author:   Chen FZ
 * Date:     2021/2/13 20:20
 * Description: 快速排序（Quicksort） 我们采用左闭右闭的二分写法。
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.sortingAlgorithm;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br>
 * 〈快速排序（Quicksort） 我们采用左闭右闭的二分写法。〉
 *
 * @author Chen FZ
 * @create 2021/2/13
 * @since 1.0.0
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        quick_sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public static void quick_sort(int[] nums, int l, int r) {
        if (l < r) {
            int start = l, end = r;
            int mark = nums[start];
            while (start < end) {
                while (start < end && nums[end] >= mark) {
                    end--;
                }
                while (start < end && nums[start] <= mark) {
                    start++;
                }
                if (start < end) {
                    swap(nums, end, start);
                }
            }
            swap(nums, l, start);
            quick_sort(nums, l, start - 1);
            quick_sort(nums, start + 1, r);
        }
    }

    public static void swap(int[] nums, int l, int start) {
        int temp = nums[l];
        nums[l] = nums[start];
        nums[start] = temp;
    }
}
