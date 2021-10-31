/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: CombinationSum2
 * Author:   chenfz
 * Date:     2021/8/20 14:27
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.firstSearch.backtracking;

import java.util.*;

/**
 * 〈一句话功能简述〉<br>
 * 给定一个数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates中的每个数字在每个组合中只能使用一次。
 * 注意：解集不能包含重复的组合。
 * 示例1:
 * <p>
 * 输入: candidates =[10,1,2,7,6,1,5], target =8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例2:
 * <p>
 * 输入: candidates =[2,5,2,1,2], target =5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 * @author chenfz
 * @create 2021/8/20
 * @since 1.0.0
 */
public class CombinationSum2 {
    public static void main(String[] args) {
        CombinationSum2 combinationSum = new CombinationSum2();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> lists = combinationSum.combinationSum2(candidates, target);
        for (List list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length < 1 || target <= 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        int sum = 0;
        Arrays.sort(candidates);
        List<Integer> dict = new ArrayList<>();
        int[] used = new int[candidates.length];
        for (int num : candidates) {
            if (!dict.contains(num)) {
                dict.add(num);
            }
            used[dict.indexOf(num)] += 1;
        }
        dfs(dict, used, target,0, sum, path, res);
        return res;
    }

    private void dfs(List<Integer> dict, int[] used, int target,int begin, int sum, Deque<Integer> path, List<List<Integer>> res) {
        if (target == sum) {
            res.add(new ArrayList<>(path));
            return;
        } else if (target < sum) {
            return;
        }
        for (int i = begin; i < dict.size(); i++) {
            if (used[i] == 0) {
                continue;
            }
            int candidate = dict.get(i);
            //剪枝，前提是数组已经小到大排序
            if (sum + candidate > target) {
                break;
            }
            path.addLast(candidate);
            sum += candidate;
            used[i] -= 1;
            dfs(dict, used, target, i, sum, path, res);
            path.removeLast();
            sum -= candidate;
            used[i] += 1;
        }
    }
}
