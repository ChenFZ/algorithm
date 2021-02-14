/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: InsertionSort
 * Author:   Chen FZ
 * Date:     2021/2/14 11:18
 * Description: 插入排序（Insertion Sort）
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.sortingAlgorithm;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br> 
 * 〈插入排序（Insertion Sort）〉
 *
 * 三、原理（直接插入排序思想）
 * 每次从无序表中取出最后一个元素，把它插入到有序表的合适位置，使有序表仍然有序。
 * 详解：
 *
 * 从数组的第二个元素开始,将数组中的每一个元素按照（升序或者降序）规则插入到已排好序的数组中以达到排序的目的.
 * 一般情况下将数组的第一个元素作为起始元素,从第二个元素开始依次插入。由于要插入到的数组是已经排好序的,所以只要从右向左（或者从后向前）找到排序插入点插入元素，以此类推，直到将最后一个数组元素插入到数组中,整个排序过程完成。
 *
 * 四、原理过程图（升序排列为例）
 * 每次将数组最后一个元素作为插入元素，与它前面有序（已排好序）的数组元素进行比较后，插入正确的位置，排序完成。（如下图）
 *
 * @author Chen FZ
 * @create 2021/2/14
 * @since 1.0.0
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = new int[]{6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        insert_sort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void insert_sort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if(nums[j]<nums[j-1]){
                    QuickSort.swap(nums, j, j-1);
                }
            }
        }
    }
}
