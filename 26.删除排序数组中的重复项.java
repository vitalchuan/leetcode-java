/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        while (i <= nums.length - 1) {
            nums[j] = nums[i];
            i++;
            if(i > nums.length-1)
                break;
            if(nums[i] == nums[i-1])
                continue;
            j++;
        }
        return j+1;

        // if (nums.length == 0) return 0;
        // int i = 0;
        // for (int j = 1; j < nums.length; j++) {
        //     if (nums[j] != nums[i]) {
        //         i++;
        //         nums[i] = nums[j];
        //     }
        // }
        // return i + 1;
    }
}
// @lc code=end
