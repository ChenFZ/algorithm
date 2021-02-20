/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: Combine
 * Author:   Chen FZ
 * Date:     2021/2/17 17:14
 * Description: 77. 组合   Combinations (Medium)
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.firstSearch;

import java.util.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈77. 组合   Combinations (Medium)〉
 * <p>
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入:n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 *
 * @author Chen FZ
 * @create 2021/2/17
 * @since 1.0.0
 */
public class Combine {
    public static void main(String[] args) {
        Combine combine = new Combine();
        List<List<Integer>> lists = combine.combine(4, 2);
        for (List list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[len];
        dfs(nums, 0, path, used, k, res);

        return res;
    }

    private static void dfs(int[] nums, int depth, Deque<Integer> path, boolean[] used, int k, List<List<Integer>> res) {
        int len = nums.length;
        if (depth == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, depth + 1, path, used, len, res);
            path.removeLast();
            //used[i] = false;
        }
    }
}
