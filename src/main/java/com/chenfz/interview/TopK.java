/**
 * Copyright (C), 2015-2021
 * Description: 算法必学：经典的 Top K 问题
 * <author>          <time>          <version>          <desc>
 * chenfz           2021/12/11 16:05           1.0              描述
 */
package com.chenfz.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 功能描述: <br>
 * 〈什么是 Top K 问题？简单来说就是在一堆数据里面找到前 K 大（当然也可以是前 K 小）的数。
 *
 * 这个问题也是十分经典的算法问题，不论是面试中还是实际开发中，都非常典型。而这个问题其实也有很多种做法，你真的都懂了么？
 * 我们可以直接使用优先队列 PriorityQueue 来实现一个小顶堆，这里给个代码
 * https://juejin.cn/post/6844903774004183047
 *
 No such property: code for class: Script1
 * @return:
 * @since: 1.0.0
 * @Author:chenfz
 * @Date: 2021/12/11 16:05
 */
public class TopK {

    public static void main(String[] args) {
        int[] arr = new int[]{4,3,2,11};
        TopK topK = new TopK();

        topK.solutionByHeapBottomK(arr, 3).forEach(System.out::println);
        topK.solutionByHeap(arr, 3).forEach(System.out::println);
    }

    public List<Integer> solutionByHeap(int[] input, int k) {
        List<Integer> list = new ArrayList<>();
        if (k > input.length || k == 0) {
            return list;
        }
        //小顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : input) {
            if (queue.size() < k){
                queue.add(num);
            }else if(queue.peek() < num){
                queue.poll();
                queue.add(num);
            }
        }
        while (k-- > 0) {
            list.add(queue.poll());
        }
        return list;
    }

    public List<Integer> solutionByHeapBottomK(int[] input, int k) {
        List<Integer> list = new ArrayList<>();
        if (k > input.length || k == 0) {
            return list;
        }
        //大顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 > o2 ? -1 : 1);
        for (int num : input) {
            if (queue.size() < k) {
                queue.add(num);
            } else if (queue.peek() > num){
                queue.poll();
                queue.add(num);
            }
        }
        while (k-- > 0) {
            list.add(queue.poll());
        }
        return list;
    }
}
