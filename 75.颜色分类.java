/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case 0:
                    count[0]++;
                    break;
                case 1:
                    count[1]++;
                    break;
                case 2:
                    count[2]++;
                    break;
                default:
                    break;
            }
        }

        int index = 0;
        for (int j = 0; j < count[0]; j++) {
            nums[index++] = 0;
        }

        for (int j = 0; j < count[1]; j++) {
            nums[index++] = 1;
        }

        for (int j = 0; j < count[2]; j++) {
            nums[index++] = 2;
        }
    }
}
// @lc code=end
