/**
 * Copyright (C), 2015-2022, 航天广信有限公司
 * FileName: EditDistance
 * Author:   Chen FZ
 * Date:     2022/2/6 19:30
 * Description: 72. 编辑距离
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.dynamicprogramming.stringeditor;

/**
 * 〈一句话功能简述〉<br>
 * 〈72. 编辑距离 〉
 * <p>
 * 给你两个单词word1 和word2， 请返回将word1转换成word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * <p>
 * 示例1：
 * <p>
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例2：
 * <p>
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> exention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 */
public class EditDistance {
    public static void main(String[] args) {
        System.out.println(new EditDistance().minDistance("intention", "execution"));
    }

    /**
     * 功能描述: <br>
     * 〈〉
     * 状态转移方程： 1.相同字符    dp[i][j] = dp[i-1][j-1]
     * * 2. 不同字符   dp[i][j] = min 修改 dp[i-1][j-1]+1  插入/删除 dp[i-1][j]+ 1 或者  dp[i][j-1]+ 1
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
