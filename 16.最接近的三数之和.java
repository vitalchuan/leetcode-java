
/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */
import java.util.*;

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        /**
         * 双指针法
         * 时间复杂度：O(n^2)
         */
        Arrays.sort(nums);
        int i = 0, j = 1, k = nums.length - 1;
        int temp = nums[0] + nums[1] + nums[nums.length-1];
        int tempResult = temp;
        int diffMin = Math.abs(nums[0] + nums[1] + nums[nums.length-1] - target);
        for (i = 0; i <= nums.length - 3; i++, j = i + 1, k = nums.length - 1)
        {
            while (j < k)
            {
                temp = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(temp - target);
                if (diff < diffMin)
                {
                    diffMin = diff;
                    tempResult = temp;
                }
                if ((temp - target) < 0)
                    j++;
                if ((temp - target) > 0)
                    k--;
                if (diff == 0) return temp;
            }
        }
        return tempResult;
    }
}
// @lc code=end
