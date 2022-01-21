/**
 * Copyright (C), 2015-2022
 * Description: 解码方式
 * <author>          <time>          <version>          <desc>
 * chenfz           2022/1/20 20:26           1.0              描述
 */
package com.chenfz.leetcode.dynamicprogramming;

/**
 * 功能描述: <br>
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * <p>
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * <p>
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * <p>
 * 题目数据保证答案肯定是一个 32 位 的整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 */
public class DecodeWays {

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("226"));
    }

    /**
     * 功能描述: <br>
     * 分类讨论
     * 1. 最后一位是0      dp[n-2]
     * 2. 后两位大于26     dp[n-1]
     * 3. 倒数第二位是0    dp[n-1]
     * 3. 后两位小于26     dp[n-1] + dp[n-2]
     */
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        char[] chars = s.toCharArray();
        int[] ints = new int[len];
        for (int i = 0; i < len; i++) {
            ints[i] = chars[i] - 48;
        }
        //List<String> list = Arrays.asList(chars).stream().map(i -> i + "").collect(Collectors.toList());
        if (ints[0] == 0) return 0;
        if (len == 1) return 1;
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < len; i++) {
            if (ints[i] == 0) {
                if (ints[i - 1] > 2 || ints[i - 1] == 0) return 0;
                dp[i + 1] = dp[i - 1];
            } else if (ints[i] + 10 * ints[i - 1] > 26) {
                dp[i + 1] = dp[i];
            } else if (ints[i - 1] == 0) {
                dp[i + 1] = dp[i];
            } else {
                dp[i + 1] = dp[i] + dp[i - 1];
            }
        }
        return dp[len];
    }
}
