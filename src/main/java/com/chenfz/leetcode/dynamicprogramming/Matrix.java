/**
 * Copyright (C), 2015-2022
 * Description: updateMatrix
 * <author>          <time>          <version>          <desc>
 * chenfz           2022/1/16 18:46           1.0              描述
 */
package com.chenfz.leetcode.dynamicprogramming;

import java.util.Arrays;

/**
 * 功能描述: <br>
 * 给定一个由 0 和 1 组成的矩阵 mat，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
 * 两个相邻元素间的距离为 1 。
 * <p>
 * 示例 1：
 * 输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：[[0,0,0],[0,1,0],[0,0,0]]
 * <p>
 * 示例 2：
 * 输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
 * 输出：[[0,0,0],[0,1,0],[1,2,1]]
 */
public class Matrix {
    public static void main(String[] args) {
        new Matrix().updateMatrix(new int[][]{{0,0,0},{0,1,0},{1,1,1}});
    }

    public int[][] updateMatrix(int[][] mat) {
        //    只需要考虑右下方，左上方移动即可
        int n = mat.length;
        int m = mat[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE - 1);
        }
        //朝着右下方移动
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    if (j > 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                    }
                    if (i > 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                    }
                }
            }
        }
        //朝左上方移动
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (j < m - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                }
                if (i < n - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                }
            }
        }

        return dp;
    }
}
