/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: ShortestBridgeCopy
 * Author:   chenfz
 * Date:     2021/7/26 16:24
 * Description: copy
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.firstSearch.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 〈一句话功能简述〉<br>
 * 〈copy〉
 *
 * @author chenfz
 * @create 2021/7/26
 * @since 1.0.0
 */
public class ShortestBridgeCopy extends ShortestBridge {

    public static void main(String[] args) {
        ShortestBridge shortestBridge = new ShortestBridgeCopy();
        int[][] A = {{1, 1, 1, 1, 1}, {1, 0, 0, 0, 1}, {1, 0, 1, 0, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 1}};
        int[][] B = {{1, 0}, {0, 1}};
        int i = shortestBridge.shortestBridge(B);
        System.out.println(i);
    }

    private int[] direction = new int[]{-1, 0, 1, 0, -1};
    private int res = 0;

    @Override
    public int shortestBridge(int[][] A) {
        // 1. 先 dfs 将找到的第一座岛的值全部赋值为2，并将第一座岛旁边的 0 全部插入队列中
        Queue<int[]> queue = new LinkedList<>();
        boolean dfsFlag = false;
        for (int i = 0; i < A.length; i++) {
            if (dfsFlag) {
                break;
            }
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    dfs(A, queue, i, j, A.length, A[0].length);
                    dfsFlag = true;
                    break;
                }
            }
        }

        // 2. 再 while 循环判断队列是否为空，循环体里会判断是否发现了第二座桥；
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            while (size-- > 0) {
                int[] root = queue.poll();
                // bfs 寻找下一座岛屿，遍历时将所有 0 值赋值为 2
                for (int k = 0; k < direction.length - 1; k++) {
                    int x = root[0] + direction[k];
                    int y = root[1] + direction[k + 1];
                    if(isNotIsland(x, y, A.length, A[0].length)) continue;
                    if (A[x][y] == 1) {
                        return res;
                    } else if (A[x][y] == 2) {
                        continue;
                    }
                    A[x][y] = 2;
                    queue.add(new int[]{x, y});
                }
            }
        }
        return res;
    }

    private void dfs(int[][] a, Queue<int[]> queue, int i, int j, int raw, int col ) {
        // 插入所有为 0 的值的坐标到队列中
        // 为 1 的值就改变为 2 并且继续遍历四个方向
        // 为 2 的值就直接退出
        if (isNotIsland(i, j, raw, col) || a[i][j] == 2) {
            return;
        }
        if (a[i][j] == 0) {
            queue.add(new int[]{i, j});
            return;
        }
        a[i][j] = 2;
        for (int k = 0; k < direction.length - 1; k++) {
            int x = i + direction[k];
            int y = j + direction[k + 1];
            dfs(a, queue, x, y, raw, col);
        }
    }

    private boolean isNotIsland(int i, int j, int raw, int col) {
        return i == raw || j == col || i < 0 || j < 0;
    }
}
