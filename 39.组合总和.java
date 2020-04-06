import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        LinkedList<Integer> temp = new LinkedList<>();
        dfs(temp, 0, target,0, candidates);
        return res;
    }

    public void dfs(LinkedList<Integer> a, int sum, int target,int begin, int[] candidates) {
        if (sum < target) {
            for (int i = begin; i < candidates.length; i++) {
                if(candidates[i]+sum > target) break;
                a.add(candidates[i]);
                dfs(a,sum+candidates[i],target,i,candidates);
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
