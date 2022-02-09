/**
 * Copyright (C), 2015-2022, 航天广信有限公司
 * FileName: KeysKeyboard
 * Author:   Chen FZ
 * Date:     2022/2/6 19:59
 * Description: 650. 只有两个键的键盘
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.dynamicprogramming.stringeditor;

/**
 * 〈一句话功能简述〉<br>
 * 〈650. 只有两个键的键盘〉
 * 最初记事本上只有一个字符 'A' 。你每次可以对这个记事本进行两种操作：
 * <p>
 * Copy All（复制全部）：复制这个记事本中的所有字符（不允许仅复制部分字符）。
 * Paste（粘贴）：粘贴 上一次 复制的字符。
 * 给你一个数字n ，你需要使用最少的操作次数，在记事本上输出 恰好n个 'A' 。返回能够打印出n个 'A' 的最少操作次数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：3
 * 输出：3
 * 解释：
 * 最初, 只有一个字符 'A'。
 * 第 1 步, 使用 Copy All 操作。
 * 第 2 步, 使用 Paste 操作来获得 'AA'。
 * 第 3 步, 使用 Paste 操作来获得 'AAA'。
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：0
 *
 * @author Chen FZ
 * @create 2022/2/6
 * @since 1.0.0
 */
public class KeysKeyboard {
    public static void main(String[] args) {
        System.out.println(new KeysKeyboard().minSteps(4));
    }

    // j能被i整除，则 dp[i] = dp[j] + i/j
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
                }
            }
        }
        return dp[n];
    }
}
