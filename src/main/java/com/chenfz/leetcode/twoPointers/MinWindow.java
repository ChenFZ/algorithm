/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: MinWindow
 * Author:   Chen FZ
 * Date:     2021/2/5 11:44
 * Description: 76. 最小覆盖子串
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.twoPointers;

/**
 * 〈一句话功能简述〉<br>
 * 〈76. 最小覆盖子串〉
 * sliding window
 *
 * 题目描述
 * 给定两个字符串 S 和T，求 S 中包含T 所有字符的最短连续子字符串的长度，同时要求时间
 * 复杂度不得超过 O(n)。
 * 输入输出样例
 * 输入是两个字符串 S 和 T，输出是一个 S 字符串的子串。
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * 在这个样例中，S 中同时包含一个 A、一个 B、一个 C 的最短子字符串是“BANC”。
 *
 * @author Chen FZ
 * @create 2021/2/5
 * @since 1.0.0
 */
public class MinWindow {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s,t));
    }

    public static String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m == 0 || n == 0 || m < n) {
            return "";
        }

        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();

        int[] winFreq = new int[128];
        int[] tFreq = new int[128];
        for (int i = 0; i < n; i++) {
            tFreq[charArrayT[i]]++;
        }

        int left = 0, right = 0;
        int minLen = m + 1;
        int begin = 0;
        int distance = n;
        while (right < m) {
            char currentChar = charArrayS[right];
            if (tFreq[currentChar] == 0) {
                right++;
                continue;
            }
            if (tFreq[currentChar] > winFreq[currentChar]) {
                distance--;
            }
            winFreq[currentChar]++;
            right++;
            while (distance == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    begin = left;
                }
                currentChar = charArrayS[left];
                if (tFreq[currentChar] == 0) {
                    left++;
                    continue;
                }
                if (tFreq[currentChar] == winFreq[currentChar]) {
                    distance++;
                }
                winFreq[currentChar]--;
                left++;
            }
        }
        if (minLen == m + 1) {
            return "";
        }
        return s.substring(begin, begin + minLen);
    }
}
