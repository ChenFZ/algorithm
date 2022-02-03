/**
 * Copyright (C), 2015-2022, 航天广信有限公司
 * FileName: FindMaxForm
 * Author:   Chen FZ
 * Date:     2022/2/1 18:14
 * Description: 474. 一和零
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.dynamicprogramming.knapsack;

/**
 * 〈一句话功能简述〉<br>
 * 〈474. 一和零〉
 * <p>
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * <p>
 * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
 * <p>
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
 * 其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
 * 示例 2：
 * <p>
 * 输入：strs = ["10", "0", "1"], m = 1, n = 1
 * 输出：2
 * 解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
 *
 * @author Chen FZ
 * @create 2022/2/1
 * @since 1.0.0
 */
public class FindMaxForm {
    public static void main(String[] args) {
        System.out.println(new FindMaxForm().findMaxForm(new String[]{"10", "0001", "111001", "1", "0"},5,3));
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int[] count = count(str);
            for (int i = m; i >= count[0]; i--) {
                for (int j = n; j >= count[1]; j--) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - count[0]][j - count[1]]);
                }
            }
        }
        return dp[m][n];
    }

    private int[] count(String str) {
        int[] counts = new int[2];
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (c == '0'){
                counts[0] += 1;
            }else{
                counts[1] += 1;
            }
        }
        return counts;
    }
}
