/**
 * Copyright (C), 2015-2022
 * Description: 最大矩阵
 * <author>          <time>          <version>          <desc>
 * chenfz           2022/1/16 19:31           1.0              描述
 */
package com.chenfz.leetcode.dynamicprogramming;

/**
 * 功能描述: <br>
 * 〈〉
 * <p>
 * No such property: code for class: Script1
 *
 * @return:在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * <p>
 * 示例 1：
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：4
 * <p>
 * 示例 2：
 * 输入：matrix = [["0","1"],["1","0"]]
 * 输出：1
 */
public class MaximalSquare {

    public static void main(String[] args) {
        char[][] chars = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(new MaximalSquare().maximalSquare(chars));
    }

    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int max_side = 0;
        int[][] dp = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
                max_side = Math.max(max_side, dp[i][j]);
            }
        }

        return max_side * max_side;
    }
}
