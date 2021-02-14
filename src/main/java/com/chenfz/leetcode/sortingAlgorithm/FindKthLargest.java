/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: FindKthLargest
 * Author:   Chen FZ
 * Date:     2021/2/14 11:42
 * Description: 215. 数组中的第K个最大元素  Kth Largest Element in an Array
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.sortingAlgorithm;

import java.util.PriorityQueue;

/**
 * 〈一句话功能简述〉<br>
 * 〈215. 数组中的第K个最大元素  Kth Largest Element in an Array〉
 * <p>
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * @author Chen FZ
 * @create 2021/2/14
 * @since 1.0.0
 */
public class FindKthLargest {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        System.out.println(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        int l = 0, r = nums.length - 1, mid;
        while (l < r) {
            mid = quick_sork(nums, l, r);

            if (mid + k == nums.length) {
                return nums[mid];
            } else if (mid + k < nums.length) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return nums[l];
    }

    private static int quick_sork(int[] nums, int l, int r) {
        int p = l, q = r, mid;
        int mark = nums[l];
        while (p < q) {
            while (p < q && nums[q]>=mark){
                q--;
            }
            while (p < q && nums[p]<=mark){
                p++;
            }
            if(p < q){
                QuickSort.swap(nums, p, q);
            }
        }
        QuickSort.swap(nums, p, l);
        return p;
    }


    public static int findKthLargest2(int[] nums, int k) {
        //堆结构特性，k长度的优先队列 时间复杂度：O(nlogk),其中调整堆O(logk),空间复杂度：O(k)
        PriorityQueue<Integer> queue = new PriorityQueue<>((n1, n2) -> n1 - n2);
        for (int num :
                nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();

        //int len = nums.length;
        //int[] temp = new int[len];
        //MergeSort.merge_sort(nums, 0, len - 1, temp);
        //return nums[len - k];
    }


}
