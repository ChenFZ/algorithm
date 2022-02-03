/**
 * Copyright (C), 2015-2022, 航天广信有限公司
 * FileName: CanPartition
 * Author:   Chen FZ
 * Date:     2022/2/1 17:07
 * Description: 416. 分割等和子集
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.dynamicprogramming.knapsack;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br>
 * 〈416. 分割等和子集〉
 * <p>
 * 给你一个 只包含正整数 的 非空 数组nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,5]  [1,5,10,6]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 *
 * @author Chen FZ
 * @create 2022/2/1
 * @since 1.0.0
 */
public class CanPartition {
    public static void main(String[] args) {
        int[] ints = new int[]{1, 5, 10, 6};
        //ints = new int[]{1, 5, 11, 5};
        System.out.println(new CanPartition().canPartitionSpaceOptimize(ints));

    }

    /**
     * 功能描述: 本题等价于0-1背包问题
     * 状态转移方程： 1.第i个物品不装    dp[i][j] = dp[i-1][j]
     * 2. 第i个物品装   dp[i][j] =dp[i-1][j] dp[i-1][j-w]+ v
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int a : nums) {
            sum += a;
        }
        if ((sum & 1) == 1) return false;
        int target = sum / 2, len = nums.length;
        boolean[][] dp = new boolean[len + 1][target + 1];
        for (boolean[] arr : dp) {
            Arrays.fill(arr, false);
            arr[0] = true;
        }
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= target; j++) {
                if (j>= nums[i - 1]){
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len][target];
    }

    public boolean canPartitionSpaceOptimize(int[] nums) {
        int sum = 0;
        for (int a : nums) {
            sum += a;
        }
        if ((sum & 1) == 1) return false;
        int target = sum / 2, len = nums.length;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = target; j >= nums[i - 1]; j--) {
                    dp[j] = dp[j] || dp[j - nums[i - 1]];
            }
        }
        return dp[target];
    }
}
