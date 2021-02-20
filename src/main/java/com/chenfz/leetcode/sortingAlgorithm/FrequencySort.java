/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: FrequencySort
 * Author:   Chen FZ
 * Date:     2021/2/15 10:38
 * Description: 451. 根据字符出现频率排序  Sort Characters By Frequency (Medium)
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.sortingAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈451. 根据字符出现频率排序  Sort Characters By Frequency (Medium)〉
 * 输入:
 * "tree"
 * <p>
 * 输出:
 * "eert"
 * <p>
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 *
 * @author Chen FZ
 * @create 2021/2/15
 * @since 1.0.0
 */
public class FrequencySort {
    public static void main(String[] args) {
        System.out.println(frequencySort("cccaaa"));
    }

    public static String frequencySort(String s) {
        //int桶记录出现次数
        int[] freq = new int[128];
        char[] chars = s.toCharArray();
        for (char c :
                chars) {
            freq[c]++;
        }

        List<Character>[] lists = new ArrayList[s.length() + 1];
        for (int i = 0; i < freq.length; i++) {
            int value = freq[i];
            if (lists[value] == null) {
                lists[value] = new ArrayList<>();
            }
            lists[value].add((char) i);
        }

        StringBuffer buffer = new StringBuffer();
        for (int i = lists.length - 1; i > 0; i--) {
            if (lists[i] != null) {
                for (char c :
                        lists[i]) {
                    for (int j = i; j > 0; j--) {
                        buffer.append(c);
                    }
                }
            }
        }
        return buffer.toString();
    }
}
