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
        int counts = 1;
        while (i != nums.length - 1) {
            i++;
            if (nums[i] == nums[i - 1]) {
                counts++;
                if (counts <= 2) {
                    j++;
                    nums[j] = nums[i];
                } else {
                    len--;
                }
            } else { // 前指针的值遇到变化
                counts = 1; // 计数器归位
                j++;
                nums[j] = nums[i];
            }
        }
        return len;
    }
}
// @lc code=end
