/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: StrStr
 * Author:   chenfz
 * Date:     2019/3/13 9:59
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.StringPatch;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 * @author chenfz
 * @create 2019/3/13
 * @since 1.0.0
 */
public class StrStr {

    public int strStr(String haystack, String needle) {
        // 非KMP实现，暴力循环法
        if("".equals(needle)) return 0;
        if(haystack.length()<needle.length()) return -1;
        char[] hChars = haystack.toCharArray();
        char[] nChars = needle.toCharArray();
        for(int i=0;i<=hChars.length-nChars.length;i++){
            boolean flag = true;
            for(int j=0;j<nChars.length;j++){
                if(hChars[i+j]!=nChars[j]){
                    flag = false;
                    break;
                }
            }
            if(flag) return i;
        }
        return -1;
    }
}
