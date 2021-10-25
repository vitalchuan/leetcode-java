/*
 * @lc app=leetcode.cn id=134 lang=java
 *
 * [134] 加油站
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 暴力法
        int len = gas.length;
        for (int start = 0; start < len; start++) {
            int current = 0;
            boolean success = true;
            for (int step = 0; step < len; step++) {
                current += gas[(start + step) % len];
                current -= cost[(start + step) % len];
                if (current < 0) {
                    success = false;
                    if (start + step >= len)
                        return -1;
                    else
                        start = (start + step) % len;
                    break;
                }
            }
            if (success)
                return start;
        }

        return -1;
    }
}
// @lc code=end
