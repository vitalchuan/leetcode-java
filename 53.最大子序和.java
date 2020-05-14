/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start

import java.util.*;

class Solution {
    /**
     * 分治法 O(N * log N)
     */
    // public int maxSubArray(int[] nums) {
    // int left = 0;
    // int right = nums.length - 1;

    // return maxSubArray(nums, left, right);

    // }

    // public int maxSubArray(int[] nums, int left, int right) {
    // if (left == right)
    // return nums[left];
    // if(left > right) return 0;
    // int medium = (left + right) / 2;
    // int leftMaxSubArray = maxSubArray(nums, left, medium - 1);
    // int rightMaxSubArray = maxSubArray(nums, medium + 1, right);
    // int res1 = Math.max(leftMaxSubArray, rightMaxSubArray);

    // int sum = nums[medium];
    // int mediumMaxSubArray1 = nums[medium];
    // int mediumMaxSubArray2 = nums[medium];

    // for (int i = medium - 1; i >= left; i--) {
    // sum += nums[i];
    // mediumMaxSubArray1 = Math.max(sum, mediumMaxSubArray1);
    // }

    // sum = nums[medium];

    // for (int i = medium + 1; i <= right; i++) {
    // sum += nums[i];
    // mediumMaxSubArray2 = Math.max(sum, mediumMaxSubArray2);
    // }
    // int mediumMaxSubArray = mediumMaxSubArray1 + mediumMaxSubArray2 -
    // nums[medium];

    // return left == medium ? Math.max(rightMaxSubArray, mediumMaxSubArray) :
    // Math.max(res1, mediumMaxSubArray);
    // }

    // 动态规划
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] < 0)
                dp[i] = nums[i];
            else
                dp[i] = nums[i] + dp[i - 1];
        }
        int max = dp[0];
        for(int i=0;i<dp.length;i++){
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
// @lc code=end
