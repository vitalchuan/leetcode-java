import java.util.*;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int[] visited = new int[nums.length];
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> current = new LinkedList<>();

        dfs(res, current, visited, nums);

        return res;
    }

    public void dfs(List<List<Integer>> res, LinkedList<Integer> current, int[] visited, int[] nums) {
        if (current.size() == nums.length) {
            res.add(new LinkedList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1)
                continue;
            visited[i] = 1;
            current.add(nums[i]);
            dfs(res, current, visited, nums);
            current.removeLast();
            visited[i] = 0;
        }
    }
}
// @lc code=end
