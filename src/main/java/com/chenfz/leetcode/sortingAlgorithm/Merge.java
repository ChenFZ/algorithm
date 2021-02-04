/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: Merge
 * Author:   Chen FZ
 * Date:     2021/2/1 17:43
 * Description: 88. 合并两个有序数组
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.sortingAlgorithm;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br>
 * 〈88. 合并两个有序数组〉
 *
 * @author Chen FZ
 * @create 2021/2/1
 * @since 1.0.0
 */
/*给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。

示例 1：
输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
输出：[1,2,2,3,5,6]
示例 2：

输入：nums1 = [1], m = 1, nums2 = [], n = 0
输出：[1]
*/
public class Merge {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int j = 0; j < nums2.length; j++) {
                nums1[j] = nums2[j];
            }
        }
        if (n == 0) {
            return;
        }

        int pos = m + n - 1;
        int s1 = m - 1;
        int s2 = n - 1;
        while (s1 >= 0 && s2 >= 0) {
            if (nums1[s1] > nums2[s2]) {
                nums1[pos--] = nums1[s1--];
            } else {
                nums1[pos--] = nums2[s2--];
            }
        }
        if (s1 < 0) {
            while (s2 >= 0) {
                nums1[pos--] = nums2[s2--];
            }
        }
    }
}
