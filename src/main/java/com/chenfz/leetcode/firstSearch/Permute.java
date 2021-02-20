/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: Permute
 * Author:   Chen FZ
 * Date:     2021/2/17 11:15
 * Description: 46. 全排列 Permutations (Medium)
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.firstSearch;

import java.util.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈46. 全排列 Permutations (Medium)〉
 * <p>
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 *
 * @author Chen FZ
 * @create 2021/2/17
 * @since 1.0.0
 */
public class Permute {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[len];
        dfs(nums, 0, path, used, len, res);

        return res;
    }

    private static void dfs(int[] nums, int depth, Deque<Integer> path, boolean[] used, int len, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, depth+1,path, used, len, res);
            path.removeLast();
            used[i] = false;
        }
    }
}
