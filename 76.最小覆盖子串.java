import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        // 暴力解法
        int i = 0, j = t.length();
        for (i = 0; i <= s.length() - t.length(); i++) {
            for (j = i + t.length(); j <= s.length(); j++) {
                String str1 = s.sbustring(i, j);

            }
        }
    }

    public boolean isValid(String s, String t) {
        HashMap<Character, Integer> needHashMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (needHashMap.containsKey(t.charAt(i)))
                needHashMap.put(t.charAt(i), needHashMap.get(t.charAt(i)) + 1);
            else
                needHashMap.put(t.charAt(i), 1);
        }

        for (int i = 0; i < s.length(); i++) {
            
        }
    }
}
// @lc code=end
