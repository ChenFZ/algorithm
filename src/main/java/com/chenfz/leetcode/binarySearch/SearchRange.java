/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: SearchRange
 * Author:   Chen FZ
 * Date:     2021/2/10 17:13
 * Description: 34. 在排序数组中查找元素的第一个和最后一个位置 Find First and Last Position of Element in Sorted Array (Medium)
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.binarySearch;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br>
 * 〈34. 在排序数组中查找元素的第一个和最后一个位置 Find First and Last Position of Element in Sorted Array (Medium)〉
 *
 * @author Chen FZ
 * @create 2021/2/10
 * @since 1.0.0
 */
public class SearchRange {

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange.searchRange(nums, target)));
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums.length == 0) {
            return res;
        }
        int lower_bound = lower_bound(nums, target);
        int upper_bound = upper_bound(nums, target) - 1;
        if (lower_bound == nums.length || nums[lower_bound] != target) {
            return res;
        }
        return new int[]{lower_bound, upper_bound};
    }

    public int lower_bound(int[] nums, int target) {
        int l = 0, r = nums.length;
        int mid = 0;
        while (l < r) {
            mid = (r + l) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid +1;
            }
        }
        return l;
    }

    public int upper_bound(int[] nums, int target) {
        int l = 0, r = nums.length;
        int mid = 0;
        while (l < r) {
            mid = (r + l) / 2;
            if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid +1;
            }
        }
        return l;
    }


}
