/**
 * Copyright (C), 2015-2021
 * Description:
 * <author>          <time>          <version>          <desc>
 * chenfz           2021/12/30 16:24           1.0              描述
 */
package com.chenfz.draft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificWaterFlow {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}};
        PacificWaterFlow pacificAtlantic = new PacificWaterFlow();
        List<List<Integer>> lists = pacificAtlantic.solve(matrix);
        for (List<Integer> list: lists) {
            System.out.println(Arrays.toString(list.stream().mapToInt(i->i).toArray()));
        }
    }

    private final int[] dirction = {-1, 0, 1, 0, -1};
    private int r, c;
    private boolean[][] pVisited, aVisited;
    private final static int DIRECTION = 4;
    private List<List<Integer>> res;

    public List<List<Integer>> solve(int[][] matrix) {
        r = matrix.length;
        c = matrix[0].length;
        res = new ArrayList<>();
        if (matrix == null || r == 0 || c == 0) {
            return res;
        }
        pVisited = new boolean[r][c];
        aVisited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!pVisited[i][j] && isPacificCoast(i, j)) {
                    pour(matrix, i, j, matrix[i][j], pVisited);
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!aVisited[i][j] && isAtlanticCoast(i, j)) {
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

    private void pour(int[][] matrix, int i, int j, int h, boolean[][] pVisited) {
        pVisited[i][j] = true;
        for (int k = 0; k < DIRECTION; k++) {
            int nextX = i + dirction[k];
            int nextY = j + dirction[k + 1];
            if (inMatrix(nextX, nextY) && !pVisited[nextX][nextY] && matrix[nextX][nextY] >= h) {
                pour(matrix, nextX, nextY, matrix[nextX][nextY], pVisited);
            }
        }
    }

    private boolean inMatrix(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }

    private boolean isPacificCoast(int i, int j) {
        return (i == 0 || j == 0);
    }

    private boolean isAtlanticCoast(int i, int j) {
        return (i == r - 1 || j == c - 1);
    }
}
