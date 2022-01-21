/**
 * Copyright (C), 2015-2022
 * Description: 完全平方数
 * <author>          <time>          <version>          <desc>
 * chenfz           2022/1/20 20:08           1.0              描述
 */
package com.chenfz.leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * 功能描述: <br>
 * 〈〉
 * <p>
 * No such property: code for class: Script1
 *
 * @return:给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * <p>
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 * <p>
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * <p>
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * <p>
 * 示例 2：
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 */
public class PerfectSquares {

    public static void main(String[] args) {
        int i = new PerfectSquares().numSquares(13);
        System.out.println(i);
    }

    //i 的满足条件的解法，只和 i-k^2有关
    //因此 dp[i] 可以取的最小值即为 1 + min(dp[i-1], dp[i-4], dp[i-9] ···)
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
