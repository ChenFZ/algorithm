package com.chenfz.leetcode.greedyAlgorithm;

/**
 * @author chenfz
 * @description 665. 非递减数列
 * @date 2021-01-31 21:29
 */
public class CheckPossibility {

    public static void main(String[] args) {
        int[] nums = {5,7,1,8};
        System.out.println(checkPossibility(nums));
    }

    public static boolean checkPossibility(int[] nums) {
        int n = nums.length;
        if(n<=1) return true;

        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] - nums[i] > 0) {
                count++;
                if(count > 1) return false;
                if(i>1&&i<n-1&&nums[i-1]>nums[i+1]&&nums[i-2]>nums[i]) return false;
            }
        }
        return true;
    }
}
