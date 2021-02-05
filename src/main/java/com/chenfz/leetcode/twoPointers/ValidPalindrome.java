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
        String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        System.out.println(validPalindrome(s));
    }

    public static boolean validPalindrome(String s) {
        int sLen = s.length();
        if(sLen<2){
            return true;
        }
        char[] charArray = s.toCharArray();
        int left = 0, right = sLen-1;
        int count = 0;
        while (left<=right){
            if(charArray[left] == charArray[right]){
                left++;
                right--;
            }else{
                if(charArray[left+1] == charArray[right]){
                    count++;
                    left++;
                }else if(charArray[left] == charArray[right-1]) {
                    count++;
                    right--;
                }else{
                    return false;
                }
                if(count>1){
                    return false;
                }
            }
        }
        return true;
    }
}
