/*
 * @lc app=leetcode.cn id=162 lang=java
 *
 * [162] 寻找峰值
 */

// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        // 二分法 查找局部峰值
        int start = 0, end = nums.length - 1;

        while (start < end) {
            int middle = (start + end) / 2;
            if (isPeak(nums, middle))
                return middle;
            if (nums[middle] < nums[middle - 1])
                end = middle - 1;
            else
                start = middle + 1;
        }
        return 0;
    }

    public boolean isPeak(int[] nums, int index) {
        if (index == 0)
            return nums[index] > nums[index + 1];
        if (index == nums.length - 1)
            return nums[index] > nums[index - 1];
        return (nums[index] > nums[index + 1]) && (nums[index] > nums[index - 1]);
    }
}
// @lc code=end
