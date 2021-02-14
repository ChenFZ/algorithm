/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: TopKFrequent
 * Author:   Chen FZ
 * Date:     2021/2/14 20:37
 * Description: 347. 前 K 个高频元素   Top K Frequent Elements (Medium)
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.sortingAlgorithm;

import java.util.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈347. 前 K 个高频元素   Top K Frequent Elements (Medium)〉
 *
 * @author Chen FZ
 * @create 2021/2/14
 * @since 1.0.0
 */
public class TopKFrequent {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        //hash桶
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        //桶排序
        List<Integer>[] list = new List[nums.length + 1];
        for (int key :
                map.keySet()) {
            int freq = map.get(key);
            if (list[freq] == null) {
                list[freq] = new ArrayList<>();
            }
            list[freq].add(key);
        }

        //倒序遍历数组获取出现频率从大到小的排列
        for (int i = list.length - 1; i >= 0 && res.size() < k; i--) {
            if (list[i] != null) {
                res.addAll(list[i]);
            }
        }
        //int[] integers = res.toArray(new int[res.size()]);
        int[] ints = res.stream().mapToInt(i -> i).toArray();
        return ints;
    }
}
