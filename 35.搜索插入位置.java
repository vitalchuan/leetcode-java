/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int medium = -1;
        while(left <= right){
            medium = (left + right) / 2;
            if(nums[medium] < target)
                left = medium + 1;
            else if (nums[medium] > target)
                right = medium - 1;
            else if(nums[medium] == target){
                return medium;
            }
        }
        return left;
    }
}
// @lc code=end

