/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null)
            return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            if (obstacleGrid[i][n - 1] != 1)
                dp[i][n - 1] = 1;
            else
                break;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (obstacleGrid[m - 1][i] != 1)
                dp[m - 1][i] = 1;
            else
                break;
        }

        for (int i = m - 2; i >= 0; i--)
            for (int j = n - 2; j >= 0; j--) {
                if(obstacleGrid[i + 1][j] == 1 && obstacleGrid[i][j + 1] == 1)
                    dp[i][j] = 0;
                else if (obstacleGrid[i + 1][j] == 1)
                    dp[i][j] = dp[i][j + 1];
                else if (obstacleGrid[i][j + 1] == 1)
                    dp[i][j] = dp[i + 1][j];
                else if (obstacleGrid[i][j] == 1)
                    continue;
                else
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        return obstacleGrid[0][0] == 1 ? 0 : dp[0][0];
    }
}
// @lc code=end
