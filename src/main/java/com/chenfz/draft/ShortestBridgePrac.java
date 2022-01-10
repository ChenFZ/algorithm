/**
 * Copyright (C), 2015-2021
 * Description:
 * <author>          <time>          <version>          <desc>
 * chenfz           2021/12/31 16:43           1.0              描述
 */
package com.chenfz.draft;

public class ShortestBridgePrac {
    public static void main(String[] args) {
        ShortestBridgePrac shortestBridge = new ShortestBridgePrac();
        int[][] A = {{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}};
        int i = shortestBridge.shortestBridge(A);
        System.out.println(i);
    }

    private final int[] d = {-1, 0, 1, 0, -1};
    private int r, c;
    private boolean[][] Visited;
    private final static int DIRECTION = 4;
    private int shortestBridge(int[][] a) {


        return 0;
    }
}
