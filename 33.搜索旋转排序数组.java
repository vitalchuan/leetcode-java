/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int len =nums.length;
        if(len == 0) return -1;
        int rotate_index = searchRotatePoint(nums,0,len-1);
        if(rotate_index == 0) return BinarySearch(nums,0,len - 1,target);
        if(nums[0] <= target) return BinarySearch(nums,0, rotate_index-1,target);
        else return BinarySearch(nums,rotate_index, len -1,target);
    }

    public int searchRotatePoint(int[] nums, int left, int right) {
        if(left > right) return -1;
        if (nums[left] <= nums[right]) return 0;
        while (left < right) {
            int medium = (left + right) / 2;
            if ((left + 1) == right) {
                return nums[left] > nums[right] ? right : left;
            }
            if (nums[medium] < nums[left]) {
                right = medium;
            } else if (nums[medium] > nums[left])
                left = medium;
        }
        return - 1;
    }

    public int BinarySearch(int[] nums,int left,int right,int target){
        while(left <= right){
            int medium = (left + right) / 2;
            if(left == right && nums[medium] != target) return -1;
            if(nums[medium] == target) return medium;
            else if(nums[medium] < target)
                left = medium + 1;
            else if(nums[medium] > target)
                right = medium;
        }
        return -1;
    }
}
// @lc code=end
