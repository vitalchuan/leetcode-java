
/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */
import java.util.*;

// @lc code=start
class Solution {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        LinkedList<Integer> temp = new LinkedList<>();
        dfs(temp, 0, target, -1, candidates);
        return res;
    }

    public void dfs(LinkedList<Integer> a, int sum, int target, int begin, int[] candidates) {
        if (sum < target) {
            for (int i = begin + 1; i < candidates.length; i++) {
                if (candidates[i] + sum > target)
                    break;
                if ((i - 1) > begin && candidates[i] == candidates[i - 1])
                    continue;
                a.add(candidates[i]);
                dfs(a, sum + candidates[i], target, i, candidates);
                a.removeLast();
            }
        } else if (sum == target) {
            res.add(new LinkedList<>(a));
        } else if (sum > target) {
            return;
        }
    }
}
// @lc code=end
