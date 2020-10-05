package com.chenfz.Leetcode;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

/**
 * @author chenfz
 * @description 46. 全排列
 * @date 2020-10-05 16:53
 */
public class Perm {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        Perm.permImpl(a, "");
    }

    //    迭代，将前面的数字固定下来
    static void permImpl(int[] arr, String str) {
        if (arr.length > 1) {
            for (int i = 0; i < arr.length; i++) {
                int[] res = ArrayUtils.addAll(Arrays.copyOfRange(arr, 0, i), Arrays.copyOfRange(arr, i + 1, arr.length));
                permImpl(res, str + arr[i]);
            }
        } else {
            System.out.println(str + arr[0]);
        }
    }
}
