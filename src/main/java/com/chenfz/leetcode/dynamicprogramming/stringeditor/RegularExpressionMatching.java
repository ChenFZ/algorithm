/**
 * Copyright (C), 2015-2022, 航天广信有限公司
 * FileName: RegularExpressionMatching
 * Author:   Chen FZ
 * Date:     2022/2/6 20:47
 * Description: 10. 正则表达式匹配
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.dynamicprogramming.stringeditor;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br>
 * 〈10. 正则表达式匹配〉
 * <p>
 * 给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aa" p = "a"
 * 输出：false
 * 解释："a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入：s = "aa" p = "a*"
 * 输出：true
 * 解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例3：
 * <p>
 * 输入：s = "ab" p = ".*"
 * 输出：true
 * 解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4：
 * <p>
 * 输入：s = "aab" p = "c*a*b"
 * 输出：true
 * 解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5：
 * <p>
 * 输入：s = "mississippi" p = "mis*is*p*."
 * 输出：false
 */
public class RegularExpressionMatching {
    public static void main(String[] args) {
        System.out.println(new RegularExpressionMatching().isMatch("aab", "c*a*b"));
    }

    // 字符相等 dp[i][j] = dp[i-1][j-1]
    // 字符相等 dp[i][j] = dp[i-1][j-1] && s.charAt(i-1) == p.charAt(j-1)
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (boolean[] arr : dp) {
            Arrays.fill(arr, false);
        }
        dp[0][0] = true;
        for (int i = 1; i < n + 1; i++) {
            if (p.charAt(i-1) == '*'){
                dp[0][i] = dp[0][i-2];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) != '*') {
                    dp[i][j] = dp[i - 1][j - 1] && s.charAt(i - 1) == p.charAt(j - 1);
                } else if (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
                    //  匹配不上则放弃正则的这两个字符， 看前面的正则能否匹配
                    dp[i][j] = dp[i][j - 2];
                } else {
                    // 有一个匹配就行
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2];
                }
            }
        }
        return dp[m][n];
    }
}
