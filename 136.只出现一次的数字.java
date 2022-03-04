import java.util.Set;

/*
 * @lc app=leetcode.cn id=136 lang=java
 *
 * [136] 只出现一次的数字
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        // Set<Integer> set = new HashSet<>();
        // for (int i = 0; i < nums.length; i++)
        // if (set.contains(nums[i]))
        // set.remove(nums[i]);
        // else
        // set.add(nums[i]);

        // for (Integer a : set)
        // return a;

        // return 0;

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
}
// @lc code=end
