package com.chenfz.leetcode.greedyAlgorithm;

import java.util.Arrays;

/**
 * @author chenfz
 * @description 605. 种花问题
 * @date 2021-01-29 10:29
 */
public class CanPlaceFlowers {

    public static void main(String[] args) {
        int[] flowerbed = {1,0,0,0,1};
        int[] copyArray = Arrays.copyOf(flowerbed, flowerbed.length);
        System.out.println(Arrays.toString(flowerbed)+" ...... "+Arrays.toString(copyArray));
        int[][] points = {{1,2},{2,3}};
        Arrays.sort(points, (a,b)->a[1]<b[1]?-1:1);
        Arrays.fill(copyArray, 1);
        System.out.println(Arrays.toString(copyArray));
        int n = 0;
        System.out.println(canPlaceFlowers(flowerbed,n));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        int totalFlowers = 0;
        if (flowerbed.length == 1 && flowerbed[0] == 0) {
            totalFlowers = 1;
            return isOK(totalFlowers,n);
        }

        for (int i = 0; i < flowerbed.length; i++) {
            if (i == 0) {
                if(flowerbed[i] == 0&&flowerbed[1]==0){
                    flowerbed[i] = 1;
                    totalFlowers++;
                }
            }else if(i == flowerbed.length -1){
                if(flowerbed[i-1]==0 && flowerbed[i] == 0){
                    flowerbed[i] = 1;
                    totalFlowers++;
                }
            }else{
                if(flowerbed[i-1]==0&&flowerbed[i]==0&&flowerbed[i+1]==0){
                    flowerbed[i] = 1;
                    totalFlowers++;
                }
            }
        }
        return isOK(totalFlowers,n);
    }

    private static boolean isOK(int totalFlowers,int n){
        return n <= totalFlowers;
    }
}
