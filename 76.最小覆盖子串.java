/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        // 暴力解法
        int minLen = s.length();
        String strRes="";
        int i = 0, j = t.length();
        for (i = 0; i <= s.length() - t.length(); i++) {
            for (j = i + t.length(); j <= s.length(); j++) {
                String str1 = s.substring(i, j);
                if (isValid(str1, t)) {
                    if ((j - i) <= minLen) {
                        minLen = j-i;
                        strRes = str1;
                    }
                    break;
                }
            }
        }
        return strRes;
    }

    public boolean isValid(String s, String t) {
        HashMap<Character, Integer> needHashMap = new HashMap<>();
        // 构建hashmap
        for (int i = 0; i < t.length(); i++) {
            if (needHashMap.containsKey(t.charAt(i)))
                needHashMap.put(t.charAt(i), needHashMap.get(t.charAt(i)) + 1);
            else
                needHashMap.put(t.charAt(i), 1);
        }

        // s中逐位验证
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (needHashMap.containsKey(c)) {
                needHashMap.put(c, needHashMap.get(c) - 1);
            }
        }

        for (int i : needHashMap.values()) {
            if (i > 0)
                return false;
        }
        return true;
    }
}
// @lc code=end
