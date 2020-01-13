import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        int i = strs[0].length();
        int result = 0;
        boolean flag = false;
        //找到最短字符串的长度
        while(n-->0)
        {
            if(strs[n-1].length() < i)
                i = strs[n-1].length();
        }

        for(int j = 0; j < i; j++)
        {
            for(int m=0;m<strs.length-1;m++)
                if(strs[m].charAt(j) != strs[m+1].charAt(j))
                    {flag=true;break;}
            if(flag == false)
                result++;
            else
                break;
        }
        return strs[0].substring(0,result);
    }
}
// @lc code=end

