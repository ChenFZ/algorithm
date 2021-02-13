/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: MergeSort
 * Author:   Chen FZ
 * Date:     2021/2/13 21:07
 * Description: 归并排序（Merge Sort）
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.sortingAlgorithm;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br>
 * 〈归并排序（Merge Sort）〉
 *
 * @author Chen FZ
 * @create 2021/2/13
 * @since 1.0.0
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] nums = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        int[] temp = new int[nums.length];
        merge_sort(nums, 0, nums.length - 1, temp);
        System.out.println(Arrays.toString(nums));
    }

    public static void merge_sort(int[] nums, int l, int r, int[] temp) {
        if (l == r) {
            return;
        }
        if (l + 1 == r && nums[l] > nums[r]) {
            QuickSort.swap(nums, l, r);
            return;
        }

        int mid = (r + l) / 2;
        merge_sort(nums, l, mid, temp);
        merge_sort(nums, mid + 1, r, temp);
        int start1 = l, start2 = mid + 1, newPointer = l;
        while (start1 <= mid || start2 <= r) {
            //temp[newPointer++] = nums[start1] < nums[start2] ? nums[start1++] : nums[start2++];
            if(start1 > mid || (start2 <= r && nums[start1] > nums[start2])){
                temp[newPointer++] = nums[start2++];
            }else{
                temp[newPointer++] = nums[start1++];
            }
        }
        for (int i = l; i < newPointer; i++) {
            nums[i] = temp[i];
        }
    }
}
