/*
 * @lc app=leetcode.cn id=68 lang=java
 *
 * [68] 文本左右对齐
 */

// @lc code=start
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int i = 0;
        while (i < words.length) {
            int j = i;
            // 计算当前行能容纳的单词数
            while (true) {

            }
        }
    }

    public int bitNum(String[] words, int i, int j) {
        int num = 0;
        for (int m = i; m <= j; m++) 
            num += words[m].length();
        
        num += j - i;
    }
}
// @lc code=end
