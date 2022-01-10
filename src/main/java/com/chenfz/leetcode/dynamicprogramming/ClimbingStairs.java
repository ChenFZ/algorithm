/**
 * Copyright (C), 2015-2022
 * Description: 70. 爬楼梯
 * <author>          <time>          <version>          <desc>
 * chenfz           2022/1/7 11:31           1.0              描述
 */
package com.chenfz.leetcode.dynamicprogramming;

/**
 * 功能描述: <br>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 1,2,3,5,8
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(2));
    }

    private int res = 0;
    private int[] arr;
    public int climbStairs(int n) {
        //if (n == 1) {
        //    return 1;
        //}
        //dfs(n, 0);
        //solve(n);
        //return arr[n-1];

        //solve2(n);
        //return arr[2];

        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    private void dfs(int target, int sum) {
        if (sum == target) {
            res++;
            return;
        }
        for (int i = 1; i <= 2; i++) {
            if (sum + i > target) {
                break;
            }
            dfs(target, sum+i);
        }
    }

    private void solve(int target) {
        arr = new int[target];
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i < target; i++) {
            arr[i] = arr[i-1]+arr[i-2];
        }
    }

//    可以使用滚动数组
    private void solve2(int target) {
        arr = new int[3];
        arr[0] = 0;
        arr[1] = 0;
        arr[2] = 1;
        for (int i = 1; i <= target; i++) {
            arr[0] = arr[1];
            arr[1] = arr[2];
            arr[2] = arr[0] + arr[1];
        }
    }

}
