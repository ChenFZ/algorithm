/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: FindMin
 * Author:   Chen FZ
 * Date:     2021/2/11 17:12
 * Description: 153. 寻找旋转排序数组中的最小值 Find Minimum in Rotated Sorted Array
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.binarySearch;

/**
 * 〈一句话功能简述〉<br>
 * 〈153. 寻找旋转排序数组中的最小值 Find Minimum in Rotated Sorted Array〉
 * <p>
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组[0,1,2,4,5,6,7] 可能变为[4,5,6,7,0,1,2] 。
 * <p>
 * 请找出其中最小的元素。
 * <p>
 * 示例 1：
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2]
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 */
public class FindMin {
    public static void main(String[] args) {
        int min = new FindMin().findMin(new int[]{3, 4, 5, 1, 2});
        System.out.println(min);
        int min2 = new FindMin().findMinAllowDump(new int[]{10,1,10,10,10});
        System.out.println(min2);
    }

    /*算法思想
     * 找到变化点：变化点左边的元素>位置0的元素，变化点右边的元素<位置0的元素
     * 判断结果：1.nums[mid]>nums[mid+1], 返回mid+1
     *         2.nums[mid-1]>nums[mid], 返回mid
     * */
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        int l = 0, r = nums.length - 1, mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if (nums[mid] > nums[l]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;

        //Arrays.sort(nums);
        //return nums[0];
    }

    /*
    * 请找出其中最小的元素。注意数组中可能存在重复的元素。
    *
    * 算法思想
    * */
    public int findMinAllowDump(int[] nums){
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        int l = 0, r = nums.length - 1, mid;
        while (l < r) {
            mid = l + (r - l) / 2;
            if (nums[r] == nums[mid]) {
                r--;
            }else if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }
}
