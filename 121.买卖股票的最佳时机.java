/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        // 暴力法 TLE
        // int max = 0;
        // for (int i = 0; i < prices.length; i++)
        // for (int j = i; j < prices.length; j++)
        // if (prices[j] - prices[i] > max)
        // max = prices[j] - prices[i];
        // return max;

        // O(N) 方法
        int minPrice = Integer.MAX_VALUE;
        int maxGain = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                if (prices[i] - minPrice > maxGain)
                    maxGain = prices[i] - minPrice;
            }
        }
        return maxGain;
    }
}
// @lc code=end
