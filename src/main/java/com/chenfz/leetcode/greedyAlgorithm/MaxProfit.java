package com.chenfz.leetcode.greedyAlgorithm;

/**
 * @author chenfz
 * @description 122. 买卖股票的最佳时机 II
 * @date 2021-01-31 20:20
 */
public class MaxProfit {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i+1] - prices[i];
            if (diff > 0) {
                profit += diff;
            }
        }
        return profit;
    }
}
