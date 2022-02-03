/**
 * Copyright (C), 2015-2022, 航天广信有限公司
 * FileName: WordBreak
 * Author:   Chen FZ
 * Date:     2022/1/23 23:18
 * Description: 单词拆分
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.dynamicprogramming;

import java.util.Arrays;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * <p>
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 * 注意，你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */
public class WordBreak {

    public static void main(String[] args) {
        System.out.println(new WordBreak().wordBreak("applepenapple",Arrays.asList("apple", "pen")));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int l = s.length();
        boolean[] dp = new boolean[l + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int i = 1; i <= l; i++) {
            for (String dict : wordDict) {
                int len = dict.length();
                if (i >= len && s.substring(i - len, i).equals(dict)) {
                    dp[i] = dp[i] || dp[i - len];
                }
            }
        }
        return dp[l];
    }
}
