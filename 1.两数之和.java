import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hMap=new HashMap<>();
        // HashSet<Integer> hSet=new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            int complement=target-nums[i];
            if(!hMap.containsKey(complement))
                hMap.put(nums[i], i);
            else
                return new int[]{hMap.get(complement),i};
        }
        return null;
    }
}

