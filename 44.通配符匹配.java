/*
 * @lc app=leetcode.cn id=44 lang=java
 *
 * [44] 通配符匹配
 */

// @lc code=start
class Solution {
    //动态规划
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        boolean[][] d = new boolean[pLen + 1][sLen + 1];
        int i, j;
        //初始化数组为false
        for (i = 0; i < pLen + 1; i++)
            for (j = 0; j < sLen + 1; j++)
                d[i][j] = false;
        d[0][0] = true;

        for (i = 1; i < sLen + 1; i++) d[0][i] = false;
        for (i = 1; i < pLen + 1; i++) {
            d[i][0] = false;
            if (p.charAt(i - 1) == '*')
                if (d[i - 1][0]) d[i][0] = true;
            for (j = 1; j < sLen + 1; j++) {
                if (s.charAt(j - 1) == p.charAt(i - 1) || p.charAt(i - 1) == '?')
                    d[i][j] = d[i - 1][j - 1];
                else if (p.charAt(i - 1) == '*')
                    if (d[i][j - 1] || d[i - 1][j - 1] || d[i - 1][j]) d[i][j] = true;
            }
        }

        return d[pLen][sLen];
    }
}
// @lc code=end
