import jdk.tools.jlink.internal.plugins.LegalNoticeFilePlugin;

/*
 * @lc app=leetcode.cn id=80 lang=java
 *
 * [80] 删除排序数组中的重复项 II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        int len = nums.length;
        while (i != nums.length - 1) {
            i++;
            if (nums[i] == nums[i - 1]) {
                counts++;
                if (counts >= 3)
                    len--;
            } else {
                counts = 1;
            }
        }
    }
}
// @lc code=end
