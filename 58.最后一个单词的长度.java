/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        int i = 0, j = 0;
        for (i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) != ' ')
                break;
        }
        for (j = i; j >= 0; j--) {
            if (s.charAt(j) == ' ')
                break;
        }
        return i - j;
    }
}
// @lc code=end
