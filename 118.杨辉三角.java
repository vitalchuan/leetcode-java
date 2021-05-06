/*
 * @lc app=leetcode.cn id=118 lang=java
 *
 * [118] 杨辉三角
 */

// @lc code=start
class Solution {
    public List<List<Integer>> generate(int numRows) {
        int[][] nums = new int[numRows][numRows];
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> current = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0)
                    nums[i][j] = 1;
                else
                    nums[i][j] = nums[i - 1][j - 1] + nums[i - 1][j];
                current.add(nums[i][j]);
            }
        }

        for (int i = 0; i < numRows; i++) {
            current = new LinkedList<>();
            for (int j = 0; j <= i; j++) {
                current.add(nums[i][j]);
            }
            res.add(current);
        }

        return res;
    }
}
// @lc code=end
