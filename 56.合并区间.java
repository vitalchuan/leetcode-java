import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        int[][] res = new int[len][2];
        Arrays.sort(intervals, (v1, v2) -> (v1[0] - v2[0]));
        int index = -1;

        for (int i = 0; i < len; i++) {
            if (index == -1)
                res[++index] = intervals[i];
            else if (intervals[i][0] > res[index][1]) {
                res[++index] = intervals[i];
            } else {
                res[index][1] = Math.max(res[index][1], intervals[i][1]);
            }
        }
        return Arrays.copyOfRange(res, 0, ++index);
    }
}
// @lc code=end
