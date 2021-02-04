package com.chenfz.leetcode.greedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenfz
 * @description 406. 根据身高重建队列
 * @date 2021-01-31 20:40
 */
public class ReconstructQueue {

    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        people = reconstructQueue(people);
        for (int i = 0; i < people.length; i++) {
            System.out.println(Arrays.toString(people[i]));
        }
    }

    public static int[][] reconstructQueue(int[][] people) {
        if(people.length == 0 || people[0].length == 0){
            return new int[0][0];
        }
//     h降序，k升序排序
        Arrays.sort(people, (a, b) -> b[0] == a[0] ? a[1] - b[1] : b[0] - a[0]);

        List<int[]> list = new ArrayList<>();
        for(int[] i: people){
            list.add(i[1], i);
        }
        return list.toArray(new int[list.size()][]);
    }
}
