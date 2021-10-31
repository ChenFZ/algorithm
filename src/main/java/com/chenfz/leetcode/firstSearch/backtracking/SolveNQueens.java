/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: SolveNQueens
 * Author:   chenfz
 * Date:     2021/7/23 16:17
 * Description: 51. N 皇后
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.firstSearch.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈51. N 皇后〉
 * <p>
 * n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：[["Q"]]
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 9
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 *
 * @author chenfz
 * @create 2021/7/23
 * @since 1.0.0
 */
public class SolveNQueens {

    public static List<List<String>> res = new ArrayList<>();

    public static void main(String[] args) {
        solution(8);
        System.out.println(res.size());
        for (List list : res) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    private static void solution(int n) {
        char[][] chessboard = new char[n][n];
        for (int i = 0; i < chessboard.length; i++) {
            Arrays.fill(chessboard[i], '.');
        }
        backTrack(n, 0, chessboard);

    }

    private static void backTrack(int n, int raw, char[][] chessboard) {
        if (n == raw) {
            res.add(arrayToList(chessboard));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(raw, col, n, chessboard)) {
                chessboard[raw][col] = 'Q';
                backTrack(n, raw + 1, chessboard);
                chessboard[raw][col] = '.';
            }
        }
    }

    private static boolean isValid(int raw, int col, int n, char[][] chessboard) {
        //竖列
        for (int i = 0; i < raw; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }
        //右斜
        for (int i = 0; i < raw; i++) {
            if (i + col - raw >= 0 && i + col - raw <= n && chessboard[i][i + col - raw] == 'Q') {
                return false;
            }
        }
        //左斜
        for (int i = 0; i < raw; i++) {
            if (col + raw - i >= 0 && col + raw - i < n && chessboard[i][col + raw - i] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private static List<String> arrayToList(char[][] chessboard) {
        ArrayList<String> strings = new ArrayList<>();
        for (char[] c : chessboard) {
            strings.add(String.copyValueOf(c));
        }
        return strings;
    }
}
