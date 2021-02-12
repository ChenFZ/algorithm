/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: MySqrt
 * Author:   Chen FZ
 * Date:     2021/2/10 16:27
 * Description: 69. x 的平方根 Sqrt(x) (Easy)
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.binarySearch;

/**
 * 〈一句话功能简述〉<br>
 * 〈69. x 的平方根 Sqrt(x) (Easy)〉
 * <p>
 * 实现int sqrt(int x)函数。
 * 计算并返回x的平方根，其中x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 *
 * @author Chen FZ
 * @create 2021/2/10
 * @since 1.0.0
 */
public class MySqrt {

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }

    public static int mySqrt(int x) {
        //if (x < 1) {
        //    return 0;
        //}
        //int begin = 1, end = x;
        //int mid = 0;
        //while (begin<=end) {
        //    mid = (end + begin) / 2;
        //    int sqrt = x/mid;
        //    if(sqrt == mid){
        //        return mid;
        //    } else if (sqrt < mid) {
        //        end = mid - 1;
        //    } else {
        //        begin = mid + 1;
        //    }
        //}
        //return end;

        //牛顿迭代法
        long a = x;
        while (a*a>x){
            a = (a+x/a)/2;
        }
        return (int) a;

        //if (a == 0) return a;
        //int l = 1, r = a, mid, sqrt;
        //while (l <= r) {
        //    mid = l + (r - l) / 2;
        //    sqrt = a / mid;
        //    if (sqrt == mid) {
        //        return mid;
        //    } else if (mid > sqrt) {
        //        r = mid - 1;
        //    } else {
        //        l = mid + 1;
        //    }
        //}
        //return r;
    }
}
