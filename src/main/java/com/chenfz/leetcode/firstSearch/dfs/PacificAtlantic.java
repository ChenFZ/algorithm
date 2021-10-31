/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: PacificAtlantic
 * Author:   Chen FZ
 * Date:     2021/2/15 20:36
 * Description:  417. 太平洋大西洋水流问题  Pacific Atlantic Water Flow (Medium)
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
 * 〈 417. 太平洋大西洋水流问题  Pacific Atlantic Water Flow (Medium)〉
 *
 * @author Chen FZ
 * @create 2021/2/15
 * @since 1.0.0
 */
public class PacificAtlantic {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}};
        PacificAtlantic pacificAtlantic = new PacificAtlantic();
        List<List<Integer>> lists = pacificAtlantic.pacificAtlantic(matrix);
        for (List<Integer> list: lists) {
            System.out.println(Arrays.toString(list.stream().mapToInt(i->i).toArray()));
        }
    }

    private int d[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private List<List<Integer>> res;
    private int r, c;
    private boolean[][] pVisited, aVisited;
    private final static int DIRECTION = 4;


    public List<List<Integer>> pacificAtlantic(int[][] matrix) {

        res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        r = matrix.length;
        c = matrix[0].length;
        pVisited = new boolean[r][c];
        aVisited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if (!pVisited[i][j] && inPacificCoast(i, j)) {
                    //从太平洋海边，随便一个地点海浪倒灌入陆地
                    pour(matrix, i, j, matrix[i][j], pVisited);

                }
                if (!aVisited[i][j] && inAtlanticCoast(i, j)) {
                    //大西洋海边随便一个点海浪倒灌入陆地
                    pour(matrix, i, j, matrix[i][j], aVisited);
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (pVisited[i][j] && aVisited[i][j]) {
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
            if (inMatrix(nextX, nextY) && !v[nextX][nextY] && matrix[nextX][nextY] >= h) {
                pour(matrix, nextX, nextY, matrix[nextX][nextY], v);
            }
        }
    }

    private boolean inMatrix(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }


    private boolean inAtlanticCoast(int x, int y) {
        return (y == c - 1) || (x == r - 1);
    }

    private boolean inPacificCoast(int x, int y) {
        return (x == 0) || (y == 0);
    }
}
