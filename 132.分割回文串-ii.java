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
        boolean[][] isHuiWen = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++)
            isHuiWen[i][i] = true;

        for (int j = 1; j < s.length(); j++)
            for (int i = 0; i < j; i++) {
                if (j - i == 1)
                    isHuiWen[i][j] = charArray[i] == charArray[j];
                else {
                    isHuiWen[i][j] = isHuiWen[i + 1][j - 1] && (charArray[i] == charArray[j]);
                }
            }

        

    }
}
// @lc code=end
