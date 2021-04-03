import java.util.Arrays;
import java.util.Collection;

/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 */

// @lc code=start
class Solution {
    public int largestRectangleArea(int[] heights) {
        // 暴力法 time limit exceeded
        // int len = heights.length;
        // int[] maxArea = new int[len];
        // for (int i = 0; i < len; i++) {
        //     int leftOffset = 0;
        //     int rightOffset = 0;
        //     while (i - leftOffset >= 0 && heights[i - leftOffset] >= heights[i])
        //         leftOffset++;

        //     while (i + rightOffset < len && heights[i + rightOffset] >= heights[i])
        //         rightOffset++;

        //     maxArea[i] = (leftOffset - 1 + rightOffset - 1 + 1) * heights[i];
        // }

        // Arrays.sort(maxArea);
        // return maxArea[maxArea.length - 1];
        
        //堆栈
        
    }
}
// @lc code=end
