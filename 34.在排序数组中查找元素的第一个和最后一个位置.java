/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{searchLeftEdge(nums,target),searchRightEdge(nums,target)};
    }

    public int searchLeftEdge(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int medium = - 1;
        while (left <= right) {
            medium = (left + right) / 2;
            if (nums[medium] < target)
                left = medium + 1;
            else if (nums[medium] > target)
                right = medium - 1;
            else if (nums[medium] == target) {
                right = medium;
                if (left == right) return medium;
            }
        }
        return - 1;
    }

    public int searchRightEdge(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int medium = - 1;
        while (left <= right) {
            medium = (left + right) / 2;
            if (nums[medium] < target)
                left = medium + 1;
            else if (nums[medium] > target)
                right = medium - 1;
            else if (nums[medium] == target) {
                if (medium == left)
                    return nums[right] == target ? right : left;
                else
                    left = medium;
            }
        }
        return - 1;
    }
}
// @lc code=end
