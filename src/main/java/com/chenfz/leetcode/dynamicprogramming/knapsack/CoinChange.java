/**
 * Copyright (C), 2015-2022, 航天广信有限公司
 * FileName: CoinChange
 * Author:   Chen FZ
 * Date:     2022/2/3 21:18
 * Description: 322. 零钱兑换
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.dynamicprogramming.knapsack;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br>
 * 〈322. 零钱兑换〉
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * 示例1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 *
 * @author Chen FZ
 * @create 2022/2/3
 * @since 1.0.0
 */
public class CoinChange {
    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[]{2}, 3));
    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        if (coins.length == 0) return -1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 2);
        dp[0] = 0;
        int len = coins.length;
        for (int i = 1; i <= len; i++) {
            for (int j = coins[i - 1]; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i - 1]] + 1);
            }
        }
        return dp[amount] == amount + 2 ? -1 : dp[amount];
    }

    public int coinChange2(int[] coins, int amount) {
        Arrays.sort(coins);
        if (coins.length == 0) return -1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 2);
        dp[0] = 0;
        int len = coins.length;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 2 ? -1 : dp[amount];
    }
}
