/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0')
            return 0;
        int[] dp = new int[s.length()];
        dp[0] = 1;

        for (int i = 1; i < s.length(); i++) {
            // 首先判断新字符是不是0
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    dp[i] = i != 1 ? dp[i - 2] : 1;
                } else {
                    return 0;
                }

            } else {// 新字符不是0
                if (s.charAt(i - 1) == '0') {// 前一个字符是0
                    dp[i] = dp[i - 1];
                } else {// 前一个字符不是0
                    int a = Integer.parseInt(s.substring(i - 1, i + 1));
                    if (a > 26)
                        dp[i] = dp[i - 1];
                    else
                        dp[i] = i != 1 ? dp[i - 1] + dp[i - 2] : 2;
                }
            }
        }

        return dp[s.length() - 1];

    }
}
// @lc code=end
