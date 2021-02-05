/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: JudgeSquareSum
 * Author:   Chen FZ
 * Date:     2021/2/5 15:29
 * Description: 633. 平方数之和  Sum of Square Numbers (Easy)
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.twoPointers;

/**
 * 〈一句话功能简述〉<br> 
 * 〈633. 平方数之和  Sum of Square Numbers (Easy)〉
 *
 * @author Chen FZ
 * @create 2021/2/5
 * @since 1.0.0
 */
public class JudgeSquareSum {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(8));
    }

    public static boolean judgeSquareSum(int c) {
        if(c<3){
            return true;
        }
        int a = 0;
        int b = (int)Math.floor(Math.sqrt(c));
        while (a<=b){
            int res = (int)Math.pow(a,2)+(int)Math.pow(b,2);
            if(res == c){
                return true;
            }else if (res<c){
                a++;
            }else{
                b--;
            }
        }
        return false;
    }
}
