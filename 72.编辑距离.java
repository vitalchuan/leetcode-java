/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < n + 1; i++)
            dp[0][i] = i;
        for (int j = 0; j < m + 1; j++)
            dp[j][0] = j;

        for (int i = 1; i < m + 1; i++)
            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else{
                    int a = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                    dp[i][j] = Math.min(a, dp[i][j - 1]) + 1;
                }
            }
        return dp[m][n];
    }
}
// @lc code=end
