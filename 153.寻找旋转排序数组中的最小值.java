import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        if (nums[0] <= nums[nums.length - 1])
            return nums[0];
        int start = 0;
        int end = nums.length - 1;
        int middle = 0;

        while (end != start + 1) {
            middle = (start + end) / 2;
            if (nums[start] > nums[middle])
                end = middle;
            else
                start = middle;
        }
        return nums[end];
    }
}
// @lc code=end
