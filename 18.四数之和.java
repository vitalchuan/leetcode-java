import java.beans.Transient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 双指针法 时间复杂度：O(n^3)
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0, j = i + 1;
        int n = nums.length - 1;
        int m = n - 1;
        for (i = 0; i <= nums.length - 4; i++) {
            // 确保nums[a]为新的值
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            for (j = i + 1; j <= nums.length - 3; j++) {
                // 确保nums[j]为新值
                if (nums[j] == nums[j - 1] && j != i + 1)
                    continue;
                m = j + 1;
                n = nums.length - 1;
                while (m < n) {
                    int sum = nums[i] + nums[j] + nums[m] + nums[n];
                    if (sum == target) {

                        List<Integer> newList = new ArrayList<>();
                        newList.add(nums[i]);
                        newList.add(nums[j]);
                        newList.add(nums[m]);
                        newList.add(nums[n]);
                        list.add(newList);
                        /**
                         * 移动至少一次确保nums[m]和nums[n]为新值
                         */
                        m++;
                        while (nums[m] == nums[m - 1] && m != nums.length - 1)
                            m++;
                        n--;
                        while (nums[n] == nums[n + 1] && n != 0)
                            n--;
                    } else if (sum < target)
                        /**
                         * 没有必要确认num[m]是新值。 nums[m]为重值只会浪费些许性能，并不会让结果出现重解
                         */
                        m++;
                    else if (sum > target)
                        /**
                         * 同理，没必要确认nums[j]是新值
                         */
                        n--;
                }
            }
        }
        return list;
    }
}
// @lc code=end
