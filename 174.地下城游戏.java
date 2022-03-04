/*
 * @lc app=leetcode.cn id=174 lang=java
 *
 * [174] 地下城游戏
 */
// @lc code=start
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int mLen = dungeon.length;
        int nLen = dungeon[0].length;
        int[][] dp = new int[mLen][nLen];

        dp[mLen - 1][nLen - 1] = Math.max(1 - dungeon[mLen - 1][nLen - 1], 1);

        for (int i = mLen - 2; i >= 0; i--)
            dp[i][nLen - 1] = Math.max(dp[i + 1][nLen - 1] - dungeon[i][nLen - 1], 1);

        for (int i = nLen - 2; i >= 0; i--)
            dp[mLen - 1][i] = Math.max(dp[mLen - 1][i + 1] - dungeon[mLen - 1][i], 1);

        for (int i = mLen - 2; i >= 0; i--)
            for (int j = nLen - 2; j >= 0; j--) 
                dp[i][j] = Math.max(Math.min(dp[i][j + 1], dp[i + 1][j]) - dungeon[i][j], 1);
            
        return dp[0][0];
    }
}
// @lc code=end
