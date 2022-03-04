import java.util.Set;

/*
 * @lc app=leetcode.cn id=139 lang=java
 *
 * [139] 单词拆分
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        Set<String> dict = new HashSet<>();
        for (String str : wordDict)
            dict.add(str);

        boolean[] dp = new boolean[len + 1];

        dp[0] = true;

        for (int i = 1; i <= len; i++)
            for (int j = 0; j <= i - 1; j++) {
                String LastString = s.substring(j,i);
                if (dp[j] && dict.contains(LastString)) {
                    dp[i] = true;
                    break;
                }
            }

        return dp[len];
    }
}
// @lc code=end
