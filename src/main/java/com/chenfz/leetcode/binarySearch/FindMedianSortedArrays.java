/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: FindMedianSortedArrays
 * Author:   Chen FZ
 * Date:     2021/2/12 20:06
 * Description: 4. 寻找两个正序数组的中位数  Median of Two Sorted Arrays (Hard)
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.binarySearch;

/**
 * 〈一句话功能简述〉<br>
 * 〈4. 寻找两个正序数组的中位数  Median of Two Sorted Arrays (Hard)〉
 *
 * @author Chen FZ
 * @create 2021/2/12
 * @since 1.0.0
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] ints1 = new int[]{2, 3};
        int[] ints2 = new int[]{1};
        System.out.println(findMedianSortedArrays(ints1, ints2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;
        //分割线左边的元素必须满足的个数
        int totalLeft = (m + n + 1) / 2;

        //在[0,m]区间内寻找分割线以满足
        //nums[i-1]<nums[j]并且nums[j-1]<nums[i]
        int l = 0, r = m;
        while (l < r) {
            int i = l + (r - l + 1) / 2;
            int j = totalLeft - i;
            if (nums1[i - 1] > nums2[j]) {
                //搜索左区间
                r = i - 1;
            } else {
                //搜索右区间
                l = i;
            }
        }
        int i = l;
        int j = totalLeft - i;
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];

        if ((m + n) % 2 == 0) {
            return (double) (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2;
        } else {
            return Math.max(nums1LeftMax, nums2LeftMax);
        }
    }
}
