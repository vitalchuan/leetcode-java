/*
 * @lc app=leetcode.cn id=135 lang=java
 *
 * [135] 分发糖果
 */

// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        int[] gains = new int[ratings.length];
        int sum = 1;
        int min = 1;
        gains[0] = 1;
        for (int i = 0; i < ratings.length; i++) {
            if (i == 0)
                continue;
            if (ratings[i] > ratings[i - 1])
                gains[i] = gains[i - 1] + 1;
            else
                gains[i] = gains[i - 1] - 1;

            if (gains[i] < min)
                min = gains[i];

            sum += gains[i];
        }

        return sum - gains.length * (
            min - 1);

    }
}
// @lc code=end
