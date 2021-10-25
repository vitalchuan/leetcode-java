/*
 * @lc app=leetcode.cn id=132 lang=java
 *
 * [132] 分割回文串 II
 */

// @lc code=start
class Solution {
    public int minCut(String s) {
        // 动态规划 判断是否回文
        char[] charArray = s.toCharArray();
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++)
            isPalindrome[i][i] = true;

        for (int j = 1; j < s.length(); j++)
            for (int i = 0; i < j; i++)
                if (j - i == 1)
                    isPalindrome[i][j] = charArray[i] == charArray[j];
                else
                    isPalindrome[i][j] = isPalindrome[i + 1][j - 1] && (charArray[i] == charArray[j]);

        int[] dp = new int[s.length()];

        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            int min = dp.length;
            for (int j = 0; j < i; j++)
                if (isPalindrome[j + 1][i])
                    if (min > dp[j] + 1)
                        min = dp[j] + 1;
            if (isPalindrome[0][i])
                min = 0;

            dp[i] = min;
        }
        return dp[dp.length - 1];
    }
}
// @lc code=end
