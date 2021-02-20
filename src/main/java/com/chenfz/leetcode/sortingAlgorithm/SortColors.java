/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: SortColors
 * Author:   Chen FZ
 * Date:     2021/2/15 11:03
 * Description: 75. 颜色分类 Sort Colors (Medium)
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.sortingAlgorithm;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br> 
 * 〈75. 颜色分类 Sort Colors (Medium)〉
 * 
 * 给定一个包含红色、白色和蓝色，一共n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 * 示例 1：
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 *
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[0]
 * 示例 4：
 *
 * 输入：nums = [1]
 * 输出：[1]
 */
public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int[] res = new int[3];
        for (int i = 0; i < nums.length; i++) {
            res[nums[i]]++;
        }
        int index = 0;
        for (int i = 0; i < res.length; i++) {
            int freq = res[i];
            for (int j = 0; j < freq; j++) {
                nums[index++] = i;
            }
        }
    }
}
