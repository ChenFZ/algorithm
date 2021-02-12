/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: Search
 * Author:   Chen FZ
 * Date:     2021/2/10 18:01
 * Description: 81. 搜索旋转排序数组 II  Search in Rotated Sorted Array II (Medium)
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.binarySearch;

/**
 * 〈一句话功能简述〉<br>
 * 〈81. 搜索旋转排序数组 II  Search in Rotated Sorted Array II (Medium)〉
 * <p>
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组[0,0,1,2,2,5,6]可能变为[2,5,6,0,0,1,2])。
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回true，否则返回false。
 * <p>
 * 示例1:
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * <p>
 * 示例2:
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 */
public class Search {

    public static void main(String[] args) {
        Search search = new Search();
        int[] nums = {1, 0, 1, 1, 1};
        int target = 0;
        System.out.println(search.search(nums, target));
    }

    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] == target) {
                return true;
            }
            //    等于左边界，无法判断增序
            if (nums[l] == nums[mid]) {
                l++;
            } else if (nums[mid] <= nums[r]) {
                //    右边增序
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                //    左边增序
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

        }
        return false;
    }
}
