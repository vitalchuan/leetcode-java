/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 0;
        while(i < nums.length){
            if(nums[i] != val){
                nums[j] = nums[i];
                j++;
            }
            i++;
        }
        return j;
    }
}
// @lc code=end

