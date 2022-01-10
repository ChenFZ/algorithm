/**
 * Copyright (C), 2015-2021
 * Description:
 * <author>          <time>          <version>          <desc>
 * chenfz           2021/12/30 17:12           1.0              描述
 */
package com.chenfz.draft;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        System.out.println(permutations.permute(new int[]{1,2,3}));
    }

    private List<List<Integer>> res;
    private boolean[] visited;
    private int length;
    private LinkedList<Integer> temp;
    public List<List<Integer>> permute(int[] arr){
        res = new ArrayList<>();
        length = arr.length;
        if (arr == null || length <= 0 ){
            return res;
        }
        for (int i = 0; i < length; i++) {
            visited = new boolean[length];
            temp = new LinkedList<>();
            sort(arr, i, temp);
        }

        return res;
    }

    private void sort(int[] arr, int i, LinkedList<Integer> temp) {
        visited[i] = true;
        temp.addLast(arr[i]);
        if (temp.size() == length){
            res.add(List.copyOf(temp));
            return;
        }
        for (int j = 0; j < length; j++) {
            if (!visited[j]){
                sort(arr, j, temp);
                visited[j] = false;
                temp.removeLast();
            }
        }
    }
}
