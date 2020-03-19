/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len == 1)
            return;
        if (len == 2){
            reverse(nums, 0, 2);
            return;
        }
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                // 在index为i+1到len-1中找到了最小的大于nums[i]的数
                // 并swap(i,j)再对i+1,len-1做一次reverse
                for (int j = len - 1; j > i; j--) {
                    if(nums[j] > nums[i]){
                        swap(nums,i,j);
                        reverse(nums,i+1,len-i-1);
                        return;
                    }
                }
            }
        }
        reverse(nums,0,len);
        return;
    }

    public void reverse(int[] nums, int off, int len) {
        for (int i = 0; i < len / 2; i++)
            swap(nums, off + i, off + len - i - 1);
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
// @lc code=end
