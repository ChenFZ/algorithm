/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: Exist
 * Author:   Chen FZ
 * Date:     2021/2/17 12:48
 * Description: 79. 单词搜索 Word Search (Medium)
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.firstSearch.backtracking;

/**
 * 〈一句话功能简述〉<br>
 * 〈79. 单词搜索 Word Search (Medium)〉
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *
 * @author Chen FZ
 * @create 2021/2/17
 * @since 1.0.0
 */
public class WordSearch {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word = "ABCCFA";
        System.out.println(new WordSearch().exist(board, word));
    }

    private final int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private final static int DIRECTION = 4;
    private int r, c;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        boolean res = false;
        char[] chars = word.toCharArray();
        r = board.length;
        c = board[0].length;
        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j]) {
                    res = dfs(board, chars, i, j, 0);
                    if (res) {
                        return true;
                    }
                }
            }
        }
        return res;
    }

    private boolean dfs(char[][] board, char[] chars, int x, int y, int depth) {
        int len = chars.length;
        if (!inMatrix(x, y) || board[x][y] != chars[depth]) {
            return false;
        }
        if (depth == len - 1) {
            return true;
        }
        boolean res = false;
        visited[x][y] = true;
        for (int i = 0; i < DIRECTION; i++) {
            int nextX = x + d[i][0];
            int nextY = y + d[i][1];
            if (inMatrix(nextX, nextY) && !visited[nextX][nextY]) {
                boolean flag = dfs(board, chars, nextX, nextY, depth + 1);
                if (flag) {
                    res = true;
                    break;
                }
            }
        }
        visited[x][y] = false;
        return res;
    }

    private boolean inMatrix(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }

}
