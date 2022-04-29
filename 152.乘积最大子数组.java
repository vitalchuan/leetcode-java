/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int[] dp_max = new int[nums.length];
        int[] dp_min = new int[nums.length];

        dp_max[0] = nums[0];
        dp_min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                dp_max[i] = dp_max[i - 1] * nums[i];
                dp_min[i] = dp_min[i - 1] * nums[i];
            } else if (nums[i] < 0) {
                dp_max[i] = dp_min[i - 1] * nums[i];
                dp_min[i] = dp_min[i - 1] * nums[i];
            }

        }
    }
}
// @lc code=end
