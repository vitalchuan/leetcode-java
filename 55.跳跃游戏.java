/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        //不断维护一个最远距离reach
        //如果reach到达了nums.length，则返回true
        int len = nums.length;
        int reach = 0;
        for(int i = 0;i<nums.length;i++){
            int step = nums[i];
            if(i <= reach){
                reach = Math.max(reach,i+nums[i]);
            }
            else{
                return false;
            }
            if(reach >= len-1) return true;
        }
        if(reach >= len-1) return true;
        else return false;

    }
}
// @lc code=end

