/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: FriendCircles
 * Author:   Chen FZ
 * Date:     2021/2/15 20:29
 * Description: 547. Friend Circles 朋友圈
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.firstSearch.dfs;

/**
 * 〈一句话功能简述〉<br>
 * 〈547. Friend Circles 朋友圈〉
 * <p>
 * 题目描述
 * 给定一个二维的 0-1 矩阵，如果第 (i, j) 位置是 1，则表示第 i 个人和第 j 个人是朋友。已知
 * 朋友关系是可以传递的，即如果 a 是 b 的朋友，b 是 c 的朋友，那么 a 和 c 也是朋友，换言之这
 * 三个人处于同一个朋友圈之内。求一共有多少个朋友圈。
 * 输入输出样例
 * 输入是一个二维数组，输出是一个整数，表示朋友圈数量。因为朋友关系具有对称性，该二
 * 维数组为对称矩阵。同时，因为自己是自己的朋友，对角线上的值全部为 1。
 * Input:
 * [[1,1,0],
 * [1,1,0],
 * [0,0,1]]
 * Output: 2
 * 在这个样例中，[1,2] 处于一个朋友圈，[3] 处于一个朋友圈。
 * 1   0   0   0   0
 * 0   1   0   0   0
 * 0   0   1   0   1
 * 0   0   0   1   0
 * 0   0   1   0   1
 *
 * @author Chen FZ
 * @create 2021/2/15
 * @since 1.0.0
 */
public class FriendCircles {
    public static void main(String[] args) {
        int[][] grid = {{1, 0, 0, 0, 1},
                        {0, 1, 0, 0, 0},
                        {0, 0, 1, 0, 1},
                        {0, 0, 0, 1, 0},
                        {1, 0, 1, 0, 1}};
        System.out.println(findCircleNum(grid));
    }

    public static int findCircleNum(int[][] grid) {
        int res = 0;
        int n = grid.length;
        boolean[] visited = new boolean[n];
        // 以行为单位遍历
        for (int i = 0; i < n; i++) {
            if (!visited[i]){
                dfs(grid, i, visited);
                res++;
            }
        }
        return res;
    }

    private static void dfs(int[][] grid, int i, boolean[] visited) {
        visited[i] = true;
        // 每一行中的列，值为1且没有访问过，递归访问，可将一连串的行都访问完成
        for (int j = 0; j < grid.length; j++) {
            if (grid[i][j] == 1 && !visited[j]){
                dfs(grid, j, visited);
            }
        }
    }

}
