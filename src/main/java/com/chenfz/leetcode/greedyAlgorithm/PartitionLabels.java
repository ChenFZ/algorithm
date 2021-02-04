package com.chenfz.leetcode.greedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenfz
 * @description 763. 划分字母区间
 * @date 2021-01-31 19:58
 */
public class PartitionLabels {
    public static void main(String[] args) {
        List list = partitionLabels("ababcbacadefegdehijhklij");
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static List<Integer> partitionLabels(String S) {
//        得到每个字母的最后出现位置
        int[] last = new int[26];
        for (int i = 0; i < S.length(); i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (i == end) {
                list.add(end - start + 1);
                start = end + 1;
            }
        }
        return list;
    }
}
