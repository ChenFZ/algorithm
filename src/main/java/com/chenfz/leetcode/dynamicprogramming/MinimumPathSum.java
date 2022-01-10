/**
 * Copyright (C), 2015-2022
 * Description: 64
 * <author>          <time>          <version>          <desc>
 * chenfz           2022/1/9 15:32           1.0              描述
 */
package com.chenfz.leetcode.dynamicprogramming;

/**
 * 功能描述: <br>
 * 〈64. 最小路径和〉
 * <p>
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 示例 2：
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 */
public class MinimumPathSum {
    public static void main(String[] args) {
        System.out.println(new MinimumPathSum().minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 & j == 0) {
                    dp[i][j] = grid[0][0];
                }else if(i == 0){
                    dp[i][j] = dp[i][j-1]+grid[i][j];
                }else if(j == 0){
                    dp[i][j] = dp[i-1][j]+grid[i][j];
                }else{
                    dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j])+grid[i][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
