import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=137 lang=java
 *
 * [137] 只出现一次的数字 II
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> record = new HashMap<>();
        
        for (int i : nums) {
            record.putIfAbsent(i, -1);
            record.put(i, record.get(i) + 1);
        }

        for (int i : record.keySet()) {
            if (record.get(i) == 0)
                return i;
        }

        return 1;
    }
}
// @lc code=end
