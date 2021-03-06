import java.util.Set;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 *
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (31.20%)
 * Likes:    2357
 * Dislikes: 0
 * Total Accepted:    204.3K
 * Total Submissions: 654.8K
 * Testcase Example:  '"abcabcbb"'
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 示例 1:
 * 
 * 输入: "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 
 * 示例 2:
 * 
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 
 * 示例 3:
 * 
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 
 */
//滑动窗口HashSet
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0,j=0,maxLen=0;
        int n=s.length();
        Set<Character> hSet=new HashSet<>();
        while(j<n)
        {
            if(hSet.contains(s.charAt(j)))
            {
                hSet.remove(s.charAt(i));
                i++;
            }
            else
            {
                hSet.add(s.charAt(j));
                j++;
                maxLen=Math.max(maxLen,j-i);
            }
        }
        return maxLen;
    }
}

