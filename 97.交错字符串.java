/*
 * @lc app=leetcode.cn id=97 lang=java
 *
 * [97] 交错字符串
 */

// @lc code=start
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 + len2 != s3.length())
            return false;

        boolean[][] dp = new boolean[len1 + 1][len2 + 1];

        for (int j = 0; j < len2 + 1; j++)
            dp[0][j] = s2.substring(0, j).equals(s3.substring(0, j));

        for (int i = 0; i < len1 + 1; i++)
            dp[i][0] = s1.substring(0, i).equals(s3.substring(0, i));

        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                boolean a = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                boolean b = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);

                dp[i][j] = a || b;
            }
        }

        return dp[len1][len2];
    }
}
// @lc code=end
