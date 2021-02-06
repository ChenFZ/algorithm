/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: ValidPalindrome
 * Author:   Chen FZ
 * Date:     2021/2/5 17:38
 * Description: 680. 验证回文字符串 Ⅱ Valid Palindrome II (Easy)
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.twoPointers;

/**
 * 〈一句话功能简述〉<br>
 * 〈680. 验证回文字符串 Ⅱ Valid Palindrome II (Easy)〉
 *
 * @author Chen FZ
 * @create 2021/2/5
 * @since 1.0.0
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        String s = "abcda";
        System.out.println(validPalindrome.validPalindrome(s));
    }

    public boolean validPalindrome(String s) {
        int sLen = s.length();
        if (sLen < 2) {
            return true;
        }
        char[] charArray = s.toCharArray();
        for (int left = 0, right = sLen - 1; left < right; left++, right--) {
            if (charArray[left] != charArray[right]) {
                return secondVaild(charArray, left + 1, right) || secondVaild(charArray, left, right - 1);
            }
        }
        return true;
    }

    private boolean secondVaild(char[] s, int begin, int end) {
        while (begin < end) {
            if (s[begin++] != s[end--]) {
                return false;
            }
        }
        return true;
    }

}
