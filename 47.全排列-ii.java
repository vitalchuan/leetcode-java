
/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */
import java.util.*;

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> current = new LinkedList<>();
        int[] visited = new int[nums.length];
        dfs(res, current, nums, visited);

        return res;
    }

    void dfs(List<List<Integer>> res, LinkedList<Integer> current, int[] nums, int[] visited) {
        if (current.size() == nums.length) {
            res.add(new LinkedList<>(current));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1)
                continue;
            if (i != 0 && visited[i - 1] == 0 && nums[i] == nums[i - 1])
                continue;
            visited[i] = 1;
            current.add(nums[i]);
            dfs(res, current, nums, visited);
            current.removeLast();
            visited[i] = 0;
        }
    }
}
// @lc code=end
