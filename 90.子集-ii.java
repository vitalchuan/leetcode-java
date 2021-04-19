import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> current = new LinkedList<>();
        dfs(res, current, -1, nums);
        return res;
    }

    public void dfs(List<List<Integer>> res, LinkedList<Integer> current, int lastIndex, int[] nums) {
        res.add(new LinkedList<>(current));
        for (int i = lastIndex + 1; i < nums.length; i++) {
            if (i == lastIndex + 1) {
                current.add(nums[i]);
                dfs(res, current, i, nums);
                current.removeLast();
            } else {
                if (nums[i] == nums[i - 1])
                    continue;
                else {
                    current.add(nums[i]);
                    dfs(res, current, i, nums);
                    current.removeLast();
                }
            }
        }
    }
}
// @lc code=end
