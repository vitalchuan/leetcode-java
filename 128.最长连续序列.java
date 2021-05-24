import java.util.Set;

/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> dict = new HashSet<>();
        int max = 0;

        for (int i : nums) {
            dict.add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            int left = nums[i];
            if (dict.contains(left - 1))
                continue;

            int next = left + 1;
            int count = 1;
            while (dict.contains(next)) {
                count = count + 1;
                next = next + 1;
            }
            max = Math.max(max, count);
        }

        return max;
        // Set<Integer> num_set = new HashSet<Integer>();
        // for (int num : nums) {
        // num_set.add(num);
        // }

        // int longestStreak = 0;

        // for (int num : num_set) {
        // if (!num_set.contains(num - 1)) {
        // int currentNum = num;
        // int currentStreak = 1;

        // while (num_set.contains(currentNum + 1)) {
        // currentNum += 1;
        // currentStreak += 1;
        // }

        // longestStreak = Math.max(longestStreak, currentStreak);
        // }
        // }

        // return longestStreak;
    }
}
// @lc code=end
