import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String pre = strs[0];
        for(int i=1;i<strs.length;i++)
        {
            while((a=strs[i].indexOf(pre))!=0)
            {
                pre = pre.substring(0,pre.length()-1);
                if(pre.isEmpty()) return "";
            }
        }
        return pre;
    }
}
// @lc code=end

