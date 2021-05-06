import javax.lang.model.util.ElementScanner14;

/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */

// @lc code=start
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int numRow = triangle.size();
        if (numRow == 0)
            return 0;

        // dp表示到[i][j]的最短路径的大小
        int[][] dp = new int[numRow][numRow];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < numRow; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0)
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                else if (j == i)
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
        }

        int min = dp[numRow - 1][0];
        for (int i = 0; i < numRow; i++) {
            if (dp[numRow - 1][i] < min)
                min = dp[numRow - 1][i];
        }
        return min;
    }
}
// @lc code=end
