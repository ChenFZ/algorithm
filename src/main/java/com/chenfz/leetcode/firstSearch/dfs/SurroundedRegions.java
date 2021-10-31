/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: SurroundedRegions
 * Author:   chenfz
 * Date:     2021/8/7 10:28
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.firstSearch.dfs;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br>
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>
 * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的'O'都不会被填充为'X'。 任何不在边界上，或不与边界上的'O'相连的'O'最终都会被填充为'X'。
 * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * 示例 2：
 * <p>
 * 输入：board = [["X"]]
 * 输出：[["X"]]
 *
 * @author chenfz
 * @create 2021/8/7
 * @since 1.0.0
 */
public class SurroundedRegions {
    public static void main(String[] args) {
        SurroundedRegions regions = new SurroundedRegions();
        char[][] solve = regions.solve(new char[][]{{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}});
        for (int i = 0; i < solve.length; i++) {
            System.out.println(Arrays.toString(solve[i]));
        }
    }

    private static int[] dirction = {-1, 0, 1, 0, -1};

    public char[][] solve(char[][] board) {
        if (board.length <= 2 || board[0].length <= 2) {
            return board;
        }
        int raw = board.length;
        int col = board[0].length;
        char fillWith = 'Y';
        // handle board
        for (int i = 0; i < raw; i++) {
            for (int j = 0; j < col; j++) {
                if (isBoard(i, j, raw, col)) {
                    fillBoard(i, j, board, fillWith);
                }
            }
        }
        for (int i = 0; i < raw; i++) {
            for (int j = 0; j < col; j++) {
                if (!isBoard(i, j, raw, col) && board[i][j] != fillWith) {
                    fillBoard(i, j, board, 'X');
                }
            }
        }
        for (int i = 0; i < raw; i++) {
            for (int j = 0; j < col; j++) {
                fillBoard(i, j, board, 'O');
            }
        }
        return board;
    }

    private void fillBoard(int i, int j, char[][] board, char fillWith) {
        if (!inBoard(i, j, board.length, board[0].length) || board[i][j] == 'X' || board[i][j] == fillWith) {
            return;
        }
        board[i][j] = fillWith;
        for (int k = 0; k < dirction.length - 1; k++) {
            int x = i + dirction[k];
            int y = j + dirction[k + 1];
            fillBoard(x, y, board, fillWith);
        }
    }

    private boolean inBoard(int i, int j, int raw, int col) {
        return i >= 0 && i <= raw - 1 && j >= 0 && j <= col - 1;
    }

    private boolean isBoard(int i, int j, int raw, int col) {
        return i == 0 || i == raw - 1 || j == 0 || j == col - 1;
    }
}
