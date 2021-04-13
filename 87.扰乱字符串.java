/*
 * @lc app=leetcode.cn id=87 lang=java
 *
 * [87] 扰乱字符串
 */

// @lc code=start
class Solution {
    public boolean isScramble(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2)
            return false;
        boolean[][][] dp = new boolean[len1][len1][len1 + 1];

        // 初始化dp
        for (int i = 0; i < len1; i++)
            for (int j = 0; j < len1; j++)
                dp[i][j][1] = (s1.charAt(i) == s2.charAt(j));

        // 从len=2开始规划
        for (int k = 2; k <= len1; k++) {
            for (int i = 0; i <= len1 - k; i++) {
                for (int j = 0; j <= len1 - k; j++) {
                    // 从1到k-1开始切割
                    for (int m = 1; m <= k - 1; m++) {
                        if (dp[i][j][m] && dp[i + m][j + m][k - m] || dp[i][j + k - m][m] && dp[i + m][j][k - m]) {
                            dp[i][j][k] = true;
                            break;
                        }
                    }
                }
            }
        }

        return dp[0][0][len1];
    }
}
// @lc code=end
