/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: ShortestBridge
 * Author:   chenfz
 * Date:     2021/7/26 15:47
 * Description: shortest Bridge
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.firstSearch.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 〈一句话功能简述〉<br> 
 * 〈shortest Bridge〉
 *在给定的二维二进制数组A中，存在两座岛。（岛是由四面相连的 1 形成的一个最大组。）
 *
 * 现在，我们可以将0变为1，以使两座岛连接起来，变成一座岛。
 *
 * 返回必须翻转的0 的最小数目。（可以保证答案至少是 1 。）
 *
 * 示例 1：
 *
 * 输入：A = [[0,1],[1,0]]
 * 输出：1
 * 示例 2：
 *
 * 输入：A = [[0,1,0],[0,0,0],[0,0,1]]
 * 输出：2
 * 示例 3：
 *
 * 输入：A = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * 输出：1
 * 
 * 提示：
 *
 * 2 <= A.length == A[0].length <= 100
 * A[i][j] == 0 或 A[i][j] == 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-bridge
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author chenfz
 * @create 2021/7/26
 * @since 1.0.0
 */
public class ShortestBridge {

    public static void main(String[] args) {
        ShortestBridge shortestBridge = new ShortestBridge();
        int[][] A = {{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}};
        int i = shortestBridge.shortestBridge(A);
        System.out.println(i);
    }

    private int[] direction = new int[]{-1,0,1,0,-1};
    private int res = 0;
    public int shortestBridge(int[][] A) {
        // 1. 先 dfs 将找到的第一座桥的值全部赋值为2，并将第一座桥旁边的 0 全部插入队列中
        // 2. 再 while 循环判断队列是否为空，循环体里会判断是否发现了第二座桥；
        Queue<int[]> queue = new LinkedList<>();
        // 先 dfs，将第一座岛上所有值都该为 2
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

        // bfs 寻找下一座岛屿，遍历时将所有 0 值赋值为 2
        while (!queue.isEmpty()) {
            res++;
            int queueSize = queue.size();
            while (queueSize-- > 0) {
                int[] root = queue.poll();
                for (int i = 0; i < direction.length-1; i++) {
                    int x1 = root[0] + direction[i];
                    int y1 = root[1] + direction[i+1];
                    if (x1 >= 0 && x1 < A.length && y1 >= 0 && y1 < A[0].length) {
                        if (A[x1][y1] == 1) {
                            return res;
                        } else if (A[x1][y1] == 2) {
                            continue;
                        }
                        A[x1][y1] = 2;
                        queue.add(new int[]{x1,y1});
                    }
                }
            }
        }
        return res;
    }

    private void dfs(int[][] A, Queue<int[]> queue, int x, int y, int n, int m) {
        // 插入所有为 0 的值的坐标到队列中
        // 为 1 的值就改变为 2 并且继续遍历四个方向
        // 为 2 的值就直接退出
        if (x < 0 || x == n || y < 0 || y == m || A[x][y] == 2) {
            return;
        }
        if (A[x][y] == 0) {
            queue.add(new int[]{x,y});
            return;
        }
        A[x][y] = 2;
        for (int i = 0; i < direction.length-1; i++) {
            int x1 = x + direction[i];
            int y1 = y + direction[i+1];
            dfs(A, queue, x1, y1, n, m);
        }
    }
}
