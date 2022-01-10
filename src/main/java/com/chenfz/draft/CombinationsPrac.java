/**
 * Copyright (C), 2015-2021
 * Description:
 * <author>          <time>          <version>          <desc>
 * chenfz           2021/12/30 20:43           1.0              描述
 */
package com.chenfz.draft;

import java.util.*;

public class CombinationsPrac {
    public static void main(String[] args) {
        CombinationsPrac combine = new CombinationsPrac();
        List<List<Integer>> lists = combine.combine(4, 2);
        for (List list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    private List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        if (k<=0 || n<k){
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, 1, k, path);

        return res;
    }

    private void dfs(int n, int start, int h, Deque<Integer> path) {
        if (path.size() == h){
            res.add(new ArrayList<>(path));
            return;
        }
        if (start > n) return;
        for (int i = start; i <= n; i++) {
            path.addLast(i);
            dfs(n, i+1, h, path);
            path.removeLast();
        }
    }
}
