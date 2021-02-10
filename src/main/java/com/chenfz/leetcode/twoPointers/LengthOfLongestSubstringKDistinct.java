/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: LengthOfLongestSubstringKDistinct
 * Author:   Chen FZ
 * Date:     2021/2/7 12:15
 * Description: 340. Longest Substring with At Most K Distinct Characters 最多有K个不同字符的最长子串
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.chenfz.leetcode.twoPointers;
/**
 * 〈一句话功能简述〉<br>
 * 〈340. Longest Substring with At Most K Distinct Characters 最多有K个不同字符的最长子串〉
 * <p>
 * 给一个字符串 s 和整数 k ， 要求返回最多由k个不同字符组成的最长子串
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "eceba", k = 2
 * 输出: 3
 * 解释: 子字符串 "ece" 长度为 3.
 * 示例 2:
 * <p>
 * 输入: s = "aa", k = 1
 * 输出: 2
 * 解释: 子字符串 "aa" 长度为 2.
 *
 * @author Chen FZ
 * @create 2021/2/7
 * @since 1.0.0
 */
public class LengthOfLongestSubstringKDistinct {

    public static void main(String[] args) {
        String s = "eccccebaaa";
        int k = 3;

        System.out.println(lengthOfLongestSubstringKDistinct(s, k));
    }

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int sLen = s.length();
        char[] charArrayS = s.toCharArray();
        if (sLen == 0 || k == 0) {
            return 0;
        }

        int left = 0, right = 0;
        int distance = k;
        int maxLen = 0;
        int[] winFreq = new int[128];
        while (right < sLen) {
            char curChar = charArrayS[right];
            if (winFreq[curChar] == 0) {
                distance--;
            }
            winFreq[curChar]++;
            right++;
            while (distance < 0) {
                curChar = charArrayS[left];
                if (winFreq[curChar] == 1) {
                    distance++;
                }
                winFreq[ curChar]--;
                left++;
            }
            if (distance == 0 && right - left > maxLen) {
                maxLen = right - left;
            }
        }
        return maxLen;
    }
}
