
/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */
import java.util.*;

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] current = strs[i].toCharArray();
            Arrays.sort(current);
            String strKey = Arrays.toString(current);
            if (map.containsKey(strKey)) {
                map.get(strKey).add(strs[i]);
            } else {
                map.put(strKey, new ArrayList<>());
                map.get(strKey).add(strs[i]);
            }
        }

        return new ArrayList<>(map.values());
    }
}
// @lc code=end
