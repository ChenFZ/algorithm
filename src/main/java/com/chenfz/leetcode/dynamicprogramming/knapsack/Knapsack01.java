/**
 * Copyright (C), 2015-2022, 航天广信有限公司
 * FileName: Knapsack01
 * Author:   Chen FZ
 * Date:     2022/2/1 16:06
 * Description: 01背包问题
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.dynamicprogramming.knapsack;

/**
 * 〈一句话功能简述〉<br>
 * 〈01背包问题〉
 *
 * @author Chen FZ
 * @create 2022/2/1
 * @since 1.0.0
 */
public class Knapsack01 {

    public static void main(String[] args) {
        System.out.println(new Knapsack01().knapsack(new int[]{1, 3, 5}, new int[]{2, 3, 5}, 3, 8));
        System.out.println(new Knapsack01().knapsackSpaceOptimize(new int[]{1, 3, 5}, new int[]{2, 3, 5}, 3, 8));
        System.out.println(new Knapsack01().knapsackNP(new int[]{1, 3, 5}, new int[]{2, 3, 5}, 3, 9));
        System.out.println(new Knapsack01().knapsackNPSpaceOptimize(new int[]{1, 3, 5}, new int[]{2, 3, 5}, 3, 9));
    }

    /**
     * 功能描述: <br>
     *
     * @param weights 物品重量列表
     * @param values  物品价值列表
     * @param N       有 N 个物品
     * @param W       容量为 W 的背包
     * @return 最大价值
     * 状态转移方程： 1.第i个物品不装    dp[i][j] = dp[i-1][j]
     * 2. 第i个物品装   dp[i][j] = dp[i-1][j-w]+ v
     */
    int knapsack(int[] weights, int[] values, int N, int W) {
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                if (j >= weights[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + values[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][W];
    }

    //    对 0-1 背包进行空间优化
    int knapsackSpaceOptimize(int[] weights, int[] values, int N, int W) {
        int[] dp = new int[W + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = W; j >= weights[i - 1]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weights[i - 1]] + values[i - 1]);
            }
        }
        return dp[W];
    }

    //    在完全背包问题中，一个物品可以拿多次
    //      状态转移方程： 1.第i个物品不装    dp[i][j] = dp[i-1][j]
    //                  2. 第i个物品装   dp[i][j] = dp[i][j-w]+ v
    int knapsackNP(int[] weights, int[] values, int N, int W) {
        int[][] dp = new int[N + 1][W + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= W; j++) {
                if (j >= weights[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - weights[i - 1]] + values[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][W];
    }

    int knapsackNPSpaceOptimize(int[] weights, int[] values, int N, int W) {
        int[] dp = new int[W + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = weights[i - 1]; j <= W; j++) {
                    dp[j] = Math.max(dp[j], dp[j - weights[i - 1]] + values[i - 1]);
            }
        }
        return dp[W];
    }
}
