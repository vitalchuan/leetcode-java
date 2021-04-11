import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Deque;
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
        // int leftOffset = 0;
        // int rightOffset = 0;
        // while (i - leftOffset >= 0 && heights[i - leftOffset] >= heights[i])
        // leftOffset++;

        // while (i + rightOffset < len && heights[i + rightOffset] >= heights[i])
        // rightOffset++;

        // maxArea[i] = (leftOffset - 1 + rightOffset - 1 + 1) * heights[i];
        // }

        // Arrays.sort(maxArea);
        // return maxArea[maxArea.length - 1];

        // 堆栈
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] new_heights = new int[heights.length + 2];
        for (int i = 1; i < heights.length + 1; i++)
            new_heights[i] = heights[i - 1];
        // System.out.println(Arrays.toString(new_heights));
        for (int i = 0; i < new_heights.length; i++) {
            // System.out.println(stack.toString());
            while (!stack.isEmpty() && new_heights[stack.peek()] > new_heights[i]) {
                int cur = stack.pop();
                res = Math.max(res, (i - stack.peek() - 1) * new_heights[cur]);
            }
            stack.push(i);
        }
        return res;
    }
}
// @lc code=end
