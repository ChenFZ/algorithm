/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: TwoSum
 * Author:   Chen FZ
 * Date:     2021/2/1 17:15
 * Description: 167. 两数之和 II - 输入有序数组
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.twoPointers;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br> 
 * 〈167. 两数之和 II - 输入有序数组 〉
 *
 * @author Chen FZ
 * @create 2021/2/1
 * @since 1.0.0
 */
public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));;
    }

    public static int[] twoSum(int[] numbers, int target) {
        int begin = 0;
        int last = numbers.length-1;
        while (last>begin){
            if(numbers[begin]+numbers[last]==target) break;
            if(numbers[begin]+numbers[last]<target){
                begin++;
            }else{
                last--;
            }
        }
        return new int[]{begin+1, last+1};
    }
}
