package com.chenfz.leetcode.greedyAlgorithm;

import java.util.Arrays;

/**
 * @author chenfz
 * @description 452. 用最少数量的箭引爆气球
 * @date 2021-01-29 11:55
 */
public class FindMinArrowShots {

    public static void main(String[] args) {

    }

    public static int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;

//        右边界排序
        Arrays.sort(points, (a, b)->a[1]<b[1]?-1:1);
        int remove = 0;
        int prev = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if(points[i][0]<=prev){
                remove++;
            }else{
                prev = points[i][1];
            }
        }
        return points.length - remove;
    }
}
