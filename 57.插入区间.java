import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 */

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int index = -1;
        int[][] res = new int[intervals.length + 1][2];

        int i = 0;
        // 将newInterval开始前的的interval都加入res
        for (i = 0; i < intervals.length; i++) {
            if (intervals[i][0] < newInterval[0])
                res[++index] = intervals[i];
            else {
                // index可能为-1
                if (index == -1) {
                    res[++index] = newInterval;
                } else {
                    if (newInterval[0] <= res[index][1])
                        if (newInterval[1] <= res[index][1]) {
                            // newInterval在res的其中一个区间内，可直接返回
                            // return intervals;
                            return Arrays.copyOfRange(intervals, 0, intervals.length);
                        } else
                            res[index][1] = newInterval[1];
                    else
                        res[++index] = newInterval;
                }
                break;
            }
        }
        // newInterval区间在intervals所有区间的后面
        if (i == intervals.length) {
            if (intervals.length == 0)
                res[++index] = newInterval;
            else {
                if (newInterval[0] > res[index][1])
                    res[++index] = newInterval;
                else if (newInterval[1] > res[index][1])
                    res[index][1] = newInterval[1];
            }
        }

        for (; i < intervals.length; i++) {
            if (intervals[i][0] <= res[index][1]) {
                if (intervals[i][1] > res[index][1])
                    res[index][1] = intervals[i][1];
            } else {
                res[++index] = intervals[i];
            }
        }
        return Arrays.copyOfRange(res, 0, ++index);
    }
}
// @lc code=end
