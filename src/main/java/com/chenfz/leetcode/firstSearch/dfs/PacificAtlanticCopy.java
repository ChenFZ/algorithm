/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: PacificAtlanticCopy
 * Author:   Chen FZ
 * Date:     2021/2/16 11:30
 * Description: 手写
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.firstSearch.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈手写〉
 *
 * @author Chen FZ
 * @create 2021/2/16
 * @since 1.0.0
 */
public class PacificAtlanticCopy {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}};
        PacificAtlanticCopy pacificAtlantic = new PacificAtlanticCopy();
        List<List<Integer>> lists = pacificAtlantic.pacificAtlantic(matrix);
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.stream().mapToInt(i -> i).toArray()));
        }
    }

    private int d[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int r, c;
    private boolean[][] pVisiter, aVisiter;
    private static final int DIRECTION = 4;


    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();

        if (matrix== null ||matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        r = matrix.length;
        c = matrix[0].length;
        pVisiter = new boolean[r][c];
        aVisiter = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!pVisiter[i][j] && inPacificCoast(i, j)) {
                    pour(matrix, i, j, matrix[i][j], pVisiter);
                }
                if (!aVisiter[i][j] && inAtlanticCoast(i, j)) {
                    pour(matrix, i, j, matrix[i][j], aVisiter);
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (pVisiter[i][j] && aVisiter[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void pour(int[][] matrix, int x, int y, int h, boolean[][] v) {
        v[x][y] = true;
        for (int i = 0; i < DIRECTION; i++) {
            int nextX = x + d[i][0];
            int nextY = y + d[i][1];
            if (inMatirx(nextX, nextY) && !v[nextX][nextY] && h <= matrix[nextX][nextY]) {
                pour(matrix, nextX, nextY, matrix[nextX][nextY], v);
            }
        }
    }

    private boolean inMatirx(int x, int y) {
        return (x >= 0 && x < r && y >= 0 && y < c);
    }

    private boolean inAtlanticCoast(int x, int y) {
        return (x == r - 1) || (y == c - 1);
    }

    private boolean inPacificCoast(int x, int y) {
        return (x == 0) || (y == 0);
    }


}
