import java.util.Arrays;
import java.util.*;

/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 颠倒字符串中的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        String a = s.trim();
        List<String> list = Arrays.asList(a.split("\\s+"));

        Collections.reverse(list);
        return String.join(" ", list);

    }
}
// @lc code=end
