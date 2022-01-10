/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: CombinationSum
 * Author:   chenfz
 * Date:     2021/8/20 13:51
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.firstSearch.backtracking;

import java.util.*;

/**
 * 〈一句话功能简述〉<br>
 * 给定一个无重复元素的正整数数组candidates和一个正整数target，找出candidates中所有可以使数字和为目标数target的唯一组合。
 * <p>
 * candidates中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。
 * <p>
 * 对于给定的输入，保证和为target 的唯一组合数少于 150 个。
 * 示例1：
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7
 * 输出: [[7],[2,2,3]]
 * 示例2：
 * <p>
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 示例 3：
 * <p>
 * 输入: candidates = [2], target = 1
 * 输出: []
 * 示例 4：
 * <p>
 * 输入: candidates = [1], target = 1
 * 输出: [[1]]
 * 示例 5：
 * <p>
 * 输入: candidates = [1], target = 2
 * 输出: [[1,1]]
 *
 * @author chenfz
 * @create 2021/8/20
 * @since 1.0.0
 */
public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        int target = 9;
        List<List<Integer>> lists = combinationSum.combinationSum(candidates, target);
        for (List list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length < 1 || target <= 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        int sum = 0;
        Arrays.sort(candidates);
        dfs(candidates, target, 0, sum, path, res);
        return res;
    }

    /*
        什么时候使用 used 数组，什么时候使用 begin 变量
        有些朋友可能会疑惑什么时候使用 used 数组，什么时候使用 begin 变量。这里为大家简单总结一下：

        排列问题，讲究顺序（即 [2, 2, 3] 与 [2, 3, 2] 视为不同列表时），需要记录哪些数字已经使用过，此时用 used 数组；
        组合问题，不讲究顺序（即 [2, 2, 3] 与 [2, 3, 2] 视为相同列表时），需要按照某种顺序搜索，此时使用 begin 变量。
        注意：具体问题应该具体分析， 理解算法的设计思想 是至关重要的，请不要死记硬背。
*/
    private void dfs(int[] candidates, int target, int begin, int sum, Deque<Integer> path, List<List<Integer>> res) {
        if (target == sum) {
            res.add(new ArrayList<>(path));
            return;
        } else if (target < sum) {
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            int candidate = candidates[i];
            //剪枝，前提是数组已经小到大排序
            if(sum + candidate > target){
                break;
            }
            path.addLast(candidate);
            sum += candidate;
            dfs(candidates, target, i, sum, path, res);
            path.removeLast();
            sum -= candidate;
        }
    }
}
