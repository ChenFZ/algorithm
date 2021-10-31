/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: DeepFirstSearch
 * Author:   Chen FZ
 * Date:     2021/2/15 20:00
 * Description: 深度优先搜索 695. Max Area of Island (Easy)
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.firstSearch.dfs;

/**
 * 〈一句话功能简述〉<br>
 * 〈深度优先搜索 695. Max Area of Island (Easy)〉
 * <p>
 * 给定一个包含了一些 0 和 1 的非空二维数组grid 。
 * <p>
 * 一个岛屿是由一些相邻的1(代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设grid 的四个边缘都被 0（代表水）包围着。
 * <p>
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 *
 * @author Chen FZ
 * @create 2021/2/15
 * @since 1.0.0
 */
public class DeepFirstSearch {
    public static void main(String[] args) {
        int[][] gird = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};

        System.out.println(maxAreaOfIsland(gird));
    }

    /*
    * 主函数负责遍历所有的搜索位置
    * */
    public static int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                res = Math.max(res, islandDFS(grid, i, j));
            }
        }
        return res;
    }

    /*
    *   辅函数负责深度优先搜索的递归调用
    *   此处的搜索方向有上下左右四个
    * */
    public static int islandDFS(int[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length) {
            if (grid[i][j] == 0) return 0;
            grid[i][j] = 0;
            return 1 + islandDFS(grid, i + 1, j) + islandDFS(grid, i - 1, j) + islandDFS(grid, i, j + 1) + islandDFS(grid, i, j - 1);
        } else {
            return 0;
        }
    }
}
