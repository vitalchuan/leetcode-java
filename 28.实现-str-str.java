/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 实现 strStr()
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        //暴力法 时间复杂度O(mn),mn为两数组长度
        // if(needle.equals(""))
        //     return 0;
        // int i = 0,j = 0;
        // int haystackLen = haystack.length();
        // int needleLen = needle.length();
        // for(i = 0;i<haystackLen;i++,j = 0){
        //     int m = i,n = j;
        //     while(haystack.charAt(m) == needle.charAt(n)){
        //         if(n == needleLen-1)
        //             return m-needle.length()+1;
        //         if(m == haystackLen-1)
        //             break;
        //         m++;n++;
        //     }
        // }
        // return -1;
            

    }
}
// @lc code=end

